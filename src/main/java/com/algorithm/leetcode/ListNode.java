package com.algorithm.leetcode;

public class ListNode{
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