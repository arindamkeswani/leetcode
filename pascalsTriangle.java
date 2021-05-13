class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        //0 base case: return empty on 0 rows input
        if(numRows == 0){
            return triangle;
        }
        
        //1 row base case: return default hard-coded values
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        for(int rowNum = 1; rowNum<numRows; rowNum++){
            List<Integer> row = new ArrayList<>(); //initialise new row
            List<Integer> prevRow = triangle.get(rowNum-1); //get list of elements of previous row
            
            //First element of a row is always 1
            row.add(1);
            
            
            for(int j=1; j < rowNum; j++){ //add other elements of the row
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            
            //Last element of a row is always 1
            row.add(1);
            
            triangle.add(row);
        }
        return triangle;
    }
}