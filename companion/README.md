# Poké Companion

A personal, mobile-first Pokémon GO companion built with React, TypeScript and Vite. This app is separate from the legacy Android project in the repository and lives in `companion/`.

## Local development

Requires Node.js 22 or newer.

```bash
cd companion
npm install
npm run dev
```

The app is configured for the dedicated Supabase project. The URL and **publishable** key are public client configuration (not secrets); they are also available as Vite variables if you want to override them locally:

- `VITE_SUPABASE_URL`
- `VITE_SUPABASE_PUBLISHABLE_KEY`

Copy `.env.example` to `.env.local` only if you want to configure those values locally. Never put a Supabase `service_role` or secret key in this frontend.

## Supabase setup

Project: [PokeSouth Companion](https://supabase.com/dashboard/project/gczgersvlsvlqrdwjwjz)

The client uses Supabase email/password authentication and the existing `public.pokemon_collection` and `public.user_goals` tables. Both tables have Row Level Security enabled, with select/insert/update/delete ownership policies tied to `auth.uid()`. The project URL and publishable key have been retrieved from the connected Supabase project and configured in `src/lib/supabase.ts` and `.env.example`. A publishable key is designed to be visible in browser code; never put a `service_role` or secret key in this app.

**Authentication dashboard settings still need a manual check.** The connected tools can verify database policies and retrieve the public client key, but they cannot read or change the project's Auth provider/URL settings. Open the [Supabase project](https://supabase.com/dashboard/project/gczgersvlsvlqrdwjwjz) and verify:
1. **Authentication → Sign In / Providers → Email**: enable Email/password sign-in.
2. **Authentication → URL Configuration → Site URL**: set `https://piercemiller.github.io/PokeSouth/`.
3. Under **Redirect URLs**, allow `https://piercemiller.github.io/PokeSouth/`. For local development, also allow `http://localhost:5173/PokeSouth/`.
4. If email confirmation is enabled, sign-up users must click the confirmation link before signing in. The app explicitly redirects confirmation links to the repository's base URL.
5. **Authentication → Password Security**: enable leaked-password protection. The Supabase security advisor currently reports this protection as disabled; the connected tools cannot change this Auth setting.

For local development, copy `.env.example` to `.env.local` and edit `VITE_SUPABASE_URL` or `VITE_SUPABASE_PUBLISHABLE_KEY` only if you need to override the configured project values. These are public client settings, not secrets. The current GitHub Pages build has safe public fallbacks, so no private GitHub Actions secret is required for the URL/key.

On the first sign-in in a browser, the app merges its existing browser-local collection/goals with the signed-in account's cloud rows, adding missing species IDs and goal titles without deleting existing cloud rows. After the merge succeeds, collection/goal changes sync to that account. Signing out does not delete cloud data.

## Build and deployment

```bash
npm run build
npm run preview
```

The GitHub Actions workflow at `.github/workflows/pokesouth-companion-pages.yml` builds `companion/` and deploys the static output to GitHub Pages. Vite is configured for the repository project page at `/PokeSouth/`. If Pages has not been enabled, open **Settings → Pages** and choose **GitHub Actions** as the build and deployment source.

## Current features

- Responsive dark dashboard and mobile navigation
- Email/password sign-up, sign-in and sign-out
- Account-specific Pokémon collection and goal sync through Supabase
- Private individual-Pokémon inventory import from companion-app CSV exports (PokéGenie-style)
- RLS-protected user data
- Searchable starter species catalogue
- Installable PWA manifest and basic app-shell caching
- GitHub Pages deployment workflow

## Import your actual Pokémon collection

1. On Android, open the companion tool you use (for example PokéGenie) and open **My Pokémon**.
2. Use its **Export as CSV** option and save/share the CSV to your phone or computer. Menu labels may differ by app/version.
3. Open PokéSouth Companion, sign in, select **Collection**, choose **CSV export**, review the preview, then select **Import**.
4. The CSV is parsed locally in your browser before upload. Only the selected inventory records are sent to the signed-in Supabase account. No Pokémon GO password, session token, or game-server connection is used.
5. Re-import after updating your companion-app export. Re-importing the same file updates matching rows; it is not a live sync.

The importer is designed around common PokéGenie-style CSV headers and accepts several header variants. Different companion apps may export different columns; missing fields remain blank, and a file that does not include recognizable Pokémon names will be rejected. The separate `pokemon_inventory` table uses Row Level Security policies so users can only read or change their own imported records. Its schema is documented in `companion/supabase/pokemon_inventory.sql`.

## Important data note

The initial catalogue is sample UI data. CP values are illustrative, and this version does not connect to live Pokémon GO accounts, scan game servers, or automate in-game actions. The artwork currently uses Pokémon artwork assets from the PokeAPI sprites repository.
