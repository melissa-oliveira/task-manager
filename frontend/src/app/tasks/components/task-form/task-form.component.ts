import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
import { Task, TaskCategory, TaskState, User } from 'src/app/shared';
import { TaskService } from '../../services/task-service.service';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/categories/service/category-service.service';
import { StateService } from 'src/app/states/service/state-service.service';
import { AuthService } from 'src/app/auth/services/auth-service.service';

@Component({
  selector: 'app-new-task',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent implements OnInit {
  @Input() task!: Task;
  @ViewChild('taskForm') taskForm!: NgForm;

  states!: TaskState[];
  categories!: TaskCategory[];
  user!: User;
  newTask: boolean = false;

  constructor(
    public activeModal: NgbActiveModal,
    private taskService: TaskService,
    private categoryService: CategoryService,
    private stateService: StateService,
    private authService: AuthService,
  ) { }

  ngOnInit(): void {
    this.user = this.authService.getCurrentlyUser();

    if (this.task == null) {
      this.task = new Task(0, '', '', new Date(), false, this.user, 0, new TaskState(0, "", ""), new TaskCategory(0, "", "", "", this.user));
      this.newTask = true;
    }
    this.findAllCategories();
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

  private findAllCategories(): TaskCategory[] {
    this.categoryService.findByUser(this.authService.getCurrentlyUser()).subscribe({
      next: (data: TaskCategory[]) => {
        if (data == null) {
          this.categories = [];
        } else {
          this.categories = data;
        }
      }
    }); return this.categories;
  }

  private processTask(): void {
    if (this.taskForm.form.valid) {

      this.stateService.findById(this.task.state.id).subscribe(state => {
        this.task.state = state;

        this.categoryService.findById(this.task.category.id).subscribe(category => {
          this.task.category = category;

          const operation = this.newTask ? this.taskService.insert(this.task) : this.taskService.update(this.task);

          operation.subscribe({
            complete: () => {
              this.activeModal.close();
            }
          });
        });
      });
    }
  }

  submit(): void {
    this.processTask();
  }

}
