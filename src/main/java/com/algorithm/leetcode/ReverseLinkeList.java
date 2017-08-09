package com.algorithm.leetcode;

import java.util.Stack;

public class ReverseLinkeList {

	
	/**
	 * 翻转链表
	 * @param root
	 * @return
	 */
	public  ListNode reverseLinkedList(ListNode root){
		if (root == null) {
            return root;
        }
		ListNode p1 = root;
		ListNode p2 = root.next;
		p1.next = null;
		
		while(p2 != null){
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}
		return p1;
	}
	
	/**
	 * 翻转链表 栈解法
	 * @param head
	 * @return
	 */
	public  ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode cur = newHead;
        while (!stack.isEmpty()){
           cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }
	
	
	/**
	 * 翻转链表 m - n
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
        
		return null;//TODO
    }
	
}



