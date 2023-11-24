import { Component } from '@angular/core';
import { TaskCategory } from 'src/app/shared';
import { CategoryService } from '../../service/category-service.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CategoryFormComponent } from '../category-form/category-form.component';
import { ModalConfirmDeleteComponent } from '../modal-confirm-delete/modal-confirm-delete.component';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent {
  categories!: TaskCategory[];

  constructor(
    private modalService: NgbModal,
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {
    this.findAllCategories();
  }

  private findAllCategories(): TaskCategory[] {
    this.categoryService.findAll().subscribe({
      next: (data: TaskCategory[]) => {
        if (data == null) {
          this.categories = [];
        } else {
          this.categories = data;
        }
      }
    }); return this.categories;
  }

  openFormCategory() {
    this.modalService.open(CategoryFormComponent);
  }

  openFormTask(category: TaskCategory) {
    const modalRef = this.modalService.open(CategoryFormComponent);
    modalRef.componentInstance.category = category;
  }

  openConfirmDeletionCategory(category: TaskCategory) {
    const modalRef = this.modalService.open(ModalConfirmDeleteComponent);
    modalRef.componentInstance.category = category;
  }
}
