import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryFormComponent } from './components/category-form/category-form.component';
import { CategoryListComponent } from './components/category-list/category-list.component';



@NgModule({
  declarations: [
    CategoryFormComponent,
    CategoryListComponent
  ],
  imports: [
    CommonModule
  ]
})
export class CategoriesModule { }
