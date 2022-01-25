package leetcode;

/**
 * @author huimin
 * @create 2022-01-25 0:37
 */
public class T1861_rotating_the_box {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;
        char[][] res = new char[col][row];

        int base = 0;
        int stoneBeforeBlock = 0;
        for(int i=0; i<row; i++){

            int j;
            for(j=0; j<col; j++){
                if(box[i][j] == '#'){
                    stoneBeforeBlock ++;
                } else if(box[i][j] == '*' ){
                    for(int k=base; k<j-stoneBeforeBlock; k++){
                        res[k][row-1-i]='.';
                    }
                    for(int k=j-stoneBeforeBlock; k<j;k++){
                        res[k][row-1-i]='#';
                    }
                    res[j][row-1-i] = '*';
                    stoneBeforeBlock = 0;
                    base = j+1;
                }

            }
            for(int k=base; k<j-stoneBeforeBlock; k++){
                res[k][row-1-i]='.';
            }
            for(int k=j-stoneBeforeBlock; k<j;k++){
                res[k][row-1-i]='#';
            }

            stoneBeforeBlock = 0;
            base = 0;
        }
        return res;
    }
}
