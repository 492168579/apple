import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'tabHome',
        children: [
          {
            path: '',
            loadChildren: '../home/home.module#HomePageModule'
          }
        ]
      },
      {
        path: 'tabRecommend',
        children: [
          {
            path: '',
            loadChildren: '../recommend/recommend.module#RecommendPageModule'
          }
        ]
      },
      {
        path: 'tabChat',
        children: [
          {
            path: '',
            loadChildren: '../chat/chat.module#ChatPageModule'
          }
        ]
      },
      {
        path: 'tabContacts',
        children: [
          {
            path: '',
            loadChildren: '../contacts/contacts.module#ContactsPageModule'
          }
        ]
      },
      {
        path: 'tabMine',
        children: [
          {
            path: '',
            loadChildren: '../mine/mine.module#MinePageModule'
          }
        ]
      },
      {
        path: '',
        redirectTo: '/tabs/tabHome',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/tabHome',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class TabsPageRoutingModule {}
