import { useEffect, useRef, useState } from 'react';
import type { User } from '@supabase/supabase-js';
import { AlertCircle, Check, FileSpreadsheet, RefreshCw, Upload } from 'lucide-react';
import { supabase } from './lib/supabase';
import { parsePokemonCsv, type ImportedPokemon } from './lib/pokemonImport';

type SavedPokemon = ImportedPokemon & { id: string; imported_at: string };

export default function PokemonImportPanel({ user }: { user: User }) {
  const inputRef = useRef<HTMLInputElement>(null);
  const [preview, setPreview] = useState<ImportedPokemon[]>([]);
  const [saved, setSaved] = useState<SavedPokemon[]>([]);
  const [fileName, setFileName] = useState('');
  const [parseErrors, setParseErrors] = useState<string[]>([]);
  const [loading, setLoading] = useState(true);
  const [importing, setImporting] = useState(false);
  const [message, setMessage] = useState('');
  const [error, setError] = useState('');

  const loadSaved = async () => {
    setLoading(true);
    const { data, error: queryError } = await supabase
      .from('pokemon_inventory')
      .select('id,source,source_key,pokemon_id,species_name,form,nickname,cp,hp,iv_attack,iv_defense,iv_stamina,iv_percent,level,fast_move,charged_move,is_shiny,is_lucky,is_shadow,is_purified,caught_at,raw_data,imported_at')
      .eq('user_id', user.id)
      .order('imported_at', { ascending: false })
      .limit(5000);
    if (queryError) setError(`Could not load imported Pokémon: ${queryError.message}`);
    else setSaved((data || []) as SavedPokemon[]);
    setLoading(false);
  };

  useEffect(() => { void loadSaved(); }, [user.id]);

  const chooseFile = async (file?: File) => {
    if (!file) return;
    setError(''); setMessage(''); setPreview([]); setParseErrors([]);
    if (!/\.csv$/i.test(file.name) && file.type !== 'text/csv' && file.type !== 'application/vnd.ms-excel') {
      setError('Please choose a CSV export file. The file is read locally in your browser.');
      return;
    }
    if (file.size > 15 * 1024 * 1024) {
      setError('This CSV is larger than 15 MB. Export a smaller file and try again.');
      return;
    }
    try {
      const text = await file.text();
      const result = parsePokemonCsv(text);
      setFileName(file.name);
      setPreview(result.rows);
      setParseErrors(result.errors.slice(0, 8));
      if (!result.rows.length) setError(result.errors[0] || 'No Pokémon rows could be read from this file.');
      else setMessage(`Read ${result.rows.length.toLocaleString()} Pokémon from ${file.name}. Nothing has been uploaded yet.`);
    } catch {
      setError('The file could not be read. Please export it again as CSV.');
    }
  };

  const importRows = async () => {
    if (!preview.length) return;
    setImporting(true); setError(''); setMessage('');
    const chunkSize = 200;
    let count = 0;
    try {
      for (let i = 0; i < preview.length; i += chunkSize) {
        const batch = preview.slice(i, i + chunkSize).map(row => ({ ...row, user_id: user.id, imported_at: new Date().toISOString(), updated_at: new Date().toISOString() }));
        const { error: upsertError } = await supabase.from('pokemon_inventory').upsert(batch, { onConflict: 'user_id,source,source_key' });
        if (upsertError) throw upsertError;
        count += batch.length;
      }
      setMessage(`Imported ${count.toLocaleString()} Pokémon. Re-importing the same export updates matching records instead of creating duplicates.`);
      setPreview([]);
      if (inputRef.current) inputRef.current.value = '';
      await loadSaved();
    } catch (e) {
      setError(`Import stopped after ${count.toLocaleString()} rows: ${e instanceof Error ? e.message : 'Unknown database error'}. Successfully imported batches remain saved; you can safely retry the same file.`);
    } finally { setImporting(false); }
  };

  return (
    <section className="panel import-panel">
      <div className="panel-heading">
        <div><h3><FileSpreadsheet size={17} /> Import your actual Pokémon</h3><p>Bring in a CSV export from PokéGenie or a compatible collection tool.</p></div>
        <button className="icon-button small-icon" onClick={() => void loadSaved()} aria-label="Refresh imported Pokémon" disabled={loading}><RefreshCw size={16}/></button>
      </div>
      <div className="import-safety"><AlertCircle size={17}/><span>No Pokémon GO login is needed. Your CSV is parsed in this browser; only the selected collection records are sent to your signed-in PokéSouth account. This is an import, not a live game connection.</span></div>
      <input ref={inputRef} className="file-input-hidden" type="file" accept=".csv,text/csv" onChange={e => void chooseFile(e.target.files?.[0])} />
      <div className="import-actions">
        <button className="primary-button" onClick={() => inputRef.current?.click()}><Upload size={16}/> Choose CSV export</button>
        <span className="import-muted">CSV only · up to 15 MB</span>
      </div>
      {fileName && <p className="import-file"><FileSpreadsheet size={15}/>{fileName}</p>}
      {message && <div className="import-success" role="status"><Check size={16}/>{message}</div>}
      {error && <div className="import-error" role="alert"><AlertCircle size={16}/>{error}</div>}
      {parseErrors.length > 0 && <div className="import-warnings"><strong>Some rows need checking</strong>{parseErrors.map((item, i) => <span key={i}>{item}</span>)}</div>}
      {preview.length > 0 && <>
        <div className="import-preview-heading"><strong>Preview · {preview.length.toLocaleString()} rows</strong><button className="primary-button" onClick={() => void importRows()} disabled={importing}>{importing ? 'Importing…' : `Import ${preview.length.toLocaleString()} Pokémon`}</button></div>
        <div className="import-table-wrap"><table className="import-table"><thead><tr><th>Pokémon</th><th>CP</th><th>IV</th><th>Flags</th></tr></thead><tbody>{preview.slice(0, 12).map((p, i) => <tr key={p.source_key + i}><td><strong>{p.nickname || p.species_name}</strong>{p.nickname && <small>{p.species_name}</small>}</td><td>{p.cp ?? '—'}</td><td>{p.iv_percent !== null ? `${p.iv_percent}%` : '—'}</td><td>{[p.is_shiny && 'Shiny', p.is_lucky && 'Lucky', p.is_shadow && 'Shadow', p.is_purified && 'Purified'].filter(Boolean).join(' · ') || '—'}</td></tr>)}</tbody></table>{preview.length > 12 && <p className="import-muted">Showing first 12 rows in preview; all {preview.length.toLocaleString()} will be imported.</p>}</div>
      </>}
      <div className="import-saved-heading"><div><h4>Your imported inventory</h4><p>{loading ? 'Loading your saved records…' : `${saved.length.toLocaleString()} individual Pokémon saved in your cloud account`}</p></div></div>
      {!loading && saved.length > 0 && <div className="import-table-wrap"><table className="import-table"><thead><tr><th>Pokémon</th><th>CP</th><th>IV</th><th>Traits</th></tr></thead><tbody>{saved.slice(0, 30).map(p => <tr key={p.id}><td><strong>{p.nickname || p.species_name}</strong>{p.nickname && <small>{p.species_name}</small>}</td><td>{p.cp ?? '—'}</td><td>{p.iv_percent !== null ? `${p.iv_percent}%` : p.iv_attack !== null && p.iv_defense !== null && p.iv_stamina !== null ? `${p.iv_attack}/${p.iv_defense}/${p.iv_stamina}` : '—'}</td><td>{[p.is_shiny && 'Shiny', p.is_lucky && 'Lucky', p.is_shadow && 'Shadow', p.is_purified && 'Purified'].filter(Boolean).join(' · ') || '—'}</td></tr>)}</tbody></table>{saved.length > 30 && <p className="import-muted">Showing 30 of {saved.length.toLocaleString()} saved records.</p>}</div>}
      {!loading && saved.length === 0 && <p className="import-empty">No imported Pokémon yet. Export your collection from your companion app, then choose the CSV here.</p>}
    </section>
  );
}
