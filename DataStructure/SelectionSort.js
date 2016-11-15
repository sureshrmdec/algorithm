/**************************************************
Name: Selection Sort base case
Note: Time Complexity is O(N^2)
Data: 11/14/2016

**************************************************/


let test_array = [9, 2, 4, 1, 6, 8];


function SelectionSort(array) {
	let min, min_index;
	for (let i = 0; i < array.length; i++) {
		min = array[i];
		min_index = i;
		for (let j = i; j < array.length; j++) {
			if (array[j] < min) {
				min = array[j];
				min_index = j;
			}
		}
		array[min_index] = array[i];
		array[i] = min;
	}
	
	return array;
}


console.log(SelectionSort(test_array));