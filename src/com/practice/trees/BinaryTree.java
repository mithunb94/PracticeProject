package com.practice.trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> implements Tree<T>{

	Node<T> root;
	
	@Override
	public void add(T data) {
		Node<T> node = new Node<>(data);
		if (root == null) {
			root = node;
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node<T> curr = q.remove();
			if (curr.getLeft() == null) {
				curr.setLeft(node);
				break;
			} else {
				q.add(curr.getLeft());
			}
			if (curr.getRight() == null) {
				curr.setRight(node);
				break;
			} else {
				q.add(curr.getRight());
			}
		}
	}

	/**
	 * Perform a preOrder traversal and print the elements respectively. Done
	 * using a non-recursive approach. The recursive approach is pretty
	 * straight-forward.
	 * 
	 * @param root
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String preOrder() {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Node<T> curr = root;
		Stack<Node> stack = new Stack<>();
		while (true) {
			while (curr != null) {
				sb.append(curr.getData());
				stack.push(curr);
				curr = curr.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			curr = stack.pop();
			curr = curr.getRight();
		}
		return sb.toString();
	}

	/**
	 * Perform a postOrder traversal and print the elements respectively. Done
	 * using a non-recursive approach. The recursive approach is pretty
	 * straight-forward.
	 * 
	 * @param root
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String postOrder() {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Node<T> curr = root;
		Stack<Node> stack = new Stack<>();
		// TODO: Write working code. Currently going into an infinite loop.
		while(true) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			if (stack.peek().getRight() == null) {
				curr = stack.pop();
				sb.append(curr.getData());
			}
			if (curr == stack.peek().getRight()) {
				sb.append(stack.pop());
			}
			if (!stack.isEmpty()) {
				curr = stack.peek().getRight();
			} else {
				curr = null;
			}
		}
		return sb.toString();
	}

	/**
	 * Perform a inOrder traversal and print the elements respectively. Done
	 * using a non-recursive approach. The recursive approach is pretty
	 * straight-forward.
	 * 
	 * @param root
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String inOrder() {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Node<T> curr = root;
		Stack<Node> stack = new Stack<>();
		while (true) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			curr = stack.pop();
			sb.append(curr.getData());
			curr = curr.getRight();
		}
		return sb.toString();
	}

	@Override
	public String levelOrder() {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node<T> curr = q.remove();
			sb.append(curr.getData());
			if (curr.getLeft() != null) {
				q.add(curr.getLeft());
			}
			if (curr.getRight() != null) {
				q.add(curr.getRight());
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Tree<String> bTree = new BinaryTree<>();
		bTree.add("A");
		bTree.add("B");
		bTree.add("C");
		bTree.add("D");
		bTree.add("E");
		bTree.add("F");
		bTree.add("G");
		System.out.println(bTree.postOrder());
	}
}
