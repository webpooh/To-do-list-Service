
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import TaskManager from "./components/listers/TaskCards"
import TaskDetail from "./components/listers/TaskDetail"

import AuthenticationManager from "./components/listers/AuthenticationCards"
import AuthenticationDetail from "./components/listers/AuthenticationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/tasks',
                name: 'TaskManager',
                component: TaskManager
            },
            {
                path: '/tasks/:id',
                name: 'TaskDetail',
                component: TaskDetail
            },

            {
                path: '/authentications',
                name: 'AuthenticationManager',
                component: AuthenticationManager
            },
            {
                path: '/authentications/:id',
                name: 'AuthenticationDetail',
                component: AuthenticationDetail
            },



    ]
})
