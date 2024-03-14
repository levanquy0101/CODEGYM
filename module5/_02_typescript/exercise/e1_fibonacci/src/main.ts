import * as readline from 'readline';

let numUserInput = "";
let rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
rl.question("Input quantity fibonacci you want to sum: ", function (answer) {
    numUserInput = answer;
    let result: number = 0;
    for (let i = 0; i <= Number(numUserInput); i++) {
        const tmp = fibonacci(i);
        if (tmp > 0) {
            console.log(tmp);
            result += tmp;
        }
    }

    console.log("Sum total: " + result);
    rl.close();
});


function fibonacci(n: number): number {
    if (n == 0 || n == 1) {
        return n;
    }

    return fibonacci(n - 2) + fibonacci(n - 1);
}

