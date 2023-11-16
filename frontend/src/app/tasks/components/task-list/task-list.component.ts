import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TaskFormComponent } from '../task-form/task-form.component';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent {

  constructor(
    private modalService: NgbModal,
  ) { }

  openFormNewTask() {
    const modalRef = this.modalService.open(TaskFormComponent);
    //modalRef.componentInstance.detalhePedido = detalhePedido;
  }
}
