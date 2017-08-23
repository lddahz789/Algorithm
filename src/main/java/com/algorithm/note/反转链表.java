package com.algorithm.note;

public class 反转链表 {

	//时间O(n) 空间O(1)
		public ListNode reverseList(ListNode head, int m, int n){
			int len = 0;
			ListNode node1 = head;
			ListNode pre = null;
			ListNode cur = null;
			while(node1 != null){
				len++;
				pre = (len == m - 1)? node1:pre;
				cur = (len == n + 1)? node1:cur;
				node1 = node1.next;
			}
			if (m > n || m <1 || n > len)
				return head;
			node1 = (pre == null)?head:pre.next;
			ListNode node2 = node1.next;
			node1.next = cur;
			ListNode next = null;
			while(node2 != cur){
				next = node2.next;
				node2.next = node1;//面试题这里写错了
				node1 = node2;
				node2 = next;
			}
			if (pre != null){
				pre.next = node1;
				return head;
			}
			return node1;
		}
}

class ListNode {
	int val;
	ListNode next;
}
