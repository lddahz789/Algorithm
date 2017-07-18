package com.algorithm.diy;

public class Node<T> {
	private T data;
	private Node next;
	
	public Node(T data){
		this.data = data;
		next = null;
	}
	
	public T getData(){
		return data;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void insert(Node node){
		Node newNode = new Node(1);
		newNode.next = node.next;
		node.next = newNode;
	}
	
	public void delete(Node node){
		node.next = node.next.next;
		node.next = null;
	}
	
	public void reversePrint(Node node){
		if (node !=null){
			reversePrint(node.next);
			System.out.println(node.data);
			
		}
		
			
	}

}
