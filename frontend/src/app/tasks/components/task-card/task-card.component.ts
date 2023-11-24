import { Component, Input } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Task } from 'src/app/shared';
import { TaskFormComponent } from '../task-form/task-form.component';
import { TaskService } from '../../services/task-service.service';
import { ModalConfirmDeleteComponent } from '../modal-confirm-delete/modal-confirm-delete.component';

@Component({
  selector: 'app-task-card',
  templateUrl: './task-card.component.html',
  styleUrls: ['./task-card.component.css']
})
export class TaskCardComponent {
  @Input() task!: Task;

  constructor(
    private modalService: NgbModal,
    private taskService: TaskService,
  ) { }

  openFormTask() {
    const modalRef = this.modalService.open(TaskFormComponent);
    modalRef.componentInstance.task = this.task;
  }

  openConfirmDeletionTask() {
    const modalRef = this.modalService.open(ModalConfirmDeleteComponent);
    modalRef.componentInstance.task = this.task;
  }
}
