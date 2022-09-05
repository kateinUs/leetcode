package leetcode;

/**
 * @author huimin
 * @create 2022-02-18 17:25
 */
public class T79_Word_Search {
    char[][] board;
    int ROWS;
    int COLS;
    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, String word, int index) {
        // check bottom case
        if(index >= word.length())
            return true;
        // if current index go out or the element not equals to what we want
        if(row<0 || row==ROWS || col<0 || col==COLS || board[row][col] != word.charAt(index))
            return false;

        boolean res = false;
        board[row][col] = '#';
        for(int i=0; i<4; i++){
            if(dfs(row+ dir[i][0], col+dir[i][1], word, index+1))
                return true;
        }
        // clean up and fill up the letter again
        board[row][col] = word.charAt(index);
        String s ="we";
        s.indexOf(' ', 0);
        return false;
    }
}
