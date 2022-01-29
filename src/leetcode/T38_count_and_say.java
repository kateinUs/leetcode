package leetcode;

/**
 * @author huimin
 * @create 2022-01-26 0:09
 */
public class T38_count_and_say {
    // bottom up
    public static String countAndSay(int n) {
        if(n==1)
            return "1";
        String s = "1";
        for(int i=2; i<=n; i++){
            int cnt =1;
            char prev = s.charAt(0);
            StringBuilder newStr = new StringBuilder();
            for(int j=1; j<s.length(); j++){
                if(prev == s.charAt(j)){
                    cnt++;
                } else{
                    newStr.append(""+ cnt + prev);
                    prev = s.charAt(j);
                    cnt = 1;
                }
            }
            newStr.append(""+ cnt + prev);
//            System.out.println(newStr);
            s = newStr.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}

