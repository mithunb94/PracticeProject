package com.practice.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings({"rawtypes", "unchecked"})
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
	@Override
	public String postOrder() {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Node<T> curr = root;
		Stack<Node> stack = new Stack<>();
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

	/**
	 * Perform a level order traversal. Here queues are more suitable than stacks.
	 */
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
	
	/**
	 * Returns the number of elements from the given node including itself
	 */
	@Override
	public int size(Node curr) {
		if (curr == null) {
			return 0;
		}
		return 1 + size(curr.getLeft()) + size(curr.getRight());
	}

	/**
	 * Delete all nodes of tree recursively. Close to a postOrder traversal.
	 */
	@Override
	public void deleteRecursive(Node curr) {
		if (curr == null) {
			return;
		}
		deleteRecursive(curr.getLeft());
		deleteRecursive(curr.getRight());
		if (curr == root) {
			root = null;
		}
		curr = null;
	}

	/**
	 * Delete all nodes of tree non-recursively. Close to a postOrder traversal.
	 */
	@Override
	public void deleteNonRecursive() {
		if (root == null) {
			return;
		}
		Node curr = root;
		Stack<Node> stack = new Stack<>();
		while (true) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			curr = stack.peek();
			if (curr.getRight() == null) {
				stack.pop();
				if (!stack.isEmpty()) {
					if (stack.peek().getLeft() == curr) {
						stack.peek().setLeft(null);
					} else if (stack.peek().getRight() == curr) {
						stack.peek().setRight(null);
					}
				} else {
					root = null;
					break;
				}
				curr = stack.peek();
			}
			if (curr != null) {
				curr = curr.getRight();
			}
		}
	}
	
	/**
	 * Find a node in the tree with the given data and find out it's parent.
	 * @param data, value in the node
	 * @return
	 */
	public Node<T> getParent(T data) {
		Node<T> parent = null;
		if (root == null || (root != null && root.getData() == data)) {
			//Root does not have a parent.
			return null;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			if (curr.getLeft() != null) {
				if (curr.getLeft().getData() == data) {
					parent = curr;
					break;
				} else {
					q.add(curr.getLeft());
				}
			}
			if (curr.getRight() != null) {
				if (curr.getRight().getData() == data) {
					parent = curr;
					break;
				} else {
					q.add(curr.getRight());
				}
			}
		}
		return parent;
	}
	
	/**
	 * Find the given node in the tree and find out it's parent.
	 * @param node
	 * @return
	 */
	public Node<T> getParent(Node<T> node) {
		Node<T> parent = null;
		if (root == null || (root != null && root == node)) {
			//Root does not have a parent.
			return null;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			if (curr.getLeft() != null) {
				if (curr.getLeft() == node) {
					parent = curr;
					break;
				} else {
					q.add(curr.getLeft());
				}
			}
			if (curr.getRight() != null) {
				if (curr.getRight() == node) {
					parent = curr;
					break;
				} else {
					q.add(curr.getRight());
				}
			}
		}
		return parent;
	}
	
	/**
	 * Get the deepest node in the tree.
	 */
	@Override
	public Node<T> getDeepest() {
		Node<T> deepest = null;
		if (root == null) {
			return null;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			deepest = q.remove();
			if (deepest.getLeft() != null) {
				q.add(deepest.getLeft());
			}
			if (deepest.getRight() != null) {
				q.add(deepest.getRight());
			}
		}
		return deepest;
	}

	@Override
	public void delete(T data) {
		if (root == null) {
			return;
		}
		Node<T> deepest = getDeepest();
		Node<T> parentOfDeepest = getParent(deepest);
		Node<T> parent = null;
		Node<T> nodeToBeDeleted = null;
		boolean isLeftChild = false;
		boolean isRightChild = false;
		Queue<Node> q = new LinkedList<Node>();
		if (root.getData() == data) {
			if (parentOfDeepest.getLeft() == deepest) {
				parentOfDeepest.setLeft(null);
			} else if (parentOfDeepest.getRight() == deepest) {
				parentOfDeepest.setRight(null);
			}
			deepest.setLeft(root.getLeft());
			deepest.setRight(root.getRight());
			root = deepest;
			return;
		}
		q.add(root);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			if (curr.getLeft() != null) {
				if (curr.getLeft().getData() == data) {
					parent = curr;
					nodeToBeDeleted = curr.getLeft();
					isLeftChild = true;
					break;
				} else {
					q.add(curr.getLeft());
				}
				if (curr.getRight().getData() == data) {
					parent = curr;
					nodeToBeDeleted = curr.getRight();
					isRightChild = true;
					break;
				} else {
					q.add(curr.getRight());
				}
			}
		}
		if (parentOfDeepest.getLeft() == deepest) {
			parentOfDeepest.setLeft(null);
		} else if (parentOfDeepest.getRight() == deepest) {
			parentOfDeepest.setRight(null);
		}
		if (isLeftChild) {
			parent.setLeft(deepest);
			deepest.setLeft(nodeToBeDeleted.getLeft());
			deepest.setRight(nodeToBeDeleted.getRight());
		} else if (isRightChild) {
			parent.setRight(deepest);
			deepest.setLeft(nodeToBeDeleted.getLeft());
			deepest.setRight(nodeToBeDeleted.getRight());
		}
		return;
	}
}
