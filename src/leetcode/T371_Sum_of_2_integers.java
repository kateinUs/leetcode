package leetcode;

/**
 * @author huimin
 * @create 2022-08-08 12:32
 */
public class T371_Sum_of_2_integers {
    public int getSum(int a, int b) {
        return add(a, b);
    }
    // x^y的结果是不带carry-on的相加结果，(x&y) << 1是carry-on
    // 所以循环一直到carry-on = 0（参数中 y=0），则x就是相加结果
    int add(int x, int y){
        if(y == 0)
            return x;
        else
            return add(x^y, (x&y) << 1); // y变成carry-on
    }
}
