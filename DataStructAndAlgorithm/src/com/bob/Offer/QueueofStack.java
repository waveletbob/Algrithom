package com.bob.Offer;

import java.util.Stack;

public class QueueofStack {
	Stack<Integer>stack1=new Stack<>();
	Stack<Integer>stack2=new Stack<>();
	public void push(int node){
		stack1.push(node);
		
	}
	public int pop(){
		
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			int node=stack2.pop();
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
		
		return node;
		
	}
}
