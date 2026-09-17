class nQueens {
    static int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] =  '.';
            }
        }
        Nqueens(board, 0, n);
        return count;
    }
    public void Nqueens(char[][] board, int row, int n){
        if(row == n){
            count++;
            return;
        }
        for(int i=0; i<n; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                Nqueens(board, row+1, n);
                board[row][i] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int col){
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

}