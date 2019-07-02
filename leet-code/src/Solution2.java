/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/6/25 16:03
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = "[";

        ListNode ln = this;
        while (ln != null) {
            str += ln.val + ",";
            ln = ln.next;
        }
        str = str.substring(0, str.length() - 1);

        str += "]";

        return str;
    }
}

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/6/26 11:14
 * 2. 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);

        Solution2 solution = new Solution2();
        ListNode ln = solution.addTwoNumbers(l1, l2);
        System.out.println(ln);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int num;
        int jw = 0;
        ListNode countNode = new ListNode(0);
        ListNode rootNode = countNode;
        ListNode leapNode = null;

        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            num = val1 + val2 + jw;
            jw = num / 10;
            countNode.val = num % 10;
            countNode.next = new ListNode(0);
            leapNode = countNode;

            countNode = countNode.next;
        }

        if (jw != 0) {
            countNode.val = jw;
        } else {
            leapNode.next = null;
        }

        return rootNode;
    }

}
