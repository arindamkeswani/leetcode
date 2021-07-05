class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        boolean out=false;
        
        
        int i=0;int j=n-1;
        
        while(i<m && j>=0){
            if(matrix[i][j]>target){
                    j--;
                }
            else if(matrix[i][j]<target){
                i++;
            }
            else{
                out=true;
                break;
            }
        }
//         for(int i=0;i<m;i++){
            
//             int lo=0;
//             int hi=n-1;
            
            
//             int loElem=matrix[i][lo];
//             int hiElem=matrix[i][hi];
            
//             while(lo<hi){
//                 int mid=(lo+hi)/2;
//                 int midElem= matrix[i][mid];
                
//                 if(matrix[i][mid]<target){
//                     lo=mid+1;
//                     loElem=matrix[i][lo];
//                 }
//                 else if(matrix[i][mid]>target){
//                     hi=mid-1;
//                     hiElem=matrix[i][hi];
//                 }
//                 else if(matrix[i][mid]==target){
//                     out=true;
//                     break;
//                 }
//             }
            
            
        
        
        return out;
    }
}