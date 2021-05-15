// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]



class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int n = nums.length;
        for(int i=0;i<n+1;i++){
            backtrack(0, new ArrayList<Integer>(), nums, i, res);//curr index, current subset, array
        }
        
        return res;
    }
    
    public void backtrack(int first, List<Integer> curr, int[] nums, int k,List<List<Integer>> res ){//first=starting index for curr combination
        //if combination is complete
        if(curr.size() == k){
            res.add(new ArrayList(curr));
            return;
        }
        
        for(int i=first; i<nums.length;i++){
            //add i into the current combo
            curr.add(nums[i]);
            //use next element to complete combination in the list
            backtrack(i+1, curr, nums,k,res);
            //backtrack
            curr.remove(curr.size()-1);
        }
    }
}