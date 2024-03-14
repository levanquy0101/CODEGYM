import {Injectable} from '@angular/core';
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];

  constructor() {
  }

  getAll() {
    return this.products;
  }

  find(id: number): Product {
    let res: Product = {} as Product;

    const product = this.products.find((o) => {
      return o.id === id;
    });

    if (product) {
      res = product;
    }

    return res;
  }

  delete(id:number){
    const index = this.products.findIndex(o => o.id == id);
    this.products.splice(index,1)
  }

  save(product: Product) {
    if (product.id) {
      const index = this.products.findIndex(o => o.id == product.id);
      this.products[index] = product;

      // this.products.forEach((p, i) => {
      //     if(p.id == product.id) {
      //       this.products[i] =
      //         {
      //           name : product.name,
      //           price : product.price,
      //           description : product.description
      //         }
      //     }
      // })
    } else {
      const lastId = this.products[this.products.length - 1].id;
      product.id = lastId;
      this.products.push(product);
    }
  }
}
