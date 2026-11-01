import { useEffect, useMemo, useState } from 'react';
import type { User } from '@supabase/supabase-js';
import { supabase } from './lib/supabase';
import PokemonImportPanel from './PokemonImportPanel';
import {
  Activity, Bell, CalendarDays, Check, ChevronDown, CircleHelp, Compass, Flame,
  Grid2X2, Heart, Menu, Plus, Search, Settings2, Shield, Sparkles, Swords,
  Target, Trophy, X, Zap
} from 'lucide-react';

type Pokemon = {
  id: number; name: string; type: string; rarity: string; cp: number; goal: string;
};

const pokemon: Pokemon[] = [
  { id: 25, name: 'Pikachu', type: 'Electric', rarity: 'Uncommon', cp: 938, goal: 'Shiny hunt' },
  { id: 150, name: 'Mewtwo', type: 'Psychic', rarity: 'Legendary', cp: 3982, goal: 'Power up' },
  { id: 6, name: 'Charizard', type: 'Fire · Flying', rarity: 'Rare', cp: 2889, goal: 'Mega energy' },
  { id: 448, name: 'Lucario', type: 'Fighting · Steel', rarity: 'Rare', cp: 2460, goal: 'Raid attacker' },
  { id: 94, name: 'Gengar', type: 'Ghost · Poison', rarity: 'Rare', cp: 2218, goal: 'Mega evolve' },
  { id: 249, name: 'Lugia', type: 'Psychic · Flying', rarity: 'Legendary', cp: 3105, goal: 'Hundo target' },
  { id: 384, name: 'Rayquaza', type: 'Dragon · Flying', rarity: 'Legendary', cp: 3545, goal: 'Mega evolve' },
  { id: 445, name: 'Garchomp', type: 'Dragon · Ground', rarity: 'Rare', cp: 3001, goal: 'Power up' },
  { id: 4481, name: 'Umbreon', type: 'Dark', rarity: 'Uncommon', cp: 1660, goal: 'PvP build' },
  { id: 133, name: 'Eevee', type: 'Normal', rarity: 'Common', cp: 721, goal: 'Evolution goal' },
  { id: 3841, name: 'Dragonite', type: 'Dragon · Flying', rarity: 'Rare', cp: 3120, goal: 'Raid attacker' },
  { id: 487, name: 'Giratina', type: 'Ghost · Dragon', rarity: 'Legendary', cp: 3379, goal: 'PvP build' },
];

const navItems = [
  { id: 'Overview', icon: Grid2X2 },
  { id: 'Pokédex', icon: Compass },
  { id: 'Hundo Hunter', icon: Target },
  { id: 'Raid Lab', icon: Swords },
  { id: 'PvP Lab', icon: Shield },
  { id: 'Events', icon: CalendarDays },
  { id: 'Collection', icon: Trophy },
];

const sprite = (id: number) => {
  const normalized = id === 4481 ? 197 : id === 3841 ? 149 : id === 487 ? 487 : id === 448 ? 448 : id === 384 ? 384 : id;
  return `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${normalized}.png`;
};

function Dashboard({ user, onSignOut }: { user: User; onSignOut: () => Promise<void> }) {
  const [active, setActive] = useState('Overview');
  const [query, setQuery] = useState('');
  const [filter, setFilter] = useState('All');
  const [owned, setOwned] = useState<number[]>(() => {
    try { return JSON.parse(localStorage.getItem('pokego-owned') || '[25,6,133]') as number[]; }
    catch { return [25, 6, 133]; }
  });
  const [targets, setTargets] = useState<string[]>(() => {
    try { return JSON.parse(localStorage.getItem('pokego-targets') || '["Find a perfect IV Pokémon","Build a raid-ready team"]') as string[]; }
    catch { return ['Find a perfect IV Pokémon', 'Build a raid-ready team']; }
  });
  const [showAdd, setShowAdd] = useState(false);
  const [newTarget, setNewTarget] = useState('');
  const [mobileMenu, setMobileMenu] = useState(false);
  const [notice, setNotice] = useState('');

  useEffect(() => {
    const handler = (event: Event) => {
      setNotice((event as CustomEvent<string>).detail);
      window.setTimeout(() => setNotice(''), 3200);
    };
    window.addEventListener('pokesouth:notice', handler);
    return () => window.removeEventListener('pokesouth:notice', handler);
  }, []);

  const collection = useMemo(() => pokemon.filter(p => {
    const matchesQuery = p.name.toLowerCase().includes(query.toLowerCase()) || p.type.toLowerCase().includes(query.toLowerCase());
    const matchesFilter = filter === 'All' || (filter === 'Owned' ? owned.includes(p.id) : filter === 'Targets' ? targets.some(t => t.toLowerCase().includes(p.name.toLowerCase())) : p.rarity === filter);
    return matchesQuery && matchesFilter;
  }), [query, filter, owned, targets]);

  const toggleOwned = (id: number) => {
    const next = owned.includes(id) ? owned.filter(n => n !== id) : [...owned, id];
    setOwned(next);
    localStorage.setItem('pokego-owned', JSON.stringify(next));
    window.dispatchEvent(new Event('pokesouth:local-change'));
    setNotice(next.includes(id) ? 'Added to your collection' : 'Removed from your collection');
    window.setTimeout(() => setNotice(''), 2200);
  };

  const addTarget = () => {
    const value = newTarget.trim();
    if (!value) return;
    const next = [...targets, value];
    setTargets(next);
    localStorage.setItem('pokego-targets', JSON.stringify(next));
    window.dispatchEvent(new Event('pokesouth:local-change'));
    setNewTarget('');
    setShowAdd(false);
  };

  const isDex = active === 'Pokédex' || active === 'Collection' || active === 'Hundo Hunter';
  const title = active === 'Overview' ? 'Your adventure, organised.' : active;
  const subtitle = active === 'Overview'
    ? 'One place for your goals, collection and next big catch.'
    : active === 'Pokédex' ? 'Explore species and keep track of what you have.'
    : active === 'Hundo Hunter' ? 'Keep your perfect-IV ambitions in sight.'
    : active === 'Collection' ? 'Your personal collection tracker.'
    : active === 'Raid Lab' ? 'Plan stronger teams before the raid starts.'
    : active === 'PvP Lab' ? 'Build smarter teams for every league.'
    : active === 'Events' ? 'Keep your next Pokémon GO plans in view.'
    : 'Your Pokémon GO companion.';

  return (
    <div className="app-shell">
      <aside className={`sidebar ${mobileMenu ? 'sidebar-open' : ''}`}>
        <div className="brand">
          <div className="brand-mark"><Sparkles size={21} /></div>
          <div><strong>POKÉ<span>COMPANION</span></strong><small>YOUR GO COMMAND CENTRE</small></div>
          <button className="icon-button close-menu" onClick={() => setMobileMenu(false)} aria-label="Close menu"><X size={19}/></button>
        </div>
        <div className="profile-chip"><div className="avatar">{(user.email || "P").slice(0,1).toUpperCase()}</div><div className="profile-text"><strong>Trainer profile</strong><small>{user.email || "Signed in"}</small></div><ChevronDown size={15} className="muted-icon"/></div>
        <div className="nav-label">WORKSPACE</div>
        <nav>
          {navItems.map(item => {
            const Icon = item.icon;
            return <button key={item.id} className={`nav-item ${active === item.id ? 'active' : ''}`} onClick={() => { setActive(item.id); setMobileMenu(false); }}>
              <Icon size={18}/><span>{item.id}</span>{item.id === 'Hundo Hunter' && <span className="nav-dot"/>}
            </button>;
          })}
        </nav>
        <div className="sidebar-bottom">
          <div className="upgrade-card"><div className="upgrade-icon"><Zap size={17}/></div><strong>Your next level</strong><p>Small goals add up to big adventures.</p><button onClick={() => setActive('Hundo Hunter')}>View goals <span>↗</span></button></div>
          <button className="nav-item settings-item" onClick={() => setNotice('Settings and integrations are coming in the next build.')}><Settings2 size={18}/><span>Settings</span></button>
          <div className="version-note"><span className="online-dot"/> Personal edition <span>v0.1</span></div>
        </div>
      </aside>

      {mobileMenu && <button className="scrim" aria-label="Close navigation" onClick={() => setMobileMenu(false)}/>}
      <main className="main-area">
        <header className="topbar">
          <button className="icon-button menu-button" aria-label="Open navigation" onClick={() => setMobileMenu(true)}><Menu size={21}/></button>
          <div className="breadcrumbs"><span>Workspace</span><span className="crumb-slash">/</span><strong>{active}</strong></div>
          <div className="top-actions"><span className="sync-status"><span className="online-dot"/> Cloud sync enabled</span><button className="icon-button" aria-label="Notifications" onClick={() => setNotice('Automated alerts will be available in a later build.')}><Bell size={18}/></button><button className="signout-button" onClick={() => void onSignOut()}>Sign out</button></div>
        </header>

        <div className="page-content">
          <section className="welcome-row">
            <div><div className="eyebrow"><span className="eyebrow-line"/> YOUR TRAINER DASHBOARD</div><h1>{title}</h1><p className="page-subtitle">{subtitle}</p></div>
            <div className="date-pill"><Activity size={15}/> PERSONAL TRACKER</div>
          </section>

          {active === 'Overview' && <>
            <section className="hero-banner">
              <div className="hero-copy"><div className="hero-kicker"><Sparkles size={14}/> YOUR JOURNEY, YOUR WAY</div><h2>Every great trainer<br/>starts with <em>a goal.</em></h2><p>Track your collection, chase your hundos, and make every adventure count.</p><button className="primary-button" onClick={() => setActive('Hundo Hunter')}>Explore your goals <span>↗</span></button></div>
              <div className="hero-orb orb-one"/><div className="hero-orb orb-two"/><div className="hero-art"><img src={sprite(25)} alt="Pikachu" /><div className="art-glow"/><div className="floating-chip chip-top"><Sparkles size={13}/> YOUR NEXT HUNDO</div><div className="floating-chip chip-bottom"><Flame size={14}/> KEEP THE STREAK ALIVE</div></div>
              <div className="hero-index">01 <span>/ 04</span></div>
            </section>
            <section className="stat-grid">
              <Stat icon={<Grid2X2 size={17}/>} label="TRACKED SPECIES" value={String(owned.length)} note="In your personal collection" tone="purple"/>
              <Stat icon={<Target size={17}/>} label="ACTIVE GOALS" value={String(targets.length)} note="Keep your next target close" tone="orange"/>
              <Stat icon={<Heart size={17}/>} label="SHINY TARGETS" value="—" note="Set up your shiny checklist" tone="pink"/>
              <Stat icon={<Zap size={17}/>} label="RAID READINESS" value="—" note="Team analysis coming soon" tone="blue"/>
            </section>
            <div className="section-heading"><div><div className="eyebrow">YOUR PERSONAL PLAN</div><h2>Today's priorities</h2></div><button className="text-button" onClick={() => setActive('Hundo Hunter')}>All goals <span>↗</span></button></div>
            <section className="lower-grid">
              <div className="panel goals-panel"><div className="panel-heading"><div><h3>Trainer checklist</h3><p>Make progress at your own pace.</p></div><button className="icon-button small-icon" onClick={() => setShowAdd(true)} aria-label="Add goal"><Plus size={18}/></button></div>
                <div className="goal-list">{targets.map((target, i) => <div className="goal-row" key={target}><button className="goal-check" aria-label="Complete goal" onClick={() => { const next = targets.filter(t => t !== target); setTargets(next); localStorage.setItem('pokego-targets', JSON.stringify(next)); window.dispatchEvent(new Event('pokesouth:local-change')); }}><Check size={14}/></button><span>{target}</span><span className="goal-number">{String(i + 1).padStart(2,'0')}</span></div>)}{targets.length === 0 && <p className="empty-state">All clear! Add a new goal when you're ready.</p>}</div>
                <button className="add-goal-button" onClick={() => setShowAdd(true)}><Plus size={16}/> Add a personal goal</button>
              </div>
              <div className="panel picks-panel"><div className="panel-heading"><div><h3>Worth a closer look</h3><p>A few species on your radar.</p></div><button className="text-button" onClick={() => setActive('Pokédex')}>Browse <span>↗</span></button></div>
                <div className="mini-pokemon-list">{[pokemon[1],pokemon[5],pokemon[6]].map((p, i) => <button className="mini-pokemon" key={p.id} onClick={() => setActive('Pokédex')}><div className={`mini-art mini-${i}`}><img src={sprite(p.id)} alt={p.name}/></div><div className="mini-details"><strong>{p.name}</strong><small>{p.goal}</small></div><span className="mini-arrow">↗</span></button>)}</div>
              </div>
            </section>
          </>}

          {active === 'Collection' && <PokemonImportPanel user={user} />}

          {isDex && <section className="panel dex-panel">
            <div className="dex-toolbar"><div className="search-field"><Search size={17}/><input value={query} onChange={e => setQuery(e.target.value)} placeholder="Search Pokémon or type..." aria-label="Search Pokémon"/></div><select value={filter} onChange={e => setFilter(e.target.value)} aria-label="Filter collection"><option>All</option><option>Owned</option><option>Targets</option><option>Legendary</option><option>Rare</option><option>Common</option><option>Uncommon</option></select></div>
            <div className="dex-summary"><span><strong>{collection.length}</strong> species shown</span><span><span className="online-dot"/> Collection synced to your account</span></div>
            <div className="pokemon-grid">{collection.map(p => <article className="pokemon-card" key={p.id}><div className={`pokemon-art type-${p.type.split(' ')[0].toLowerCase()}`}><span className="pokedex-number">#{String(p.id).padStart(3,'0')}</span><button className={`heart-button ${owned.includes(p.id) ? 'is-owned' : ''}`} onClick={() => toggleOwned(p.id)} aria-label={owned.includes(p.id) ? 'Remove from collection' : 'Add to collection'}><Heart size={16} fill={owned.includes(p.id) ? 'currentColor' : 'none'}/></button><img src={sprite(p.id)} alt={p.name} loading="lazy" onError={e => { (e.currentTarget as HTMLImageElement).style.opacity = '0.25'; }}/></div><div className="pokemon-info"><div><h3>{p.name}</h3><p>{p.type}</p></div><span className={`rarity rarity-${p.rarity.toLowerCase()}`}>{p.rarity}</span></div><div className="pokemon-footer"><span>CP reference</span><strong>{p.cp.toLocaleString()}</strong></div><button className={`collection-button ${owned.includes(p.id) ? 'collected' : ''}`} onClick={() => toggleOwned(p.id)}>{owned.includes(p.id) ? <><Check size={14}/> In collection</> : <><Plus size={14}/> Add to collection</>}</button></article>)}</div>
            {collection.length === 0 && <div className="empty-state large-empty"><CircleHelp size={25}/><strong>No Pokémon found</strong><span>Try another search or change the filter.</span></div>}
            <p className="data-disclaimer">Starter catalogue for interface testing. CP values are illustrative, not live game data. Your collection and goals sync to your signed-in Supabase account.</p>
          </section>}

          {!isDex && active !== 'Overview' && <section className="coming-panel panel"><div className="coming-icon">{active === 'Raid Lab' ? <Swords size={28}/> : active === 'PvP Lab' ? <Shield size={28}/> : active === 'Events' ? <CalendarDays size={28}/> : <Sparkles size={28}/>}</div><div className="eyebrow">ON THE ROADMAP</div><h2>{active} is being prepared.</h2><p>This section will use verified game data and your own saved goals. We're building it in stages so each feature is useful and reliable.</p><div className="coming-features"><span><Check size={15}/> Mobile-first design</span><span><Check size={15}/> Personal data support</span><span><Check size={15}/> Automation-ready architecture</span></div><button className="primary-button" onClick={() => setActive('Overview')}>Back to overview <span>↗</span></button></section>}
        </div>
        <footer className="footer"><span>POKÉ COMPANION <span className="footer-sep">·</span> PERSONAL EDITION</span><span>Independent fan project · Not affiliated with Niantic or Pokémon</span></footer>
      </main>

      {showAdd && <div className="modal-backdrop" onClick={() => setShowAdd(false)}><div className="modal" onClick={e => e.stopPropagation()}><div className="modal-title"><div><div className="eyebrow">PERSONAL CHECKLIST</div><h2>Add a goal</h2></div><button className="icon-button" onClick={() => setShowAdd(false)} aria-label="Close"><X size={19}/></button></div><p>Choose a small target for your next adventure.</p><form onSubmit={e => { e.preventDefault(); addTarget(); }}><input autoFocus value={newTarget} onChange={e => setNewTarget(e.target.value)} placeholder="e.g. Find a shiny Eevee" maxLength={90}/><button className="primary-button" type="submit"><Plus size={16}/> Add goal</button></form></div></div>}
      {notice && <div className="toast"><Check size={16}/>{notice}</div>}
      <div className="mobile-bottom-nav">{navItems.slice(0,5).map(item => { const Icon = item.icon; return <button key={item.id} className={active === item.id ? 'mobile-active' : ''} onClick={() => setActive(item.id)}><Icon size={19}/><span>{item.id === 'Hundo Hunter' ? 'Hundos' : item.id === 'Overview' ? 'Home' : item.id === 'Pokédex' ? 'Pokédex' : item.id === 'Raid Lab' ? 'Raids' : 'PvP'}</span></button>; })}</div>
    </div>
  );
}


function App() {
  const [session, setSession] = useState<{ user: User } | null>(null);
  const [loading, setLoading] = useState(true);
  const [dataReady, setDataReady] = useState(false);
  const [authMode, setAuthMode] = useState<'signin' | 'signup'>('signin');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [authBusy, setAuthBusy] = useState(false);
  const [authError, setAuthError] = useState('');
  const [authMessage, setAuthMessage] = useState('');

  useEffect(() => {
    let alive = true;
    supabase.auth.getSession().then(({ data, error }) => {
      if (!alive) return;
      if (error) setAuthError(error.message);
      setSession(data.session ? { user: data.session.user } : null);
      setLoading(false);
    });
    const { data: listener } = supabase.auth.onAuthStateChange((_event, nextSession) => {
      if (!alive) return;
      setSession(nextSession ? { user: nextSession.user } : null);
      setDataReady(false);
      setAuthError('');
    });
    return () => { alive = false; listener.subscription.unsubscribe(); };
  }, []);

  useEffect(() => {
    if (!session?.user) { setDataReady(false); return; }
    let cancelled = false;
    const userId = session.user.id;
    const hydrate = async () => {
      setDataReady(false);
      const [collectionResult, goalsResult] = await Promise.all([
        supabase.from('pokemon_collection').select('pokemon_id').eq('user_id', userId),
        supabase.from('user_goals').select('title').eq('user_id', userId).order('created_at', { ascending: true }),
      ]);
      if (cancelled) return;
      if (collectionResult.error || goalsResult.error) {
        setAuthError(`Could not load your cloud data: ${collectionResult.error?.message || goalsResult.error?.message}. Check the Supabase table permissions and RLS policies.`);
        setDataReady(true);
        return;
      }
      const remoteOwned = (collectionResult.data || []).map(row => Number(row.pokemon_id)).filter(Number.isFinite);
      const remoteGoals = (goalsResult.data || []).map(row => String(row.title));
      const legacyMigrated = localStorage.getItem('pokesouth-legacy-migrated') === 'true';
      if (!legacyMigrated && remoteOwned.length === 0 && remoteGoals.length === 0) {
        let oldOwned: number[] = [25, 6, 133];
        let oldGoals: string[] = ['Find a perfect IV Pokémon', 'Build a raid-ready team'];
        try { oldOwned = JSON.parse(localStorage.getItem('pokego-owned') || '[25,6,133]') as number[]; } catch { /* use defaults */ }
        try { oldGoals = JSON.parse(localStorage.getItem('pokego-targets') || '["Find a perfect IV Pokémon","Build a raid-ready team"]') as string[]; } catch { /* use defaults */ }
        const inserts = await Promise.all([
          oldOwned.length ? supabase.from('pokemon_collection').insert(oldOwned.map(id => ({ user_id: userId, pokemon_id: id, species_name: ({25:'Pikachu',6:'Charizard',133:'Eevee',150:'Mewtwo',94:'Gengar',249:'Lugia',384:'Rayquaza',445:'Garchomp',448:'Lucario',4481:'Umbreon',3841:'Dragonite',487:'Giratina'} as Record<number,string>)[id] || `Pokémon #${id}` }))) : Promise.resolve({ error: null }),
          oldGoals.length ? supabase.from('user_goals').insert(oldGoals.map(title => ({ user_id: userId, title }))) : Promise.resolve({ error: null }),
        ]);
        if (cancelled) return;
        if (inserts.some(result => result.error)) {
          setAuthError('Your existing local data could not be fully migrated. Your browser copy has been kept; check the database policies before trying again.');
          setDataReady(true);
          return;
        }
        localStorage.setItem('pokesouth-legacy-migrated', 'true');
        localStorage.setItem('pokego-owned', JSON.stringify(oldOwned));
        localStorage.setItem('pokego-targets', JSON.stringify(oldGoals));
      } else {
        localStorage.setItem('pokego-owned', JSON.stringify(remoteOwned));
        localStorage.setItem('pokego-targets', JSON.stringify(remoteGoals));
        localStorage.setItem('pokesouth-legacy-migrated', 'true');
      }
      setDataReady(true);
    };
    void hydrate();
    return () => { cancelled = true; };
  }, [session?.user.id]);

  useEffect(() => {
    if (!session?.user || !dataReady) return;
    let queue = Promise.resolve();
    const sync = () => {
      queue = queue.then(async () => {
        const userId = session.user.id;
        let owned: number[] = [];
        let goals: string[] = [];
        try { owned = JSON.parse(localStorage.getItem('pokego-owned') || '[]') as number[]; } catch { /* keep empty */ }
        try { goals = JSON.parse(localStorage.getItem('pokego-targets') || '[]') as string[]; } catch { /* keep empty */ }
        const names: Record<number, string> = {25:'Pikachu',150:'Mewtwo',6:'Charizard',448:'Lucario',94:'Gengar',249:'Lugia',384:'Rayquaza',445:'Garchomp',4481:'Umbreon',133:'Eevee',3841:'Dragonite',487:'Giratina'};
        const remoteCollection = await supabase.from('pokemon_collection').select('pokemon_id').eq('user_id', userId);
        if (remoteCollection.error) throw remoteCollection.error;
        const remoteIds = new Set((remoteCollection.data || []).map(row => Number(row.pokemon_id)));
        const wantedIds = new Set(owned);
        const removeIds = [...remoteIds].filter(id => !wantedIds.has(id));
        const addIds = [...wantedIds].filter(id => !remoteIds.has(id));
        if (removeIds.length) {
          const removed = await supabase.from('pokemon_collection').delete().eq('user_id', userId).in('pokemon_id', removeIds);
          if (removed.error) throw removed.error;
        }
        if (addIds.length) {
          const saved = await supabase.from('pokemon_collection').insert(addIds.map(id => ({ user_id: userId, pokemon_id: id, species_name: names[id] || `Pokémon #${id}` })));
          if (saved.error) throw saved.error;
        }
        const remoteGoals = await supabase.from('user_goals').select('title').eq('user_id', userId);
        if (remoteGoals.error) throw remoteGoals.error;
        const existingGoals = new Set((remoteGoals.data || []).map(row => String(row.title)));
        const wantedGoals = new Set(goals);
        const removeGoals = [...existingGoals].filter(title => !wantedGoals.has(title));
        const addGoals = [...wantedGoals].filter(title => !existingGoals.has(title));
        if (removeGoals.length) {
          const removed = await supabase.from('user_goals').delete().eq('user_id', userId).in('title', removeGoals);
          if (removed.error) throw removed.error;
        }
        if (addGoals.length) {
          const savedGoals = await supabase.from('user_goals').insert(addGoals.map(title => ({ user_id: userId, title })));
          if (savedGoals.error) throw savedGoals.error;
        }
      }).catch((error: unknown) => {
        const message = error instanceof Error ? error.message : 'Unknown sync error';
        window.dispatchEvent(new CustomEvent('pokesouth:sync-error', { detail: message }));
      });
    };
    const onChange = () => sync();
    const onSyncError = (event: Event) => {
      const detail = (event as CustomEvent<string>).detail;
      window.dispatchEvent(new CustomEvent('pokesouth:notice', { detail: `Cloud sync failed: ${detail}` }));
    };
    window.addEventListener('pokesouth:local-change', onChange);
    window.addEventListener('pokesouth:sync-error', onSyncError);
    return () => {
      window.removeEventListener('pokesouth:local-change', onChange);
      window.removeEventListener('pokesouth:sync-error', onSyncError);
    };
  }, [session?.user.id, dataReady]);

  const submitAuth = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    setAuthBusy(true); setAuthError(''); setAuthMessage('');
    try {
      if (authMode === 'signup') {
        const { data, error } = await supabase.auth.signUp({ email: email.trim(), password });
        if (error) throw error;
        if (!data.session) setAuthMessage('Account created. Check your email for a confirmation link, then return here to sign in.');
        else setAuthMessage('Account created successfully.');
      } else {
        const { error } = await supabase.auth.signInWithPassword({ email: email.trim(), password });
        if (error) throw error;
      }
    } catch (error) {
      setAuthError(error instanceof Error ? error.message : 'Sign-in failed. Please try again.');
    } finally { setAuthBusy(false); }
  };

  useEffect(() => {
    const handler = (event: Event) => setAuthMessage((event as CustomEvent<string>).detail);
    window.addEventListener('pokesouth:notice', handler);
    return () => window.removeEventListener('pokesouth:notice', handler);
  }, []);

  if (loading) return <div className="auth-screen"><div className="auth-card"><div className="brand-mark"><Sparkles size={22}/></div><h1>Poké Companion</h1><p>Connecting your trainer workspace…</p></div></div>;
  if (!session?.user) return (
    <div className="auth-screen">
      <div className="auth-card">
        <div className="auth-brand"><div className="brand-mark"><Sparkles size={22}/></div><div><strong>POKÉ COMPANION</strong><small>YOUR GO COMMAND CENTRE</small></div></div>
        <div className="eyebrow">YOUR PERSONAL TRAINER SPACE</div>
        <h1>{authMode === 'signin' ? 'Welcome back.' : 'Create your trainer account.'}</h1>
        <p className="auth-intro">Sign in to keep your collection and goals synced between your PC and Android phone.</p>
        <form className="auth-form" onSubmit={submitAuth}>
          <label htmlFor="trainer-email">Email address</label>
          <input id="trainer-email" type="email" autoComplete="email" required value={email} onChange={e => setEmail(e.target.value)} placeholder="you@example.com"/>
          <label htmlFor="trainer-password">Password</label>
          <input id="trainer-password" type="password" autoComplete={authMode === 'signin' ? 'current-password' : 'new-password'} minLength={6} required value={password} onChange={e => setPassword(e.target.value)} placeholder="At least 6 characters"/>
          {authError && <div className="auth-error" role="alert">{authError}</div>}
          {authMessage && <div className="auth-message" role="status">{authMessage}</div>}
          <button className="primary-button auth-submit" type="submit" disabled={authBusy}>{authBusy ? 'Please wait…' : authMode === 'signin' ? 'Sign in securely' : 'Create account'}</button>
        </form>
        <button className="auth-mode-button" onClick={() => { setAuthMode(authMode === 'signin' ? 'signup' : 'signin'); setAuthError(''); setAuthMessage(''); }}>{authMode === 'signin' ? 'New here? Create an account' : 'Already have an account? Sign in'}</button>
        <p className="auth-footnote"><Shield size={14}/> Your saved records are protected by Supabase Row Level Security.</p>
      </div>
    </div>
  );
  if (!dataReady) return <div className="auth-screen"><div className="auth-card"><div className="brand-mark"><Sparkles size={22}/></div><h1>Loading your collection…</h1><p>Syncing your Pokémon and goals securely.</p>{authError && <div className="auth-error">{authError}</div>}</div></div>;
  return <Dashboard user={session.user} onSignOut={async () => { await supabase.auth.signOut(); }}/>;
}

function Stat({ icon, label, value, note, tone }: { icon: React.ReactNode; label: string; value: string; note: string; tone: string }) {
  return <div className="stat-card"><div className={`stat-icon ${tone}`}>{icon}</div><div className="stat-label">{label}</div><div className="stat-value">{value}</div><div className="stat-note">{note}</div></div>;
}

export default App;