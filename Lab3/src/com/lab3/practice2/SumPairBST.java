package com.lab3.practice2;

import java.util.HashSet;
import java.util.Scanner;

public class SumPairBST {
	public static class Node{
		int data;
		Node left;
		Node right;
	};
	
		public Node NewNode(int data) {
			Node temp=new Node();
			temp.data=data;
			temp.left=null;
			temp.right=null;
			return temp;	
	}
		
	public Node insert(Node root,int data) {
		
		if (root==null) 
			return NewNode(data);
		if(data<root.data)
			root.left=insert(root.left,data);
		else 
			root.right=insert(root.right,data);
		return root;
			
	}
	public boolean findPair(Node root, int sum,HashSet<Integer> set){
		if (root == null)
			return false;

		if (findPair(root.left, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is (" + (sum - root.data) + ", "+ root.data + ")");
			return true;
		}
		else
			set.add(root.data);

		return findPair(root.right, sum, set);
	}

	public void findGivenSum(Node root, int sum)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPair(root, sum, set))
			System.out.print("Nodes not found" + "\n");
	}
	public static void main(String[] args)
	{
		Node root = null;
		
		SumPairBST tree = new SumPairBST();
		root = tree.insert(root, 40);
		root = tree.insert(root, 20);
		root = tree.insert(root, 60);
		root = tree.insert(root, 10);
		root = tree.insert(root, 30);
		root = tree.insert(root, 50);
		root = tree.insert(root, 70);
		
    	Scanner in=new Scanner(System.in);
		System.out.println("Enter sum:");
		int sum =in.nextInt();
		tree.findGivenSum(root, sum);
		in.close();
	}
	}
