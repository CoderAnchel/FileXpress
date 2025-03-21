export default defineNuxtRouteMiddleware((to, from) => {
  if (process.client) {
    const logged = localStorage.getItem('logged');
    if (!logged || logged == "false" && to.path !== '/welcome') {
      const router = useRouter();
      router.push({ path: '/welcome', replace: true });
    }
  }
});
