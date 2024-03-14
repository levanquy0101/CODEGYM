import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ConfirmedValidator} from "./confirmed-validator";

@Component({
  selector: 'app-form-register',
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.css']
})
export class FormRegisterComponent implements OnInit {
  user : User = {} as User;
  registerForm: FormGroup  = new FormGroup({});

  countryList = [
    {id: 1, name: 'Viet Nam'},
    {id: 2, name: 'China'},
    {id: 3, name: 'USA'},
  ];

  constructor(private fb: FormBuilder) {
    this.registerForm = fb.group({
        email: [this.user.email, [Validators.required, Validators.email]],
        password: [this.user.password, [Validators.required, Validators.minLength(6)]],
        confirmPassword: [this.user.password, Validators.required],
        country: [this.user.country, Validators.required],
        age: [this.user.age,[Validators.required, Validators.min(18)]],
        gender: [this.user.gender, Validators.required],
        phone: [this.user.phone,  [Validators.required,Validators.pattern(/^\+84\d{9,10}$/)]]
      }
      ,
      {
        // validators: this.password.bind(this)
        validator: ConfirmedValidator('password', 'confirmPassword')
      }
    );
  }

  ngOnInit(): void {

  }

  get registerFormControl() {
    return this.registerForm.controls;
  }

  submit(){
    console.log(this.registerForm.value);
  }

  // password(formGroup: FormGroup) {
  //   const { value: password } = formGroup.get('password');
  //   const { value: confirmPassword } = formGroup.get('confirmPassword');
  //   return password === confirmPassword ? null : { passwordNotMatch: true };
  // }
}
