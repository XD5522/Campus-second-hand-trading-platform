import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'


createApp(App).use(store).use(router).mount('#app')

app.use(ElementPlus, { size: 'small', zIndex: 3000 })