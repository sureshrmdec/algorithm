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

        