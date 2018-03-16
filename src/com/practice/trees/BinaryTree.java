package com.practice.trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> implements Tree<T>{

	private Node<T> root;
	
	@Override
	public Node<T> getRoot() {
		return root;
	}
	
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
			curr = stack.peek();
			if (curr.getRight() == null) {
				sb.append(curr.getData());
				stack.pop();
			}
			if (!stack.isEmpty() && curr == stack.peek().getRight()) {
				curr = stack.pop();
				sb.append(curr.getData());
			}
			if (!stack.isEmpty()) {
				if (curr == stack.peek().getRight()) {
					sb.append(stack.pop().getData());
					curr = null;
				} else {
					curr = stack.peek().getRight();
				}
			} else {
				curr = null;
			}
		}
		return sb.toString();
	}
	
	/**
	 * Perform a postOrder traversal and print the elements respectively.
	 * This method uses two stacks instead of just one stack.
	 * @return
	 */
	public String postOrderUsingTwoStacks() {
		Node<T> curr = root;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		StringBuilder sb = new StringBuilder();
		while (true) {
			while (curr != null) {
				s1.push(curr);
				curr = curr.getLeft();
			}
			if (s1.isEmpty()) {
				while (!s2.isEmpty() ) {
					sb.append(s2.pop().getData());
				}
				return sb.toString();
			}
			curr = s1.pop();
			s2.push(curr);
			if (curr.getRight() == null) {
				sb.append(s2.pop());
				if (!s2.isEmpty() && curr == s2.peek().getRight()) {
					sb.append(s2.pop());
				}
				curr = null;
			} else {
				curr = curr.getRight();
			}
		}
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
	
	public boolean searchRecursive(Node curr, T data) {
		if (curr == null) {
			return false;
		}
		if (curr.getData() == data) {
			return true;
		}
		if (searchRecursive(curr.getLeft(), data)) {
			return true;
		}
		if (searchRecursive(curr.getRight(), data)) {
			return true;
		}
		return false;
	}
	
	public boolean searchNonRecursive(T data) {
		if (root == null) {
			return false;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			if (curr.getData() == data) {
				return true;
			}
			if (curr.getLeft() != null) {
				q.add(curr.getLeft());
			}
			if (curr.getRight() != null) {
				q.add(curr.getRight());
			}
		}
		return false;
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
