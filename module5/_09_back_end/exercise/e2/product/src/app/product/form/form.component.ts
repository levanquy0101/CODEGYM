import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  product : Product = {} as Product;
  categories : Category[] = [];
  disableMessage = true;
  productForm: FormGroup  =this.fb.group({
    id : '',
    name: '',
    price: '',
    description: '',
    categoryId: ''
  });

  constructor(private productService: ProductService, private  activatedRoute : ActivatedRoute, private fb : FormBuilder
  ,private router : Router, private categoryService: CategoryService) {
    categoryService.getAll().subscribe(e => {
      this.categories = e;
    });
  }

  ngOnInit(): void {
    const paramMap = this.activatedRoute.snapshot.paramMap;

    if (paramMap.has("id")) {
      const id = paramMap.get('id');
      this.productService.find(Number(id)).subscribe(e => {
        this.product = e;
        console.log(this.product)
        this.productForm = this.fb.group({
          id : e.id,
          name: e.name,
          price: e.price,
          description: e.description,
          categoryId: e.categoryId
        });
      })
    }
  }

  submit() {
    console.log(this.productForm.value);
    this.productService.save(this.productForm.value).subscribe(e=> {
      console.log("saved")
    });
    this.productForm.reset();
    this.router.navigateByUrl("/product/list");
  }
}
