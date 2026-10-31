const CACHE_NAME = 'poke-companion-shell-v1';
const APP_SHELL = ['/PokeSouth/', '/PokeSouth/manifest.webmanifest'];
self.addEventListener('install', event => {
  event.waitUntil(caches.open(CACHE_NAME).then(cache => cache.addAll(APP_SHELL)).then(() => self.skipWaiting()));
});
self.addEventListener('activate', event => {
  event.waitUntil(caches.keys().then(keys => Promise.all(keys.filter(key => key !== CACHE_NAME).map(key => caches.delete(key)))).then(() => self.clients.claim()));
});
self.addEventListener('fetch', event => {
  const request = event.request;
  if (request.method !== 'GET' || new URL(request.url).origin !== self.location.origin) return;
  event.respondWith(fetch(request).then(response => {
    if (response.ok && request.mode === 'navigate') {
      const copy = response.clone();
      caches.open(CACHE_NAME).then(cache => cache.put('/PokeSouth/', copy));
    }
    return response;
  }).catch(() => caches.match(request).then(cached => cached || caches.match('/PokeSouth/'))));
});