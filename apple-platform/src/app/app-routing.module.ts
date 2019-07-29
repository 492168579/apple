import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
     { path : "user",  
          loadChildren: () => import('./user/user.module').then(mod => mod.UserModule)
     },
     {
      path: 'login',
      loadChildren: () => import('./login/login.module').then(mod => mod.LoginModule)
     },
     {
      path: 'dashboard',
      loadChildren: () => import('./dashboard/dashboard.module').then(mod => mod.DashboardModule)
     },
     {
          path: 'home',
          loadChildren: () => import('./home/home.module').then(mod => mod.HomeModule)
     },
     {
          path: 'chat',
          loadChildren: () => import('./chat/chat.module').then(mod => mod.ChatModule)
     },
     {
          path: '',
          redirectTo: 'home',
          pathMatch: 'full'
     }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
