/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/7/4 16:35
 * <p>
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution7 {

    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(-1234099999));
    }

    public int reverse(int x) {
        long s = 0;

        while(x != 0){
            s = s * 10 + x % 10;
            x = x / 10;
        }

        if(s < Integer.MIN_VALUE || s > Integer.MAX_VALUE){
            return 0;
        }

        return (int)s;
    }
}
