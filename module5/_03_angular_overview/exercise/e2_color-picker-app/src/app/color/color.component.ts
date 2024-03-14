import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
   title = 'Color Picker';
   colorCode = '#387c73';
   fontSize: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  public getColor(red: string, green: string, blue: string) {
    const redNumber: number = Number(red);
    const greenNumber: number = Number(green);
    const blueNumber: number = Number(blue);

    this.colorCode = this.rgbToHex(redNumber,greenNumber,blueNumber);
    console.log(this.colorCode);
  }

  changeFont(value: any) {
    this.fontSize = value;
  }

  rgbToHex = (r : number, g: number, b: number) =>
    "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1);
}
