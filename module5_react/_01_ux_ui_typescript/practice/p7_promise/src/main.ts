let money: number;

const buyACar = (car: any) => {
    return new Promise(((resolve, reject) => {
        setTimeout(() => {
            if (money >= 10000) {
                resolve("can buy " + car);
            } else {
                reject("Do not enough money");
            }
        }, 3000);
    }))
}

// money = 1000001;
money = 100;
const promise = buyACar("Vinfast").then(value => {
    console.log(value);
}, error => {
    console.log(error);
})

console.log("test message")
