import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './auth/components/login/login.component';
import { RegistrationComponent } from './auth/components/registration/registration.component';
import { TaskListComponent } from './tasks/components/task-list/task-list.component';
import { StateListComponent } from './states/components/state-list/state-list.component';
import { CategoryListComponent } from './categories/components/category-list/category-list.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'registration',
    component: RegistrationComponent
  },
  {
    path: 'task-list',
    component: TaskListComponent
  },
  {
    path: 'state-list',
    component: StateListComponent
  },
  {
    path: 'category-list',
    component: CategoryListComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
