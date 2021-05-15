// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]



class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); //to store final results
        LinkedList<Integer> comb = new LinkedList<>(); //to store the combination to be testes
        
        HashMap<Integer,Integer> counter = new HashMap<>();//count frequency of each unique element
        
        for(int candidate: candidates){ //put elements inside frequency table
            if(counter.containsKey(candidate))
                counter.put(candidate, counter.get(candidate) + 1);
            else
                counter.put(candidate,1);
        }
        
        // convert the counter table to a list of (num, count) tuples
        List<int[]> counterList = new ArrayList<>();
        counter.forEach((key, value) -> {
            counterList.add(new int[]{key, value});
        });
        
        backtrack(comb, target,0,counterList, res);
        return res;
        
    }
    
    private void backtrack(LinkedList<Integer> comb, int remain, int curr,List<int[]> counter,
                           List<List<Integer>> results){
        
        if(remain==0){ //conditions met
            //Make a deep copy of current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        
        for(int nextCurr = curr ; nextCurr< counter.size(); nextCurr++){//traverse counter table
            int entry[]= counter.get(nextCurr);
            Integer candidate = entry[0]; //the number we are currently at, in the counter table
            Integer freq = entry[1]; //above number's frequency
            
            if(freq<=0) //cannot use this number any more
                continue;
            
            
            if(remain-candidate>=0){ //reduce number of calculations for comb that will be invalid
                // add a new element to the current combination
                comb.addLast(candidate);
                counter.set(nextCurr, new int[]{candidate, freq-1});

                // continue the exploration with the updated combination
                backtrack(comb, remain - candidate, nextCurr, counter, results);

                // backtrack the changes, so that we can try another candidate
                counter.set(nextCurr, new int[]{candidate, freq});
                comb.removeLast();
            }
            
            
            
        }
    }
}