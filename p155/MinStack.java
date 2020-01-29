/*
 * 155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.*/package p155;

import java.util.Stack;

public class MinStack {

	Stack<Integer> s = new Stack<>();
	Stack<Integer> mins = new Stack<>();

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {
		s.add(x);
		if (!mins.empty()) {
			int k = mins.peek();
			mins.push(x > k ? k : x);
		} else
			mins.push(x);
		System.out.println(mins);
	}

	public void pop() {
		s.pop();
		mins.pop();

	}

	public int top() {
		return s.peek();
	}

	public int getMin() {

		return mins.peek();

	}
}
