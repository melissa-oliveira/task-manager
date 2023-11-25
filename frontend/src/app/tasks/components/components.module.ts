import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TaskFormComponent } from './task-form/task-form.component';
import { ModalConfirmDeleteComponent } from './modal-confirm-delete/modal-confirm-delete.component';
import { TaskListComponent } from './task-list/task-list.component';


@NgModule({
  declarations: [
    TaskListComponent,
    TaskFormComponent,
    ModalConfirmDeleteComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ComponentsModule { }
