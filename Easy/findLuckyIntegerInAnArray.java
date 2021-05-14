class Solution {
    public int findLucky(int[] arr) {
        Map <Integer,Integer> res= new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(res.containsKey(arr[i])){
                // System.out.println(res.get(arr[i]));
                res.put(arr[i], res.get(arr[i]) + 1); //put all values with their frequencies in the hashmap
            }
            else{
                res.put(arr[i],1); //initialise first occurence in hashmap
            }
            
        }
        
        int lucky=Integer.MIN_VALUE;
        // int max=Integer.MIN_VALUE;
        
        for(Integer key: res.keySet()){ //iterate through all keys
            if(key == res.get(key) && key>lucky){ //if number is "lucky", and it is greater than previous lucky number, update it
                lucky = key;
            }
        }
        // System.out.println(res);
        if(lucky>Integer.MIN_VALUE){
            return lucky;    
        }else{
            return -1;
        }
        
    }
}