import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TaskFormComponent } from '../task-form/task-form.component';
import { Task, TaskState } from 'src/app/shared';
import { StateService } from 'src/app/states/service/state-service.service';
import { TaskService } from '../../services/task-service.service';
import { ModalConfirmDeleteComponent } from '../modal-confirm-delete/modal-confirm-delete.component';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  states!: TaskState[];
  tasks!: Task[];

  stateAndTasks: {
    state: string,
    tasks: Task[]
  }[] = [];

  constructor(
    private modalService: NgbModal,
    private stateService: StateService,
    private taskService: TaskService
  ) { }

  ngOnInit(): void {
    this.findAllStates();
  }

  private findAllStates(): TaskState[] {
    this.stateService.findAll().subscribe({
      next: (data: TaskState[]) => {
        if (data == null) {
          this.states = [];
        } else {
          this.states = data;
          this.findAllTasks();
        }
      }
    });
    return this.states;
  }

  private findAllTasks(): Task[] {
    this.taskService.findAll().subscribe({
      next: (data: Task[]) => {
        if (data == null) {
          this.tasks = [];
        } else {
          this.tasks = data;
        }
      }
    }); return this.tasks;
  }

  openFormNewTask() {
    const modalRef = this.modalService.open(TaskFormComponent);

    modalRef.result.then(() => {
      this.findAllStates();
    }).catch(() => {
      this.findAllStates();
    });
  }

  openFormTask(task: Task) {
    const modalRef = this.modalService.open(TaskFormComponent);
    modalRef.componentInstance.task = task;

    modalRef.result.then(() => {
      this.findAllStates();
    }).catch(() => {
      this.findAllStates();
    });
  }

  openConfirmDeletionTask(task: Task) {
    const modalRef = this.modalService.open(ModalConfirmDeleteComponent);
    modalRef.componentInstance.task = task;

    modalRef.result.then(() => {
      this.findAllStates();
    }).catch(() => {
      this.findAllStates();
    });
  }
}
