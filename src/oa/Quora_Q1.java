package oa;

import java.util.*;

/**
 * https://drive.google.com/file/d/1p5BMxONn15E_N2yLnwKUoYgN7WScAqRC/view
 *
 * @author huimin
 * @create 2021-09-30 20:05
 */
public class Quora_Q1 {
    /** 1.
     * 给一个数字，求所有位数的乘积减去所有位数的和。
     * e.g. 230 -> 0 - 6 = -6
     * @return
     */
    public int solution1(int i){
        int sum = 0;
        int product = 1;
        while (i > 0) {
            int mod = i % 10;
            i /= 10;
            sum += mod;
            product *= mod;

        }
        return product -sum;
    }

    /** 2.
     * 输入一组 words 和一组 valid letters,判断有多少个 words 是 valid。判断条件是 words
     * 里的所有 upper and lower letter 必须在 valid letters 里面。如果 word 里面有 special
     * character 不用管。注意 valid letter 只有小写,但是 words 里面有大写的也算 valid。比如 words
     * = [hEllo##, This^^], valid letter = [h, e, l, 0, t, h, s]; "hello##" 就是 valid,因为 h,e,l,o
     * 都在 valid letter 里面, “This^^” 不 valid, 因为 i 不在 valid letter 里面
     *
     * broken keyboard
     * input: a = "Hello, my dear friend!", b = ['h', 'e', 'l', 'o', 'm']
     * output: 1
     * 题目是键盘坏了,只剩下 b 中的字母按键和所有的数字和符号案件能用,同时 shift 键是好
     * 的,所以可以切换大小写。问 a 中的单词有几个可以用当前坏掉的键盘打出来。
     */
    public int solution2(List<String> words,char[] validLetter){
        Set<Character> charSet = new HashSet<>();
        int count = 0;
        for (char c: validLetter) {
            charSet.add(c);
        }
        for(int i=0; i<words.size(); i++){
            String word = words.get(i).replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
            boolean isValid = true;
            for(int j = 0; j<word.length(); j++){
                if(!charSet.contains(word.charAt(j))){
                    isValid = false;
                    break;
                }
            }
            if(isValid)
                count++;
        }

        return count;
    }

    /** 3.
     * compare 两个 string,只有小写字母。 每个 stirng 内部可以任意换位置,所以位置不重
     * 要。每个 string 内部两个 letter 出现的频率也可以互换,所以这题只需要两个 string 每个
     * frequency 出现的次数要一样。比如“babzccc” 和 “bbazzcz” 就返回“true”,因为 z 和 c 可
     * 以互换频率。 但是“babzcccm” 和 “bbazzczl” 就不一样,因为 m 在第一个里出现过,第二个
     * 里没有出现过。
     *
     */
    public boolean solution3(String s1, String s2){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0));
        }

        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0));
        }
        Set<Character> keySet1 = map1.keySet();
        Set<Character> keySet2 = map2.keySet();

        Set<Integer> valueSet1 = (Set<Integer>) map1.values();
        Set<Integer> valueSet2 = (Set<Integer>) map2.values();

        if(keySet1 == keySet2 && valueSet1 == valueSet2)
            return true;
        else
            return false;
    }

    /** 4.
     *  输入 a,b 两个 array, 一个 query array。query 有两种 type, 一种是[target]查从 a 中
     * 取一个数,b 中取一个数,求加起来等于 target 的情况有多少种。第二种 query 是[index, num],
     * 把 b 中在 index 位置的数字改成 num,这种 query 不需要输出。最后输出所有第一种 query 的
     * result。
     *
     */
    public int solution4(){

        return 0;
    }

    /** 5.
     * Find how many numbers have even digit in a list.
     * Ex.Input: A = [12, 3, 5, 3456]
     *
     */
    public int solution5(int[] list){
        int evenNumCount = 0;
        for(int i=0; i<list.length; i++){
            int len = String.valueOf(list[i]).length();
            if(len % 2 == 0)
                evenNumCount++;

        }
        return evenNumCount;
    }

    /** 6.
     * Find the most common elements in a list.
     *
     */
    public List<Integer> solution6(int[] list){

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<list.length; i++){
            count.put(list[i], count.getOrDefault(list[i], 0));
        }
        int maxCount =0;
        // Iterate and check which has the maxCounts

        return null;
    }

    /** 7.
     * Maximum size of ribbon
     * Given a list representing the length of ribbon, and the target number "k" parts of
     * ribbon.
     *
     * we want to cut ribbon into k parts with the same size, at the same time we want
     * the maximum size.
     * Ex.
     * Input: A = [1, 2, 3, 4, 9], k = 5
     * Output: 3
     *
     * Explanation:
     * if size = 1, then we have 19 parts
     * if seize = 2, then we have 8 parts
     * if size = 3, then we have 5 parts
     * if size = 4, then we have 3 parts, which is not enough.
     * So return the max size = 3.
     * Sol.
     * Use binary search to find the size of the ribbon to reach the time limit.
     */
    public int solution7(int[] list, int target){
        int sum =0;
        for(int i: list){
            sum += i;
        }
        int size = sum / target; // get average
        boolean temp = check_avail(list, size, target);
        if(temp)
            size--;
        else
            size++;



        return 0;
    }
    private boolean check_avail(int[] list, int size, int target){
        int part = 0;
        for(int i=0; i<list.length; i++){
            if(list[i] > size)
                part++;
        }
        if(part >= target)
            return true;
        else
            return false;
    }

    /*include <bits/stdc++.h>
    using namespace std;
    class Solution {
        public:
        int countBinarySubstrings(string s) {
            int cnt[2] = { 0 };
            int res = 0;
            for (int i = 0; i < s.length(); ++i) {
                int num = s[i] - '0';
                if (i == 0 || s[i] != s[i - 1])
                    cnt[num] = 0;
                ++cnt[num];
                if (cnt[num] <= cnt[1 - num])
                    ++res;
            }
            return res;
        }
    };
    main(){
        Solution ob;
        cout << (ob.countBinarySubstrings("11001100"));
    }*/

    /** 8. GoodTuples
     * Give an array and find the count of a pair number and a single number combination
     * in a row of this array. Target array is a[i - 1], a, a[i + 1]
     * Example:
     * Input: a = [1, 1, 2, 1, 5, 3, 2, 3]
     * Output: 3
     * Explain:
     * [1, 1, 2] -> two 1 and one 2(O)
     * [1, 2, 1] -> two 1 and one 2(O)
     * [2, 1, 5] -> one 2, one 1 and one five(X)
     * [1, 5, 3] -> (X)
     * [5, 3, 2] -> (X)
     * [3, 2, 3] -> (O)
     * // using hashmap and set with window size 3, check if the set size is 2 or not
     *
     * @param list
     * @param target
     * @return
     */
    public int solution8(int[] list, int target){

        return 0;
    }
    /** 8变形. different characters
     * intput: a = "aabdcreff"
     *
     * output: 5
     * 问 a 中存在多少 a, a[i-1], a[i+1]都不同的情况
     *
     */

    /** 9. Rotate matrix among Diagnals
     *      rotate with k
     * 对角线方向旋转矩阵中的元素 k 次,其中 1<= k <= 4
     *
     * @param list
     * @param target
     * @return
     */
    public int solution9(int[] list, int target){

        return 0;
    }

    /** 17. diagonalsSort
     * int fun(int[][] a), 把一个 matrix 按斜线顺序重排
     * [8, 4, 1]     [4, 1, 1]
     * [4, 4, 1] --> [4, 8, 4]
     * [4, 8, 9]     [4, 8, 9]
     *
     * Sort for each diagonal, using priorityqueue offer it and poll it, increase the index
     *
     * @param list
     * @return
     */
    public int[][] solution17(int[][] list){

        List<Map.Entry<String, Integer>> ls= new ArrayList<>();
        ls.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return 0;
            }
        });
        Collections.sort(ls, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return 0;
            }
        });
        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        return null;
    }

}
