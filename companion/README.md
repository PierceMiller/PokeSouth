# Poké Companion

A personal, mobile-first Pokémon GO companion built with React, TypeScript and Vite. This app is separate from the legacy Android project in the repository and lives in `companion/`.

## Local development

Requires Node.js 22 or newer.

```bash
cd companion
npm install
npm run dev
```

Build for production:

```bash
npm run build
npm run preview
```

## Deployment

The GitHub Actions workflow at `.github/workflows/pokesouth-companion-pages.yml` builds `companion/` and deploys the static output to GitHub Pages. The Vite base path is configured for the repository project page: `/PokeSouth/`.

If Pages has not been enabled for this repository, open **Settings → Pages** and choose **GitHub Actions** as the build and deployment source.

## Current first-build features

- Responsive dark dashboard and mobile navigation
- Searchable starter species catalogue
- Local collection tracking and personal goals (browser local storage)
- Installable PWA manifest and basic app-shell caching
- GitHub Pages deployment workflow

## Roadmap

1. Add a verified Pokémon GO game-data ingestion source and freshness indicators.
2. Add Supabase Auth, personal collection sync, RLS-protected tables and backups.
3. Add raid/PvP calculators, event tracking and goal recommendations.
4. Add scheduled refresh jobs and opt-in Discord webhook alerts.

## Important data note

The initial catalogue is sample UI data. CP values are illustrative, and this version does not connect to live Pokémon GO accounts, scan game servers, or automate in-game actions. The artwork currently uses Pokémon artwork assets from the PokeAPI sprites repository.