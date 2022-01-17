package meta;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2021-11-30 11:11
 */
public class CanGetExchange {
    static{
        HashMap<Character, Character> matching = new HashMap<>();
        matching.put(')', '(');
        matching.put(']', '[');
        matching.put('}', '{');
    }

    static boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        int len = denominations.length;
        for(int i=len-1; i>=0; i--){
            if(targetMoney==denominations[i])
                return true;
            else if(targetMoney < denominations[i])
                continue;
            else
                return canGetExactChange(targetMoney-denominations[i], denominations);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 17,29};
        boolean res  =canGetExactChange(74, arr);
        System.out.println(res);
    }

    boolean canGetExactChange2(int targetMoney, int[] denominations) {
        if(targetMoney < 0)
            return false;
        if(targetMoney == 0)
            return true;
        for(int i = 0; i < denominations.length;i++){
            if(canGetExactChange(targetMoney - denominations[i], denominations)){
                return true;
            }
        }
        return false;

    }
}
