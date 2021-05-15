// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false

class Solution {
   
    public boolean exist(char[][] board, String word) {
        //Search for every character till it matches the first char of target, then perform depth first search
       for(int i=0;i<board.length;i++){
           for(int j=0;j<board[i].length;j++){ 
               if(board[i][j]==word.charAt(0) && dfs(board, i, j, 0, word)){//0 is default number of characters found
                   return true;
               }
           }
       }
        
        return false;
    }
    
    public boolean dfs(char [][]board, int i, int j,int count, String word ){
        if(count==word.length()){ //this is a post operation condition. It will not be checked initially, but only after making sure that board[i][j]==word.charAt(count) in the next condition
            return true;
        }
        
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j]!=word.charAt(count) ){ //if out of bounds or if curr character does not match
            return false;
        }
        
        char temp = board[i][j]; //store val of current cell, to be replaced later
        board[i][j] = ' '; //change val of cell so that same cell is not repeated in evaluation
        
        //check for up, down, left, right neighbours
        boolean flag = dfs(board, i-1, j,count + 1, word) 
                       || dfs(board, i+1, j,count + 1, word)
                        ||dfs(board, i, j-1,count + 1, word)
                        ||dfs(board, i, j+1,count + 1, word);
        board[i][j]=temp;
        return flag;
    }
    
    
}