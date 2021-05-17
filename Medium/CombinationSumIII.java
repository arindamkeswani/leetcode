// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// // Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
// Example 3:

// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
// Example 4:

// Input: k = 3, n = 2
// Output: []
// Explanation: There are no valid combinations.
// Example 5:

// Input: k = 9, n = 45
// Output: [[1,2,3,4,5,6,7,8,9]]
// Explanation:
// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
// ​​​​​​​There are no other valid combinations.

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        bt(res, k , n , 1, new LinkedList()); //0 is current index to start calculcation from
        
        return res;
    }
    
    private void bt(List<List<Integer>> res, int k, int n, int start, LinkedList lsf){
        
        if(k<0 || n<0){ //if we run exceed value of sum or run out of total cost of numbers that can be used, return
            return;
        }
        
        if(k==0 && n==0){ //cost is exact and so is sum
            res.add(new ArrayList<>(lsf)); //add list so far to final result
            return;
        }
        
        for(int i=start;i<=9;i++){
            
            lsf.add(i); //add current element to combination
            bt(res, k-1, n-i, i+1, lsf); // go to next element for checking the new combinations' validity
            lsf.removeLast(); //backtrack
            
            
        }
    }
}