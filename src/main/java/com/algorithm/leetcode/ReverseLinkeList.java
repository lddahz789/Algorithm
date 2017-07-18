package com.algorithm.leetcode;

public class ReverseLinkeList {

	
	public static ListNode reverseLinkedList(ListNode root){
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
	
	public static ListNode reverseRecursion(ListNode current){
		if(current.next == null)
			return current;
		while (current.next != null)
		
		return null;//TODO
	}
	
	
	public static void main(String[] args) {
		ListNode root = generateLinkedList(20);
		ListNode newRoot = reverseLinkedList(root);
		while(newRoot != null) {
			System.out.println(newRoot.data);
			newRoot = newRoot.next;
		}
	}
	
	
	public static ListNode generateLinkedList(int num){
		ListNode node = new ListNode(0, null);
		ListNode cur = null;
		ListNode temp = null;
        for(int i = 1 ; i < num;i++){
            temp = new ListNode(i, null);
            if (i == 1) {
                node.next = temp;
            }else{
                cur.next = temp;
            }
            cur = temp;
        }
        return node;
	}
}



class ListNode{
	int data;
	ListNode next;
	public ListNode(int data){
		this.data= data;
	}
	public ListNode(int data,ListNode n){
		this.data = data;
		next = n;
	}
}