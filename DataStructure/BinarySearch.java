public class HelloWorld{

    public static int binarySearch(int[] nums, int target) {
    
    	//Base Case
    	if(nums == null || nums.length == 0) return -1;
    
    	int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
        	mid = (left + right) / 2;
          if (target > nums[mid]) left = mid + 1;   //if it is mid, then if the array is {8,9}, mid/left would always be 8, infinite loop
    		else if (target < nums[mid]) right = mid; // mid - 1;
    		else return mid; 
            System.out.println(nums[left] + "  " + nums[right]);
        }
      
    	return -1;
        
    }
  
  
     public static void main(String []args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; int target = 1;
        //int[] nums = {1, 2}; int target = 1;
        //int[] nums = {1, 2, 3}; int target = 1;
        int result = binarySearch(nums, target);
        System.out.println(result);
     }
  
}


// TODO : Waiting for a recursive version