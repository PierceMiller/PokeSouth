-- PokéSouth Companion: private imported Pokémon inventory.
-- Applied to Supabase project gczgersvlsvlqrdwjwjz on 2026-11-01.
-- Every row is owned by the authenticated user; no Pokémon GO credentials are stored.

create table if not exists public.pokemon_inventory (
  id uuid primary key default gen_random_uuid(),
  user_id uuid not null references auth.users(id) on delete cascade,
  source text not null default 'poke genie',
  source_key text not null,
  pokemon_id integer,
  species_name text not null,
  form text,
  nickname text,
  cp integer,
  hp integer,
  iv_attack smallint,
  iv_defense smallint,
  iv_stamina smallint,
  iv_percent numeric(5,2),
  level numeric(5,2),
  fast_move text,
  charged_move text,
  is_shiny boolean not null default false,
  is_lucky boolean not null default false,
  is_shadow boolean not null default false,
  is_purified boolean not null default false,
  caught_at date,
  raw_data jsonb not null default '{}'::jsonb,
  imported_at timestamptz not null default now(),
  created_at timestamptz not null default now(),
  updated_at timestamptz not null default now(),
  constraint pokemon_inventory_user_source_key unique (user_id, source, source_key),
  constraint pokemon_inventory_cp_check check (cp is null or cp >= 0),
  constraint pokemon_inventory_iv_attack_check check (iv_attack is null or iv_attack between 0 and 15),
  constraint pokemon_inventory_iv_defense_check check (iv_defense is null or iv_defense between 0 and 15),
  constraint pokemon_inventory_iv_stamina_check check (iv_stamina is null or iv_stamina between 0 and 15)
);

create index if not exists pokemon_inventory_user_species_idx on public.pokemon_inventory(user_id, species_name);
create index if not exists pokemon_inventory_user_cp_idx on public.pokemon_inventory(user_id, cp desc);
alter table public.pokemon_inventory enable row level security;
grant select, insert, update, delete on public.pokemon_inventory to authenticated;

drop policy if exists "Users can view their own imported Pokemon" on public.pokemon_inventory;
create policy "Users can view their own imported Pokemon" on public.pokemon_inventory for select to authenticated using ((select auth.uid()) = user_id);
drop policy if exists "Users can add their own imported Pokemon" on public.pokemon_inventory;
create policy "Users can add their own imported Pokemon" on public.pokemon_inventory for insert to authenticated with check ((select auth.uid()) = user_id);
drop policy if exists "Users can update their own imported Pokemon" on public.pokemon_inventory;
create policy "Users can update their own imported Pokemon" on public.pokemon_inventory for update to authenticated using ((select auth.uid()) = user_id) with check ((select auth.uid()) = user_id);
drop policy if exists "Users can delete their own imported Pokemon" on public.pokemon_inventory;
create policy "Users can delete their own imported Pokemon" on public.pokemon_inventory for delete to authenticated using ((select auth.uid()) = user_id);
