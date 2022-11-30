package classic;

import java.util.*;

/**
 *
 * @author huimin
 * @create 2021-07-24 14:59
 */
public class CountPrimeNumber {
    //方法一： 正向思维
    public static int primeNunberLessThanN(int n){
        int count = 0;

        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                System.out.println(i);
                count ++;
            }
//            count += isPrime(i) ? 1 : 0;
        }

        return count;
    }

    private static boolean isPrime(int x) {
        // i<= Math.sqrt(x) / i*i <= x
        for(int i=2; i<= Math.sqrt(x); i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        primeNunberLessThanN(10);
    }

    // 方法二：埃式筛选法
    // 利用合数的概念（非素数），素数*n必然是合数，因此可以从2开始遍历，将所有的合数做上标记
    // 缺点： 3*4 和 4*3 出现多余的循环 优化： 2 * i 优化到 i * i
    public static int eratosthenes(int n){
        boolean[] isComposite = new boolean[n]; // default is false, assume all prime number
        for(int i=2; i<= (int)Math.sqrt(n); i++){
            if(!isComposite[i]){
                for(int j=i*i; j<n; j+=i){ // j 就是合数的标记位
                    isComposite[j] = true;
                }
            }
        }

        int numberOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (isComposite[i] == false) {
                ++numberOfPrimes;
            }
        }
        return numberOfPrimes;
    }

}
