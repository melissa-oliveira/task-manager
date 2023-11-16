import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
import { Task, TaskCategory, TaskState, User } from 'src/app/shared';
import { TaskService } from '../../services/task-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-task',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent implements OnInit {
  // @Input() detalhePedido!: DetalhePedido;
  @ViewChild('taskForm') taskForm!: NgForm;
  task!: Task;

  constructor(
    public activeModal: NgbActiveModal,
    public taskService: TaskService,
    public router: Router,
  ) { }

  states = [
    { id: 1, name: 'Não Iniciada', description: 'Tarefa não iniciada' },
    { id: 2, name: 'Fazendo', description: 'Tarefa em progresso' },
    { id: 3, name: 'Feito', description: 'Tarefa concluída' }
  ];

  categories = [
    { id: 1, name: 'Trabalho', description: 'Atividades relacionadas ao trabalho' },
    { id: 2, name: 'Escola', description: 'Atividades escolares' },
    { id: 3, name: 'Pessoal', description: 'Atividades pessoais' },
    { id: 4, name: 'Lazer', description: 'Atividades de lazer e recreação' }
  ];

  ngOnInit(): void {
    this.task = new Task(0, '', '', new Date(), false, new User(0, "", "", ""), 0, new TaskState(0, "", ""), new TaskCategory(0, "", ""));
  }

  insert(): void {
    if (this.taskForm.form.valid) {
      this.taskService.insert(this.task).subscribe({
        complete: () => {
          this.activeModal.close();
        }
      });
    }
  }
}
