import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-new-task',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent {
  // @Input() detalhePedido!: DetalhePedido;

  constructor(
    public activeModal: NgbActiveModal
  ) { }
}
