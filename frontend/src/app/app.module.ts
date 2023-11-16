import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AuthModule } from './auth/auth.module';
import { LayoutModule } from './layout/layout.module';
import { SharedModule } from './shared/shared.module';
import { TasksModule } from './tasks/tasks.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './layout/components/navbar/navbar.component';
import { StateColumnComponent } from './tasks/components/state-column/state-column.component';
import { TaskCardComponent } from './tasks/components/task-card/task-card.component';
import { TaskListComponent } from './tasks/components/task-list/task-list.component';
import { TaskFormComponent } from './tasks/components/task-form/task-form.component';
import { CategoryFormComponent } from './categories/components/category-form/category-form.component';
import { CategoryListComponent } from './categories/components/category-list/category-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TaskCardComponent,
    StateColumnComponent,
    TaskFormComponent,
    TaskListComponent,
    CategoryFormComponent,
    CategoryListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthModule,
    LayoutModule,
    SharedModule,
    TasksModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
