import { Component, Input, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/categories/service/category-service.service';
import { Task, TaskState } from 'src/app/shared';
import { StateService } from 'src/app/states/service/state-service.service';
import { TaskService } from '../../services/task-service.service';

@Component({
  selector: 'app-state-column',
  templateUrl: './state-column.component.html',
  styleUrls: ['./state-column.component.css']
})
export class StateColumnComponent implements OnInit {
  @Input() state!: TaskState;
  tasks!: Task[];

  constructor(
    private taskService: TaskService,
  ) { }

  ngOnInit(): void {
    this.findAllTasks();
  }

  private findAllTasks(): Task[] {
    this.taskService.findAll().subscribe({
      next: (data: Task[]) => {
        if (data == null) {
          this.tasks = [];
        } else {
          this.tasks = data.filter(task => task.state.id === this.state.id);
        }
      }
    }); return this.tasks;
  }
}
