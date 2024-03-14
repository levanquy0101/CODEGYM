import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'rating-bar';
  item: any;

  change($event: number) {
    console.log("get value from child: " + $event)
    this.item = $event;
  }
}
