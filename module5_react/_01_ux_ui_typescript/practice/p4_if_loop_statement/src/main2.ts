let res:number = 0;
let c: number = 0;
let t: number = 1;

do{
    t++;
    if(isPrime(t)){
        c++;
        res += t;
        console.log(t);
    }
}while (c<30)

console.log(`result: ${res}`);

function isPrime(val:number): boolean{
    if(val === 2){
        return true;
    }

    for (let i = 2; i < val; i++) {
        if(val % i === 0){
            return false;
        }
    }

    return true;
}
