/**************************************************
Name: Insertion Sort base case
Cost: Time Complexity is O(N^2)
Note: inner pointer compared the number picked with the number already sorted from right to left, 
	  swithcing with the number in his left while he is moving right.




**************************************************/


let test_array = [9, 2, 4, 4, 6, 8, 7, 11, 3, 1, 10];


function InsertionSort(array) {
	let min, min_index;
	
	for (let i = 0; i < array.length; i++) {
		for (let j = i; j > 0; j--) {
			if (array[j] < array[j-1]) {
				let temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
			}
		}
		
	}
	
	return array;
}


console.log(InsertionSort(test_array));