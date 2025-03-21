// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  compatibilityDate: '2024-11-01',
  devtools: { enabled: true },
  modules: [
    // ...
    '@pinia/nuxt',
    'pinia-plugin-persistedstate/nuxt', // Plugin de persistencia
  ],
  css: [
    'assets/index.scss'
  ],
  app: {
    head: {
      link: [
        { rel: 'icon', type: 'image/x-icon', href: '/logo-FileXpress.svg' } // Aquí se enlaza el favicon
      ]
    },
    pageTransition: { name: 'page', mode: 'out-in' }
  },
  experimental: {
    viewTransition: true
  }
})
