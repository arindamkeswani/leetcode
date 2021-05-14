// Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.

// You may return any answer array that satisfies this condition.

 

// Example 1:

// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        // int count_odd=0;
        // int count_even=0;
        
        int odd_pointer=nums.length-1; //index to store odd elements
        int even_pointer=0; //index to store even elements
        int res[] = new int[nums.length]; //result array
        
        //         for(int i=0;i<nums.length;i++){
        //             if(nums[i]%2==0){
                        
        //             }
        //         }
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2 == 0){ 
                res[even_pointer++] = nums[i];
                
            }
            else{
                res[odd_pointer--] = nums[i];
                // if(odd_pointer<nums.length-1){
                //     res[odd_pointer--] = nums[i];
                // }else{
                //     int temp = res[odd_pointer+1];
                //     res[odd_pointer+1]=nums[i];
                //     res[odd_pointer]=temp;
                //     odd_pointer--;
                // }
                
            }
        }
        
        return res;
    }
    

}