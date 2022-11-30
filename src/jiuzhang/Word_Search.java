package jiuzhang;

import java.util.List;

/**
 * LintCode 123: word search 1 (T/F)
 * 给一个字符矩阵，和一个单词，返回是否可以找到一个路线拼成这个单词
 * 输入: board = ["ABCE","SFCS","ADEE"]
 *       word = "ABCCED"
 * 输出： true
 *
 * LintCode 132: word search 2 (求具体方案)
 *  给一个字符矩阵，和一组单词，返回是否可以找到路线拼成这些单词，返回能拼成的单词
 * 输入：board = ["doaf","agai","dcan"]，dict = ["dog","dad","dgdg","can","again"]
 * 输出：["again","can","dad","dog"]
 *
 * LintCode 1484: word search 3 (求方案数 DP)
 *
 * @author huimin
 * @create 2022-11-29 0:28
 */
public class Word_Search {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Word_Search test = new Word_Search();
        String[] strings = {"ABCE","SFCS","ADEE"};
        char[][] board = new char[strings.length][strings[0].length()];
        for(int i=0; i<strings.length; i++){
            for(int j=0; j<strings[0].length(); j++){
                board[i][j] = strings[i].charAt(j);
            }
        }

        String word = "ABCCED";
        System.out.println(test.wordSearch1(board, word));
    }
    // word search 1 只需要判断是否存在，且寻找的单词只有一个，可以用DFS 加回溯来做
    public boolean wordSearch1(char[][] board, String word){
        if(word == null || word.length() == 0) return true;
        if(board.length == 0) return false;
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] visited;
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[ROWS][COLS];
                    if(dfs1(board, word, i, j, 1, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean dfs1(char[][] board, String word, int i, int j, int index, boolean[][] visited){
        if(index == word.length()) return true;

        visited[i][j] = true;
        for(int[] dir:dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if(ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length ||
                    visited[ni][nj] || board[ni][nj] != word.charAt(index)){
                continue;
            }
            if(dfs1(board, word, ni, nj, index+1, visited)){
                return true;
            }
        }
        return false;
    }

    // Word search 2 要查找多个单词，如果用上面wordsearch1的方法，在寻找match的字母时，在字典里一个个找过去
    // 时间复杂度很高 -> O(M*N*K)
    // M = board.length; N = board[0].length, K = words.size()
    // 所以需要用额外的数据结构来优化时间
    // 这里我们可以用Trie 字典树结构
    // 使用字典树后的字母查询时间为O(1)
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here


        return null;
    }
}
