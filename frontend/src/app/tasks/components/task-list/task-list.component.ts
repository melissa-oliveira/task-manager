import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TaskFormComponent } from '../task-form/task-form.component';
import { Task, TaskState } from 'src/app/shared';
import { StateService } from 'src/app/states/service/state-service.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  states!: TaskState[];

  constructor(
    private modalService: NgbModal,
    private stateService: StateService
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
        }
      }
    }); return this.states;
  }


  openFormNewTask() {
    this.modalService.open(TaskFormComponent);
  }
}
