import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Category} from "../../model/category";

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  category : Category = {} as Category;

  categoryForm: FormGroup = new FormGroup({});

  constructor(private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.category.id = Number(paramMap.get('id'));
      this.getCategory(this.category.id);
    });
  }

  ngOnInit() {
  }

  getCategory(id: number) {
    return this.categoryService.findById(id).subscribe(category => {
      this.categoryForm = new FormGroup({
        name: new FormControl(category.name),
        id: new FormControl(category.id)
      });
    });
  }

  updateCategory(id: number) {
    const category = this.categoryForm.value;
    this.categoryService.updateCategory(Number(id), category).subscribe({
      complete: () => {
        console.log("Completed")
      },
      error: e => {
        console.log(e) },
      next: () => {
        alert('Cập nhật thành công');
      }
    });
  }
}
