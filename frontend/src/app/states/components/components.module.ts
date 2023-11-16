import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StateFormComponent } from './state-form/state-form.component';
import { StateListComponent } from './state-list/state-list.component';



@NgModule({
  declarations: [
    StateFormComponent,
    StateListComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ComponentsModule { }
