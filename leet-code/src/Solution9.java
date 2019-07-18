/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/7/18 10:30
 * <p>
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution9 {

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(11));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int s = x;
        int e = 0;
        while (x != 0) {
            e = e * 10 + x % 10;
            x /= 10;
        }

        if (s == e) {
            return true;
        }

        return false;
    }
}
