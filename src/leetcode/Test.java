package leetcode;

/**
 * @author huimin
 * @create 2021-05-21 19:09
 */
public class Test {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.next();
        String str = "acbacdefc";
//        int len = str.length();
//        System.out.println(str.indexOf("a"));
        int count = 0;
        for(int i=str.indexOf("a"); i>=0; i=str.indexOf("a", i+1)){
            for(int j=str.indexOf("b", i); j>=0; j=str.indexOf("b", j+1)){
                for(int k=str.indexOf("c", j); k>=0; k=str.indexOf("c",k+1)){
                    count++;
                }
            }
        }
        System.out.println(count);
       Math.min(1,2);


    }
}
