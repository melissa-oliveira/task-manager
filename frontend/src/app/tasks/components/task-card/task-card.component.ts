import { Component, Input } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Task } from 'src/app/shared';
import { TaskFormComponent } from '../task-form/task-form.component';

@Component({
  selector: 'app-task-card',
  templateUrl: './task-card.component.html',
  styleUrls: ['./task-card.component.css']
})
export class TaskCardComponent {
  @Input() task!: Task;

  constructor(
    private modalService: NgbModal
  ) { }

  openFormTask() {
    const modalRef = this.modalService.open(TaskFormComponent);
    modalRef.componentInstance.task = this.task;
  }
}
