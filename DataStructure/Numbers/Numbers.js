/*****************************
Check Prime
a prime number is only divisible by itself and 1

******************************/

function isPrime(n){
  let divider = 2;
  let result = 0;
  while (divider < n) {
  	if (n % divider == 0) {
    	console.log(divider);
    	return false;
    }
  		
  	divider++;

  }
  return true;
}

console.log(isPrime(137));
console.log(isPrime(237));

/************** Improvement ***************/
function isPrime(number) {
  if (n == 2 || n == 3)
     return true;
  if (n % 2 == 0)
     return false;
  for (var i = 3; i*i <= number; i += 2) {
  	//dont need to check even numbers anymore, minimal limit is sqr(num)
    if (number % i === 0) {
      return false;
    }
  }
  return true;

}

console.log(isPrime(3));
console.log(isPrime(15485863));

/*****************************
Prime Factors
Goal: find all prime factors of a number
How: Run a while loop. start dividing by two and if not divisible increase divider until u r done.
******************************/
function primeFactors(n){
  let factors = [], 
    divisor = 2;

  while(n>2){
    if(n % divisor == 0){	 // if a number coulb be divided by a certain divisor, then divided by it until
    											 // could not be divided by it anymore, then evaluate the next value.
      if (divisor !== factors[factors.length -1])
       		factors.push(divisor); 
      n= n/ divisor;
      //console.log("n is :" + n);
      //console.log("divisor :" + divisor);
    }
    else{
      divisor++;
    }     
  }
  return factors;
}

primeFactors(69); // [3, 23]
/*****************************
Fibonacci
Goal: get nth Fibonacci number
How:  I create an array and start from iterate through.
Fibonacci series is one of the most popular interview question for beginners. so, you have to learn this one.
Complexity:  O(2^n)
******************************/
function fibonacci(n) {
  if (n == 0)
    return 0
  else if (n == 1)
    return 1
  return fibonacci(n - 1) + fibonacci(n - 2);
}

console.log(fibonacci(12)); //144
/*****************************
Greatest Common Divisor
Goal: find the greatest common divisor of two numbers
******************************/
function greatestCommonDivisor(a, b){
  let divisor = 2, 
    greatestDivisor = 1;
  if (a < 2 || b < 2)
  	return 1;

  while(divisor <= a && divisor <= b) {
  	if (a % divisor == 0 && b % divisor == 0)
  		greatestDivisor = divisor;
  	divisor++;
  }
  return greatestDivisor;
}

console.log(greatestCommonDivisor(14, 21)); //7
console.log(greatestCommonDivisor(69, 169)); //1
console.log(greatestCommonDivisor(3, 9)); //1



