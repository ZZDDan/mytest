/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/7/1 16:02
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution5 {

    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("aaabaaaa"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int i = 0;
        int j = len - 1;

        String result = "";

        while (i < j) {
            int m = i;
            int n = j;

            while (m < n) {
                char a = s.charAt(m);
                char b = s.charAt(n);
                if (a == b) {
                    m++;
                    n--;
                } else if(m == i){
                    n--;
                } else {
                    n += m - i - 1;
                    m = i;
                }
            }


            if(m != i){
                int lpLen;
                if(m == n){
                    lpLen = (m - i) * 2 + 1;
                } else {
                    lpLen = (m - i) * 2;
                }

                if(lpLen > result.length()){
                    result = s.substring(i, lpLen + i);
                }
            }

            i++;
        }

        if(result.length() == 0 && len > 0){
            result = s.substring(0, 1);
        }

        return result;
    }

}
