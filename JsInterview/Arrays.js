/***********************************************************
Remove duplicate
Goal: remove duplicate members from an array
How:  will start a while looping and keep an 
object/ associated array. If i find an element 
for the first time i will set its value as true 
(that will tell me element added once.). if i 
find a element in the exists object, i will not 
insert it into the return array.
************************************************************/
function removeDuplicate(arr) {
  let exists = {},   //using obj's key value pair as hashtable to store temporay value
    outArr = [],
    elm;

  for (let i = 0; i < arr.length; i++) {
    elm = arr[i];
    if (!exists[elm]) {
      exists[elm] = true;
      outArr.push(elm);
    }
  }
  return outArr;
}

console.log(removeDuplicate([1, 3, 3, 3, 1, 5, 6, 7, 8, 1])); //[1, 3, 5, 6, 7, 8]

/***********************************************************
missing number
Goal: find a missing number from a unsorted array of numbers for example from 1 to 100.
************************************************************/
function missingNumber(arr){
  let n = arr.length+1, 
  sum = 0,
  expectedSum = n * (n+1) / 2;

  for (let i = 0; i < arr.length; i++) {
    sum += arr[i];
  }

  return expectedSum - sum;

  
}

console.log(missingNumber([5, 2, 6, 1, 3])); //4

/***********************************************************
Sum of two
Goal: From a unsorted array, check whether there are any two numbers that will sum up to a given number.
How:  Simplest thing in the world. double loop
************************************************************/
function sumFinder(arr, sum){
  var len = arr.length;

  for (let i =0; i < len-1; i++) {

    for (let j = i+1; j < len; j++) {
      if(arr[i] + arr[j] == sum) {
        return true;
      }
    }
  }
  return false;
}

console.log(sumFinder([6,4,3,2,1,7], 9)); //true
console.log(sumFinder([6,4,3,2,1,7], 2)); //false
/*************************Improvement***********************************/

//How: have an object where i will store the difference of sum and element. 
//And then when i get to a new element and if i find the difference is the 
//object, then i have a pair that sums up to the desired sum.
function sumFinder(arr, sum){
  let differ = {}, 
      len = arr.length,
      substract;

  for (let i =0; i < len; i++) {
    substract = sum - arr[i];
    
    if(differ[substract])
       return true;       
     else if (!differ[arr[i]])
       differ[arr[i]] = true;
  }

  return false;
}

console.log(sumFinder([6,4,3,2,1,7], 9)); //true
console.log(sumFinder([6,4,3,2,1,7], 2)); //falses









        
        