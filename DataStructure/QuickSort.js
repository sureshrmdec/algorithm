/**************************************************
Name: Quick Sort base case
Cost: worst-case O(N2)  expected O(N log N)
Note:
	choose a pivot value which is in the middle of the array
	partition the array:
	left part has items <= pivot 
	right part has items >= pivot
	recursively sort the left part 
	recursively sort the right part
	




**************************************************/
let test_array = [13, 4, 1,7,12, 2, 11, 9, 3,6,5,14,8,10,0,15];

function QuickSort (array, start, end) {
    //base case          
	if(start >= end)
		return;
						console.log("----------------------------------------" + array.slice(start, end+1))
	let left = start       
	let right = end       
	let partionIndex = Math.floor((left + right) / 2)    
	let pivot = array[partionIndex]

	while(left < right) {
	  
    	    				console.log("before moving" + "left: " + array[left] + "  right: " + array[right]+"pivot " + pivot)
	  	while(array[left] <= pivot && left < right)
	      left++
	    while(array[right] >= pivot && left < right)
	      right--
      	 	  				console.log("after moving" + "left: " + array[left] + "  right: " + array[right]+"pivot " + pivot)
	    //swap large value in the left with the small value in the right    
	  	if(left < right) {
	  	               	    console.log("before swap: " + array)
	  	               		console.log("left: " + array[left] + "  right: " + array[right]+ "  pivot: " + array[partionIndex])
	  	    let temp = array[left]
	  	    array[left] = array[right]
	  	    array[right] = temp
	  	    left++
	  	    right--
	  	              		console.log("after  swap: " + array)
	  	 }
  	      
    }
        
    //make sure only pivot in the left array and dividing point also in the left small array and vise verse
    //for that case that there are just two elements
	if((array[partionIndex] < array[left] && partionIndex >left) ||
	    (array[partionIndex] > array[left] && partionIndex <left) )
	{
	        console.log("before partionIndex swap: " + array)
	        console.log("left: " + array[left] + "  right: " + array[right]+ "  pivot: " + array[partionIndex])
	    let temp = array[partionIndex]
	    array[partionIndex] = array[left]
	    array[left] = temp
	    					console.log("after  partionIndex swap: " + array)
	}
        
    partionIndex = left //now left == right, where the dividing point between big numbers and small numbers is
          					console.log("start: " + start + " partionIndex - 1: " + (partionIndex - 1))
          					console.log("partionIndex+1: " + (partionIndex+ 1) + " end: " + end)
    //array[parthinIndex] is already in the right position in the array, so we can sort the left array without it
	QuickSort(array, start, partionIndex - 1)
    QuickSort(array, partionIndex + 1, end)
    //we dont need the return value ,cause we sort it in place
}

QuickSort(test_array, 0, test_array.length - 1) //test_array would be changed in place in QuickSort
console.log(test_array)
