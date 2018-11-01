package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

public class Middle1 {
	
	/*
	 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

		你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	 * 		输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
			输出：7 -> 0 -> 8
			原因：342 + 465 = 807
	 */
	
	
	/*
	 * 实体类
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/*
	 * my answer
	 */
	public List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
		int i1 = 0;
		int i2= 0;
		for (int i = l1.size()-1; i >= 0; i--) {
			i1 += l1.get(i)*Math.pow(10, i);
		}
		for (int i = l2.size()-1; i >= 0; i--) {
			i2+= l2.get(i)*Math.pow(10, i);
		}
		int i3 = i1+i2;
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= (i3+"").length(); i++) {
			int a = (int) (i3/Math.pow(10, i-1)%10);
			res.add(a);
		}
		return res;
	}
	
	/*
	 * answer
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	/*
	 * test
	 */
	public static void main(String[] args) {
		/*
		 * 我的答案测试
		 */
		Middle1 m = new Middle1();
		List<Integer> l1 = new ArrayList<>();
		l1.add(9);
		l1.add(9);
		List<Integer> l2 = new ArrayList<>();
		l2.add(4);
		System.out.println(m.addTwoNumbers(l1,l2));
		
		/*
		 * 正确答案测试
		 */
//		ListNode a = m.new ListNode(101);
//		ListNode b = m.new ListNode(211);
//		
//		System.out.println(m.addTwoNumbers2(a, b).val);
		
	}
	
}
