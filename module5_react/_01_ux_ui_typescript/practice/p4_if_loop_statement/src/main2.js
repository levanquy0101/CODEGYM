"use strict";
let res = 0;
let c = 0;
let t = 1;
do {
    t++;
    if (isPrime(t)) {
        c++;
        res += t;
        console.log(t);
    }
} while (c < 30);
console.log(`result: ${res}`);
function isPrime(val) {
    if (val === 2) {
        return true;
    }
    for (let i = 2; i < val; i++) {
        if (val % i === 0) {
            return false;
        }
    }
    return true;
}
