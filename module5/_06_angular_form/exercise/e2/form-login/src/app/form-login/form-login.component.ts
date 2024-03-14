import {Component, OnInit} from '@angular/core';
import {User} from "../user";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css']
})
export class FormLoginComponent implements OnInit {
  user: User = {} as User;
  formLogin: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder) {
    this.formLogin = fb.group({
        username: ['', Validators.required],
        password: ['', [Validators.required , Validators.minLength(6)]]
      }
    )
  }

  ngOnInit(): void {
  }

  get f(){
    return this.formLogin.controls;
  }

  login() {
    console.log(this.formLogin.value);
  }
}
