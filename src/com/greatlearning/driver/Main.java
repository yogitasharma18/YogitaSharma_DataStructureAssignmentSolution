package com.greatlearning.driver;

import java.util.Scanner;
import java.util.Stack;

import com.greatlearning.service.ConstructionProcess;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		System.out.println("Enter the total no of floors in the building");
		int floorCount = sc.nextInt();
		for(int i=0; i< floorCount; i++) {
			System.out.println("Enter the floor size given on day : "+(i+1));
			int floorSize = sc.nextInt();
			s.push(floorSize);
		}
		
		ConstructionProcess constructionProcess = new ConstructionProcess();
		constructionProcess.getOutput(floorCount,s);
	}

}
