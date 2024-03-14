import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  product : Product = {} as Product;
  disableMessage = true;
  productForm: FormGroup = new FormGroup({});

  constructor(private productService: ProductService, private  activatedRoute : ActivatedRoute, private fb : FormBuilder
  ,private router : Router) {
    this.productForm = fb.group({
      id : '',
      name: '',
      price: '',
      description: ''
    });
  }

  ngOnInit(): void {
    const paramMap = this.activatedRoute.snapshot.paramMap;

    if (paramMap.has("id")) {
      const id = paramMap.get('id');
      this.product = this.productService.find(Number(id));

      this.productForm = this.fb.group({
        id : this.product.id,
        name: this.product.name,
        price: this.product.price,
        description: this.product.description
      });
    }
  }

  submit() {
    this.productService.save(this.productForm.value);
    this.productForm.reset();
    this.router.navigateByUrl("/product/list");
  }
}
