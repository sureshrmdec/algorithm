/**************************************************
Name: Merge Sort base case
Cost: Time Complexity is O(NlogN), each layer is  O(1) + O(N), we have logN layers
Note: inner pointer compared the number picked with the number already sorted from right to left, 
	  swithcing with the number in his left while he is moving right.




**************************************************/

//Best Approach, each recursive step just return a new array for the parent layer to poccess/merge,finally the top layer
//just simply return the new array as result, wouldn't touch the original array, note that as the stack of each layer be destroyed,
//their created array would be destroyed too, only return the array to parent layer's stack. So it wouldn't consume too much memory.
let test_array = [1,2,9,3,2,5,14,0];
//let test_array = [14, 9, 2, 4, 12];

function MergeSort (array) {
	if(array.length < 2)
		return array;
	let mid = Math.floor(array.length/2);
	
	let left = MergeSort(array.slice(0, mid));
	let right = MergeSort(array.slice(mid));
	
	let result = [];
	
	while(left.length > 0 && right.length > 0) {
		if(left[0] <= right[0]) {
			result.push(left.shift());
		} else {
			result.push(right.shift());
		}
	}

	return result.concat(left.length ? left : right);
}

console.log(MergeSort(test_array));

	/*
	let array_length = high - low + 1;
	let temp_array = new Array(array_length);
	let left_index = low, right_index = mid +1;
	
	for(let i = low; i < array_length; i++) {
		if(array[left_index] < array[right_index] || right_index == high){
			temp_array[i] = array[left_index];
			left_index++;
		}
			
		else {
			temp_array[i] = array[right_index];
			right_index++;
		}
	}
	
	let i = low;
	while(i < high) {
		test_array[i] = temp_array[i];
		i++;
	}
	*/