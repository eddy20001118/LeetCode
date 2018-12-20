public class LeetCode2 {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(0);

    public LeetCode2() {
        l1.next = new ListNode(8);
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        leetCode2.addTwoNumbers(leetCode2.l1, leetCode2.l2);
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode a1 = l1, a2 = l2, temp = answer; //这里是引用赋值，所以temp发生变化后answer跟着变化
        int curVal = 0;
        while (a1 != null || a2 != null) {
            int a1val = (a1 != null) ? a1.val : 0;
            int a2val = (a2 != null) ? a2.val : 0;
            int sum = curVal + a1val + a2val;
            curVal = sum / 10; //curVal 是进位运算，如果需要进位，所以要/10（因为下一位比当前位大10倍）然后在下一次迭代中赋值给下一位
            temp.next = new ListNode(sum % 10); //与10取模是在当前位的加法运算
                    temp = temp.next;
            if(a1 != null) a1 = a1.next;
            if(a2 != null) a2 = a2.next;
        }
        if (curVal > 0) {
            temp.next = new ListNode(curVal);
        }
        return answer.next;
    }
}
