// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res={-1,-1};
        
        for(int i=0;i<nums.length-1;i++){
            if(res[0]==-1){
                for(int j=i+1;j<nums.length;j++){
                        if(nums[i]+nums[j]==target){
                            res[0]=i;res[1]=j;
                            break;
                        }
                    }
            }
            else{
                break;
            }
            }
        return res;
        }
    }
//Hashmap solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //Retrieving value is easier in a hashmap
        for(int i=0;i<nums.length; i++){
            int complement = target-nums[i]; //calculate complement of current index
            if(map.containsKey(complement) ){ //if the complement exists in table
                return new int[] {map.get(complement), i}; //return complement and current index
            }
            map.put(nums[i], i); //put values in hashmap
        }
        throw new IllegalArgumentException("No two sum solution");
        }
    }
