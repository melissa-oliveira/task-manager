import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryFormComponent } from './components/category-form/category-form.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { ModalConfirmDeleteComponent } from './components/modal-confirm-delete/modal-confirm-delete.component';



@NgModule({
  declarations: [
    CategoryFormComponent,
    CategoryListComponent,
    ModalConfirmDeleteComponent
  ],
  imports: [
    CommonModule
  ]
})
export class CategoriesModule { }
