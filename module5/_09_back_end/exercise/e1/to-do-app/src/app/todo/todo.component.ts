import {Component, OnInit} from '@angular/core';
import {Todo} from "../todo";
import {FormControl} from "@angular/forms";
import {TodoService} from "./service/todo.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit  {
  isEdit : boolean = false;
  todo : Todo = {} as Todo;
  todos: Todo[] = [];
  content = new FormControl();

  constructor(private todoService: TodoService, private router: Router) { }

  ngOnInit(): void {
    this.todoService.getAll().subscribe(e => this.todos = e);
  }


  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  delete(id: number) {
    this.todoService.delete(id).subscribe(e => {
      const index: number = this.todos.findIndex(e => e.id == id);
      this.todos.splice(index, 1);
    })
  }

  edit(bt:  HTMLButtonElement, ip: HTMLInputElement, a:  HTMLAnchorElement, todo: Todo) {
    if(!this.isEdit){
      this.isEdit = true;
      bt.textContent ="Save";
      a.hidden = true;
      ip.hidden= false;
      if(todo.content){
        ip.value = todo.content;
      }
    }
    else {
      todo.content = ip.value;
      this.isEdit = false;
      ip.hidden = true;
      a.hidden = false;
      bt.textContent = "Edit";
      this.todoService.save(todo).subscribe(()=> {
        console.log("updated");
      });
    }
  }

  add() {
    const value = this.content.value;
    if (value) {
      this.todo = {
        id: 0,
        content: value,
        complete: false
      };

      this.todoService.save(this.todo).subscribe(() =>  this.todos.push(this.todo));
      this.content.reset();
    }
  }
}
