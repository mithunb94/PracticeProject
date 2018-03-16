package com.practice.trees;

public interface Tree<T> {
	
	public abstract Node<T> getRoot();

	public abstract void add(T data);
	
	public abstract String preOrder();
	
	public abstract String postOrder();
	
	public abstract String inOrder();
	
	public abstract String levelOrder();
}
