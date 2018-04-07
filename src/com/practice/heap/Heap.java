package com.practice.heap;

import java.util.List;

public abstract class Heap {

	List<Integer> list;
	
	public void swap(int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j,  temp);
	}
	
	protected int size() {
		return list.size();
	}
	
	protected boolean isEmpty() {
		return list.isEmpty();
	}
	
	public abstract void insert(int data);
	
	public abstract void remove();
	
	public abstract void siftUp(int pos);
	
	public abstract void siftDown(int pos);
	
	public abstract void clear();
}
