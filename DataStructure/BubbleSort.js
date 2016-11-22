/**************************************************
Name: Quick Sort base case
Cost: expected O(N2)
Note: 	outer loop: doing nothing, just start inner round without the largest number
		inner loop: push largest number to the right end


**************************************************/
let test_array = [13, 4, 1,7,12, 2, 11, 9, 3,6,5,14,8,10,0,15];


function BuddleSort (array, start, end) {
  for (let i = end; i > start; i--) {
      for (let j = start; j < i; j++) {
          if (array[j] > array[j + 1]) {
            let temp = array[j+1]
            array[j+1] = array[j]
            array[j] = temp
          }
      }
  }
}

BuddleSort(test_array, 0, test_array.length - 1) 
console.log(test_array)