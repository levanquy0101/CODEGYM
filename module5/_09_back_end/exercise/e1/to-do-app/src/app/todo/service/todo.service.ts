import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Todo} from "../../todo";
import {environment} from "../../../environments/environment";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class TodoService {
  constructor(private http: HttpClient) { }

  getAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(API_URL + '/todo');
  }

  save(todo: Todo): Observable<Todo> {
    if(todo.id > 0){
      return this.http.put<Todo>(`${API_URL}/todo/${todo.id}`, todo);
    }
    else {
      const lastId =  Math.floor(Math.random() * 1000);
      todo.id = lastId;
      return this.http.post<Todo>(API_URL + '/todo', todo);
    }
  }

  delete(id: number): Observable<Todo> {
    return this.http.delete<Todo>(`${API_URL}/todo/${id}`);
  }
}
