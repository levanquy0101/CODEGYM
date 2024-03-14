import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.css']
})
export class ProgressBarComponent implements OnInit {
  @Input() backgroundColor = '#D9D9D9';
  @Input() progressColor = '#4CAF50';
  @Input() progress: any;

  constructor() {
  }

  ngOnInit() {
    this.loading();
  }

  loading() {
    let interval = setInterval(() => {
      console.log(this.progress);
      let tmp = Number(this.progress);
      tmp += 5;
      this.progress = tmp;
      if (this.progress == 100) {
        clearInterval(interval);
      }
    }, 2000);
  }
}
