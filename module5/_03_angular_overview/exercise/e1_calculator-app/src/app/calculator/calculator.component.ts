import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result: any;

  constructor() {
  }

  ngOnInit(): void {
  }

  calculate = (ope: string, value1: string, value2: string) => {
    switch (ope) {
      case "+":
        this.result = Number(value1) + Number(value2);
        break;
      case "-":
        this.result = Number(value1) - Number(value2);
        break;
      case "*":
        this.result = Number(value1) * Number(value2);
        break;
      case "/":
        const val2 = Number(value2);
        if (val2 != 0) {
          this.result = Number(value1) / val2;
        } else {
          this.result = "value2 not is 0"
        }
        break;
    }
  };
}
