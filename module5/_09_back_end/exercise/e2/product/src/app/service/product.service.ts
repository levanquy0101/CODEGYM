import {Injectable} from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products : Product[] = [];

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(API_URL + '/products?_expand=category');
  }

  find(id: number): Observable<Product> {
    return this.http.get<Product>(`${API_URL}/products/${id}`);
  }

  delete(id: number): Observable<Product> {
    return this.http.delete<Product>(`${API_URL}/products/${id}`);
  }



  save(product: Product) : Observable<Product>{
    if(product.id){
      return  this.http.put<Product>(`${API_URL}/products/${product.id}`, product);
    }
    else {
      product.id =  Math.floor(Math.random() * 1000);;
      return this.http.post<Product>(API_URL + '/products', product);
    }
  }
}
