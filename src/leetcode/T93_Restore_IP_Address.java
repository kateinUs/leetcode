package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huimin
 * @create 2022-11-27 18:49
 */
public class T93_Restore_IP_Address {
    // 0-255 valid
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(s, 0, 0, path, res);
        return res;
    }
    void dfs(String s, int start, int count, StringBuilder path, List<String> res){
        if(start == s.length() && count == 4){
            res.add(new String(path));
        }
        else if(start == s.length() && count == 4) return ;

        for(int i = start+1; i<=start +3; i++){
            if(i > s.length()) break;
            String tmp = s.substring(start, i);
            if(!isValid(tmp, i-start)){
                continue;
            }
            // tmp is valid
            StringBuilder archive = new StringBuilder(path);
            path.append(tmp);
            if(count < 3)
                path.append(".");
            dfs(s, i, count+1, path, res);
            // backtrack
            path = archive;
        }
    }
    boolean isValid(String s, int n){
        // cannot have leading zero, except for only 1 zero
        int num = Integer.parseInt(s);
        if(n == 1 && num >=0 && num <= 9) return true;
        if(n == 2 && num >=10 && num <= 99) return true;
        if(n == 3 && num >= 100 && num <= 255) return true;
        return false;
    }
}
