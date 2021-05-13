// Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

// Return the shortest such subarray and output its length.

 

// Example 1:

// Input: nums = [2,6,4,8,10,9,15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
// Example 2:

// Input: nums = [1,2,3,4]
// Output: 0
// Example 3:

// Input: nums = [1]
// Output: 0

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int l= nums.length, r=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[j] < nums[i]){
                    r=Math.max(r,j);
                    l=Math.min(l,i);
                }
            }
        }
        return r-l<0? 0: r-l+1;
        
    }
}
//////////////////////Optimal solution
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        boolean flag=false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
               flag=true;
            }
            if(flag){
                min = Math.min(min, nums[i]); //store minimum wrong element
            }
        }
        
        flag=false;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] > nums[i+1]){
                flag=true;
            }
            if(flag){
                max=Math.max(max,nums[i]) ;//store max wrong element
            }
        }
        
        int l,r;
        for(l=0; l<nums.length;l++){
            if(min<nums[l]){ //found current position of minimum value
                break;
            }
        }
        for(r=nums.length-1; r>=0;r--){
            if(max > nums[r]){ //found current position of maximum value
                break;
            }
        }
        
        return r-l<0? 0: r-l+1; //return size of subarray
        
        
    }
}