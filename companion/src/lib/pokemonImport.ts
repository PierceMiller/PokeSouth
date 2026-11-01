export type ImportedPokemon = {
  source: string;
  source_key: string;
  pokemon_id: number | null;
  species_name: string;
  form: string | null;
  nickname: string | null;
  cp: number | null;
  hp: number | null;
  iv_attack: number | null;
  iv_defense: number | null;
  iv_stamina: number | null;
  iv_percent: number | null;
  level: number | null;
  fast_move: string | null;
  charged_move: string | null;
  is_shiny: boolean;
  is_lucky: boolean;
  is_shadow: boolean;
  is_purified: boolean;
  caught_at: string | null;
  raw_data: Record<string, string>;
};

function parseCsv(text: string): string[][] {
  const rows: string[][] = [];
  let row: string[] = [];
  let cell = '';
  let quoted = false;
  const input = text.replace(/^\uFEFF/, '');
  for (let i = 0; i < input.length; i++) {
    const ch = input[i];
    if (ch === '"' && quoted && input[i + 1] === '"') { cell += '"'; i++; }
    else if (ch === '"') quoted = !quoted;
    else if (ch === ',' && !quoted) { row.push(cell.trim()); cell = ''; }
    else if ((ch === '\n' || ch === '\r') && !quoted) {
      if (ch === '\r' && input[i + 1] === '\n') i++;
      row.push(cell.trim()); cell = '';
      if (row.some(value => value !== '')) rows.push(row);
      row = [];
    } else cell += ch;
  }
  row.push(cell.trim());
  if (row.some(value => value !== '')) rows.push(row);
  return rows;
}

const keyName = (value: string) => value.toLowerCase().normalize('NFKD').replace(/[\u0300-\u036f]/g, '').replace(/[^a-z0-9]/g, '');
const boolValue = (value: string | undefined) => /^(true|yes|y|1|shiny|lucky|shadow|purified)$/i.test((value || '').trim());
const numberValue = (value: string | undefined): number | null => {
  if (!value) return null;
  const cleaned = value.replace(/[% ,]/g, '').trim();
  if (!cleaned || !/^-?\d+(\.\d+)?$/.test(cleaned)) return null;
  const n = Number(cleaned);
  return Number.isFinite(n) ? n : null;
};
const pick = (row: Record<string, string>, names: string[]) => {
  for (const name of names) {
    const value = row[keyName(name)];
    if (value !== undefined && value !== '') return value;
  }
  return undefined;
};
const dateValue = (value: string | undefined): string | null => {
  if (!value) return null;
  const iso = value.match(/^(\d{4})[-/.](\d{1,2})[-/.](\d{1,2})/);
  if (iso) return `${iso[1]}-${iso[2].padStart(2, '0')}-${iso[3].padStart(2, '0')}`;
  const us = value.match(/^(\d{1,2})[-/.](\d{1,2})[-/.](\d{4})/);
  if (us) return `${us[3]}-${us[1].padStart(2, '0')}-${us[2].padStart(2, '0')}`;
  return null;
};
function hash(value: string): string {
  let h = 2166136261;
  for (let i = 0; i < value.length; i++) { h ^= value.charCodeAt(i); h = Math.imul(h, 16777619); }
  return (h >>> 0).toString(16).padStart(8, '0');
}

export function parsePokemonCsv(text: string): { rows: ImportedPokemon[]; errors: string[] } {
  const matrix = parseCsv(text);
  if (matrix.length < 2) return { rows: [], errors: ['The CSV looks empty or has no data rows.'] };
  const headers = matrix[0].map(keyName);
  const rows: ImportedPokemon[] = [];
  const errors: string[] = [];
  const duplicateCounts = new Map<string, number>();
  for (let index = 1; index < matrix.length; index++) {
    const values = matrix[index];
    if (!values.some(value => value.trim())) continue;
    const raw: Record<string, string> = {};
    headers.forEach((header, i) => { raw[header] = values[i] ?? ''; });
    const species = pick(raw, ['Pokémon', 'Pokemon', 'Species', 'Species Name', 'Name', 'Pokémon Name']);
    if (!species) { errors.push(`Row ${index + 1}: no Pokémon name was found.`); continue; }
    const dex = numberValue(pick(raw, ['Pokédex', 'Pokedex', 'Dex', 'Dex Number', 'Pokédex Number', 'Pokemon ID', 'Pokémon ID']));
    const cp = numberValue(pick(raw, ['CP', 'Combat Power']));
    const attack = numberValue(pick(raw, ['Attack IV', 'IV Attack', 'Attack', 'Atk']));
    const defense = numberValue(pick(raw, ['Defense IV', 'Defence IV', 'IV Defense', 'IV Defence', 'Defense', 'Defence', 'Def']));
    const stamina = numberValue(pick(raw, ['Stamina IV', 'HP IV', 'IV Stamina', 'Stamina', 'HP']));
    const ivPercent = numberValue(pick(raw, ['IV%', 'IV Percent', 'IV Percentage', 'Percentage IV']));
    const rawJson = JSON.stringify(raw);
    const occurrenceKey = `${species.toLowerCase()}|${cp ?? ''}|${attack ?? ''}|${defense ?? ''}|${stamina ?? ''}|${rawJson}`;
    const occurrence = (duplicateCounts.get(occurrenceKey) || 0) + 1;
    duplicateCounts.set(occurrenceKey, occurrence);
    rows.push({
      source: 'poke genie',
      source_key: hash(`${occurrenceKey}|${occurrence}`),
      pokemon_id: dex && dex > 0 ? dex : null,
      species_name: species.trim(),
      form: pick(raw, ['Form', 'Variant', 'Costume']) || null,
      nickname: pick(raw, ['Nickname', 'Custom Name']) || null,
      cp: cp !== null && cp >= 0 ? Math.round(cp) : null,
      hp: numberValue(pick(raw, ['HP', 'Hit Points'])),
      iv_attack: attack !== null && attack >= 0 && attack <= 15 ? Math.round(attack) : null,
      iv_defense: defense !== null && defense >= 0 && defense <= 15 ? Math.round(defense) : null,
      iv_stamina: stamina !== null && stamina >= 0 && stamina <= 15 ? Math.round(stamina) : null,
      iv_percent: ivPercent !== null ? (ivPercent <= 1 ? ivPercent * 100 : ivPercent) : (attack !== null && defense !== null && stamina !== null ? Math.round(((attack + defense + stamina) / 45) * 10000) / 100 : null),
      level: numberValue(pick(raw, ['Level', 'Pokémon Level', 'Pokemon Level'])),
      fast_move: pick(raw, ['Fast Move', 'Quick Move', 'Fast Attack']) || null,
      charged_move: pick(raw, ['Charged Move', 'Charge Move', 'Special Move', 'Charged Attack']) || null,
      is_shiny: boolValue(pick(raw, ['Shiny', 'Is Shiny'])),
      is_lucky: boolValue(pick(raw, ['Lucky', 'Is Lucky'])),
      is_shadow: boolValue(pick(raw, ['Shadow', 'Is Shadow'])),
      is_purified: boolValue(pick(raw, ['Purified', 'Is Purified'])),
      caught_at: dateValue(pick(raw, ['Date Caught', 'Caught At', 'Capture Date', 'Date'])),
      raw_data: Object.fromEntries(Object.entries(raw).map(([key, value]) => [key, value])),
    });
  }
  if (!rows.length && !errors.length) errors.push('No recognizable Pokémon rows were found. Check that this is a companion-app Pokémon CSV export.');
  return { rows, errors };
}
