import { createClient } from '@supabase/supabase-js';

// These are public client settings. Never replace the publishable key with a service_role/secret key.
const projectUrl = import.meta.env.VITE_SUPABASE_URL || 'https://gczgersvlsvlqrdwjwjz.supabase.co';
const publishableKey = import.meta.env.VITE_SUPABASE_PUBLISHABLE_KEY || 'sb_publishable_3MabGg0OrfKrpXYtOvc3Zg_06TpL4ud';

export const supabase = createClient(projectUrl, publishableKey, {
  auth: {
    persistSession: true,
    autoRefreshToken: true,
    detectSessionInUrl: true,
  },
});
