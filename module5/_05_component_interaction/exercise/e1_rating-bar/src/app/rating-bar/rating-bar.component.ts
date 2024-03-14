import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from '@angular/core';
import {RatingUnit} from "../rating-unit";

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  @Input()
  max: any = 10;
  @Input()
  ratingValue: any = 5;
  @Input()
  showRatingValue : any = true;

  @Output()
  rateChange = new EventEmitter<number>();

  ratingUnits: Array<RatingUnit> = [];

  constructor() { }

  ngOnChanges(changes: SimpleChanges) {
    if ('max' in changes) {
      let max = changes['max'].currentValue;
      max = typeof max === 'undefined' ? 5 : max;
      this.max = max;
      this.calculate(max, this.ratingValue);
    }
  }

  calculate(max: any, ratingValue: any) {
    this.ratingUnits = Array.from({length: max},
      (_, index) => ({
        value: index + 1,
        active: index < ratingValue
      }));
  }

  ngOnInit() {
    this.calculate(this.max, this.ratingValue);
  }

  select(index : any) {
    this.ratingValue = index + 1;
    this.ratingUnits.forEach((item, idx) => {
      item.active = idx < this.ratingValue
    });

    this.rateChange.emit(this.ratingValue);
  }
  enter(index : any) {
    this.ratingUnits.forEach((item, idx) => item.active = idx <= index);
  }
  reset() {
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
  }
}
