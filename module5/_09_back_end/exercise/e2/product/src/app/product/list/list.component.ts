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
  }

  ngOnInit() {
    const param = this.activatedRoute.snapshot.paramMap;
    if (param.has("id")) {
      const id = param.get("id");
      this.productService.delete(Number(id)).subscribe(e => {
        console.log("deleted")});
      this.router.navigateByUrl("/product/list");
    }
    else {
      this.productService.getAll().subscribe(e=> this.products =e);
    }
  }

}
