package com.algorithm.leetcode;

public class MergeTwoSortedLinkedList {

	
	public static ListNode merge(ListNode head1,ListNode head2){
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		ListNode mergedHead = null;
		if(head1.data < head2.data){
			mergedHead = head1;
			mergedHead.next = merge(head1.next,head2);
		}
		if(head1.data > head2.data){
			mergedHead = head2;
			mergedHead.next = merge(head1,head2.next);
		}
		return mergedHead;
	}
	
	public static void main(String[] args) {
		
	}
}


