import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../service/category.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {

  categoryForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
  });

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit() {
  }

  submit() {
    const category = this.categoryForm.value;
    this.categoryService.saveCategory(category).subscribe({
      next: () => {
        this.categoryForm.reset();
        alert('Tạo thành công');
      },
      error: e => {
        console.log(e)
      }
    });
  }
}
