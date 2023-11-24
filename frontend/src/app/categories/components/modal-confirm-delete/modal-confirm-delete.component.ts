import { Component, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { TaskCategory } from 'src/app/shared';
import { CategoryService } from '../../service/category-service.service';

@Component({
  selector: 'app-modal-confirm-delete',
  templateUrl: './modal-confirm-delete.component.html',
  styleUrls: ['./modal-confirm-delete.component.css']
})
export class ModalConfirmDeleteComponent {
  @Input() category!: TaskCategory;

  constructor(
    public activeModal: NgbActiveModal,
    private categoryService: CategoryService,
  ) { }

  deleteCategory() {
    this.categoryService.delete(this.category.id).subscribe({
      complete: () => {
        this.activeModal.close();
      }
    });
  }
}
