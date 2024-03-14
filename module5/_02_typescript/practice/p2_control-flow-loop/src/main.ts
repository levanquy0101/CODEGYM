// let sum: number = 0;
// let count: number = 0;
// for (let i = 2; count < 30; i++) {
//     let isPrime: boolean = true;
//     if (i == 2) {
//         sum += i;
//         count++;
//         continue;
//     }
//     for (let j = 2; j <= Math.sqrt(i); j++) {
//         if (i % j == 0) {
//             isPrime = false;
//             break;
//         }
//     }
//     if(!isPrime){
//         continue;
//     }
//     sum += i;
//     count++;
// }
// console.log(sum);

let count: number = 0;
let result: number = 0;

for (let i = 2; count < 30 ; i++) {
    if(isPrimeNumber(i)){
        result += i;
        count++;
    }
}

console.log(result);

function isPrimeNumber(val: number) {
    for (let i = 2; i < val; i++) {
        if (val % i == 0) {
            return false;
        }
    }

    return true;
}

