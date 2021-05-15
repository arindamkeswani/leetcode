// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 


class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0){ //if input is empty
            return res;
        }
        
        Arrays.sort(nums); //sort array as repeated elements would be adjacent to each other
        bt(0, new ArrayList<Integer>(), nums);
        return res;
    }
    
    public void bt(int start, ArrayList<Integer> curr,int[] nums){
        res.add(new ArrayList<>(curr)); //add current subset to final result
        
        for(int i=start; i<nums.length;i++){ 
            if(i>start && nums[i]==nums[i-1]){ //if previous element was same, skip this iteration
                continue;
            }
            curr.add(nums[i]); //add current element to current subset
            bt(i+1, curr, nums); //take this updated subset and work for next element
            curr.remove(curr.size()-1); //backtrack and remove current element to try next combination
        }
    }
}