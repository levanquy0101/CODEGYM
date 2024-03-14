import {Rectangle} from "./rectangle";

const rectangle = new Rectangle(5, 5, 10, 20);
console.log(rectangle.toString());
console.log(`width: ${rectangle.width}`);
console.log(rectangle.area());
