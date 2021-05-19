class Solution {
    
    public int shipWithinDays(int[] weights, int days) {
        
        int min = 1;
        int max = 50000*500+1;
        
        // int s=0;
        // for(int i=0;i<weights.length; i++){
        //     // min = Math.min(min, weights[i]);
        //     // max = Math.max(max, weights[i]);
        //     s+=weights[i];
        // }
        
        
        int ans=Integer.MAX_VALUE;
        while(max>=min){ //apply binary search 
            int mid = (min+max)/2;
            if(cap(mid , days, weights)==true){
                max=mid - 1;
                ans = Math.min(ans,mid);
                
            }else{
                min=mid+1;
            }
        }
        
        
        return ans;
        
    }
    
    public static boolean cap(int mid, int days, int weights[]){ //function to check whether given capacity is sufficient or not
        // System.out.println("MID "+mid);
        int d=days;
        int i=0;
        int n=weights.length;
        
        while(d>0){ //days finished, weights didnt
            int m=mid;
            while(i<n && m-weights[i] >= 0 ){ //while given cap can handle the workload for the day, in order of appearance
                m -= weights[i];
                i++;
            }
            
            if(i==n){ //completed the weights array within cap
                // System.out.println("T "+mid);
                return true;
            }
            d-=1;
        }
        
        // System.out.println("F "+mid);
        return false;//ran out of days to pack weights array within cap
        // if(mid*days >= s ){
        //     return true;
        // }
        // return false;
    }
}