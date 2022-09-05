package java_masterclass.dynamic_programming;

/**
 * @author huimin
 * @create 2022-02-22 0:43
 */
public class HouseRobber {

    public int maxMoneyTopDown(int[] HouseNetWorth) {
        int dp[] = new int[HouseNetWorth.length];
        return maxMoneyTopDown(dp, HouseNetWorth, 0);
    }


    private int maxMoneyTopDown(int[] dp, int[] HouseNetWorth, int currentIndex) {
        if (currentIndex >= HouseNetWorth.length)
            return 0;

        if (dp[currentIndex] == 0) {
            int stealCurrent = HouseNetWorth[currentIndex] + maxMoneyTopDown(dp, HouseNetWorth, currentIndex + 2);
            int skipCurrent = maxMoneyTopDown(dp, HouseNetWorth, currentIndex + 1);
            dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
        }
        return dp[currentIndex];
    }

    public int maxMoneyBottomUp(int[] wealth) {
        int dp[] = new int[wealth.length + 2]; // '+1' to handle the zero house
        dp[wealth.length] = 0; // if there are no houses, the thief can't steal anything
        for (int i = wealth.length - 1; i >= 0; i--) {
            dp[i] = Math.max(wealth[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

}
