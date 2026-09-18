class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col){
        if(row == 9){
            return true;
        }

        int nRow = row;
        int nCol = col+1;

        if(nCol == 9){
            nRow = row+1;
            nCol=0;
        }

        if(board[row][col] != '.'){
            return solve(board, nRow, nCol);
        }

        for(char i='1'; i<='9'; i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i;

                if(solve(board, nRow, nCol)){
                    return true;
                }

                board[row][col] = '.';
            }
        }


        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, int n){
        for(int i=0; i<9; i++){
            if(board[i][col] == n){
                return false;
            }

            if(board[row][i] == n){
                return false;
            }
        }

        int cRow = (row/3)*3;
        int cCol = (col/3)*3;

        for(int i=cRow; i<cRow+3; i++){
            for(int j=cCol; j<cCol+3; j++){
                if(board[i][j] == n){
                    return false;
                }
            }
        }

        return true;       
    }
}