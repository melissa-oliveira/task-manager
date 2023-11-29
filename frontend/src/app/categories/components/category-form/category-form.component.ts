import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
import { TaskCategory, User } from 'src/app/shared';
import { CategoryService } from 'src/app/categories/service/category-service.service';
import { AuthService } from 'src/app/auth/services/auth-service.service';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {
  @Input() category!: TaskCategory;
  @ViewChild('categoryForm') categoryForm!: NgForm;

  categories!: TaskCategory[];
  newCategory: boolean = false;
  user!: User;

  constructor(
    public activeModal: NgbActiveModal,
    private categoryService: CategoryService,
    private authService: AuthService,
  ) { }

  ngOnInit(): void {
    this.user = this.authService.getCurrentlyUser();
    if (this.category == null) {
      this.category = new TaskCategory(0, '', '', '', this.user);
      this.newCategory = true;
    }
    this.findAllCategories();
  }

  private findAllCategories(): void {
    this.categoryService.findByUser(this.authService.getCurrentlyUser()).subscribe({
      next: (data: TaskCategory[]) => {
        if (data == null) {
          this.categories = [];
        } else {
          this.categories = data;
        }
      }
    });
  }

  private processCategory(): void {
    if (this.categoryForm.form.valid) {
      const operation = this.newCategory ? this.categoryService.insert(this.category) : this.categoryService.update(this.category);

      operation.subscribe({
        complete: () => {
          this.activeModal.close();
        }
      });
    }
  }

  submit(): void {
    this.processCategory();
  }
}
