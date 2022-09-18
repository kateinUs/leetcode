package oa;

/**
 * Given a string S, the task is to find out the minimum no of adjacent swaps required to make string s palindrome.
 * If it is not possible, then return -1.
 *
 * Example:
 * Input: aabcb Output: 3
 * Explanation:
 * After 1st swap: abacb; After 2nd swap: abcab; After 3rd swap: abcba
 *
 * Input: adbcdbad Output: -1
 *
 * https://www.geeksforgeeks.org/count-minimum-swap-to-make-string-palindrome/
 *
 * @author huimin
 * @create 2022-09-06 14:51
 */
public class Minimum_swaps_to_make_string_palindrome {

}

/*
int minSwap(string s)
{
    unordered_map<char, int> unmp;
    int odd = 0, left = 0, right = s.size() - 1, result = 0;

    for (char ch : s)
        unmp[ch]++;

    for (auto i : unmp)
        if (i.second % 2 == 1)
            odd++;

    if (odd > 1)
        return -1;

    while (left < right) {
        int l = left, r = right;
        while (s[l] != s[r])
            r--;
        if (l == r) {

            // when we found odd element
            swap(s[r], s[r + 1]);
            result++;
            continue;
        }
        else {
            // Normal element
            while (r < right) {
                swap(s[r], s[r + 1]);
                result++;
                r++;
            }
        }
        left++, right--;
    }
    return result;
}

// Driver's code
int main()
{
    string s = "aabcc";
    cout << minSwap(s);
    return 0;
}
 */
