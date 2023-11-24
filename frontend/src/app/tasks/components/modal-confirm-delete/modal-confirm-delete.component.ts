import { Component, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { TaskService } from '../../services/task-service.service';
import { Task } from 'src/app/shared';

@Component({
  selector: 'app-modal-confirm-delete',
  templateUrl: './modal-confirm-delete.component.html',
  styleUrls: ['./modal-confirm-delete.component.css']
})
export class ModalConfirmDeleteComponent {
  @Input() task!: Task;

  constructor(
    public activeModal: NgbActiveModal,
    private taskService: TaskService,
  ) { }

  deleteTask() {
    this.taskService.delete(this.task.id).subscribe({
      complete: () => {
        this.activeModal.close();
      }
    });
  }
}
