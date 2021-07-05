class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length-1;
        
        while(left <= right){ //equal condn is important
            int mid = left + (right-left)/2;
            
            if(nums[mid]==target){
                return mid;
            }else if(nums[left]<=nums[mid]){ //left part is sorted
                if(nums[left]<=target && target<=nums[mid]){ //checking if target is in left part
                    right = mid-1; //search leftward
                }else{
                    left=mid+1; //search rightward
                }
            }else{ //right part is sorted
                if(nums[mid]<=target && target<=nums[right]){//checking if target is in right part
                    left=mid+1; //search rightward 
                }else{
                    right=mid-1; //search leftward
                }
            }
        }
        
        return -1; //if not found
    }
}