package com.greatlearning.service;

import java.util.ListIterator;
import java.util.Stack;

public class ConstructionProcess {
	public void getOutput(int floorCount, Stack s) {
		Stack tempStack = new Stack();
		Stack tempSortedStack = new Stack();
		int count =0 ;
		int check, sortedCheck;
		System.out.println("The order of construction is as follows:");
		for(int i =0; i<s.size(); i++) {
			check = (int) s.get(i);
			tempStack.push(check);
			tempSortedStack = sortStack(s);
			sortedCheck = (int) tempSortedStack.get(i);
			if((int)check < s.size())
			{
				if(check < sortedCheck) {
					System.out.println("Day :" +(i+1));
					System.out.println(tempSortedStack);
				}
				else {
					System.out.println("Day :" +(i+1));
					System.out.println("");
				}
			}	
			else if(check == s.size()) {
				if(check == sortedCheck) {
					tempSortedStack.pop();
					System.out.println("Day :" +(i+1));
					System.out.println(tempSortedStack);
				}
				else {
					System.out.println("Day :" +(i+1));
					System.out.println(check);
					
				}
			}
			
		}
	}
	static void sortedInsert(Stack<Integer> s, int x)
	{
		if (s.isEmpty() || x > s.peek())
		{
			s.push(x);
			return;
		}
		int temp = s.pop();
		sortedInsert(s, x);
		s.push(temp);
	}

	// Method to sort stack
	public static Stack sortStack(Stack<Integer> s)
	{
		// If stack is not empty
		if (!s.isEmpty())
		{
			int x = s.pop();
			sortStack(s);
			sortedInsert(s, x);
		}
		return s;
	}
}
