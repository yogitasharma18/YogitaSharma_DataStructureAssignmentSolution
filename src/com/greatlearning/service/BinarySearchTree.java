package com.greatlearning.service;

// Node class
class Node
{
	int val;
	Node left, right;
	Node(int item)
	{
		val = item;
		left = right = null;
	}
}

// BinarySearchTree class
class BinarySearchTree
{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
	
	static void binarySearchTreetoSkewed(Node root,int order)
	{
		if(root == null)
		{
			return;
		}
	
		if(order > 0)
		{
			binarySearchTreetoSkewed(root.right, order);
		}
		else
		{
			binarySearchTreetoSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
	
		// To check whether root node is null or not
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
	
		//Recursive call for left or right subtree
		if (order > 0)
		{
			binarySearchTreetoSkewed(leftNode, order);
		}
		else
		{
			binarySearchTreetoSkewed(rightNode, order);
		}
	}

	// Recursive call for traversing right skewed
	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);	
	}

	// Main method
	public static void main (String[] args)
	{
		// Binary tree creation
		BinarySearchTree tree = new BinarySearchTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);
	
		int order = 0;
		
		//Function call 
		binarySearchTreetoSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}
