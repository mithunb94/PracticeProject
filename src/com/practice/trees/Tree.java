package com.practice.trees;

public interface Tree<T> {
	
	public abstract Node<T> getRoot();

	public abstract void add(T data);
	
	public abstract String preOrder();
	
	public abstract String postOrder();
	
	public abstract String inOrder();
	
	public abstract String levelOrder();
	
	public abstract int size(Node curr);
	
	public abstract void deleteRecursive(Node curr);
	
	public abstract void deleteNonRecursive();
	
	public abstract Node<T> getDeepest();
	
	public abstract void delete(T data);
}
