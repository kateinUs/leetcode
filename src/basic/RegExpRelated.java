package basic;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2022-09-19 14:27
 */
public class RegExpRelated {
    public static void main(String[] args) {
        // 替换String中的标点成空格
        String str1 = "Hi, I'm Tom. Nice to meet you!";
        String res = str1.replaceAll("[^a-zA-Z0-9]", " ");
        System.out.println(res);
        System.out.println(res.toLowerCase());

        String str2 = "Hello     world  I like    Java  ";
        // 按照空格分隔，空格数量可以大于等于1
        String[] splits = str2.split("\\s+"); // \\s代表空格； +代表大于等于一个
        for(String s: splits){
            System.out.print(s +" ");
        }
        System.out.println();


        // 如果题目要求是分解出一个句子中所有的单词，并且计算单词出现的频率
        String input = "Hi, I'm Tom. Nice to meet you! How are you? I am fine, thank you! And you?";
        String trans = input.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] spls = trans.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();

        for(String s: spls){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        map.forEach((k, v) -> System.out.println(k + " = "+ v));

    }
}
