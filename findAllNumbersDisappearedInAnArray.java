// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

// Example 1:

// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]
// Example 2:

// Input: nums = [1,1]
// Output: [2]

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        Map<Integer,Boolean> flag=new HashMap<>();
        
        
        
        for(int i=0;i<nums.length;i++){
            flag.put(nums[i],true);
        }
        
        // int c=0;
        List<Integer> res=new ArrayList<Integer>();  
        
        for(int i=1;i<=nums.length;i++){
            if(flag.containsKey(i)){
                continue;
            }else{
                res.add(i);
            }
        }
        
        
        return res;
    }
}    