import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  products: Product[] = [];

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private router: Router) {
    console.log("Inside TestComponent constructor")
  }

  ngOnInit() {
    const param = this.activatedRoute.snapshot.paramMap;
    if (param.has("id")) {
      const id = param.get("id");
      this.productService.delete(Number(id));
      this.router.navigateByUrl("/product/list");
      }

      this.getAll();
    }

    getAll()
    {
      this.products = this.productService.getAll();
    }

  }
