package com.practice.heap;

import java.util.ArrayList;

public class MaxHeap extends Heap{

	public MaxHeap() {
		list = new ArrayList<>();
	}
	
	@Override
	public void insert(int data) {
		list.add(data);
		siftUp(size()-1);
	}

	@Override
	public void remove() {
		if (size() == 0) {
			throw new RuntimeException("MaxHeap is Empty");
		}
		if (size() == 1) {
			list.remove(0);
		} else {
			list.set(0, list.remove(size() -1));
			siftDown(0);
		}
		
	}

	@Override
	public void siftUp(int pos) {
		int parentPos = (pos-1)/2;
		if (parentPos < 0) {
			return;
		}
		if (list.get(parentPos) < list.get(pos)) {
			swap(parentPos, pos);
			siftUp(parentPos);
		}
	}

	@Override
	public void siftDown(int pos) {
		int leftChildPos = 2*pos + 1;
		int rightChildPos = 2*pos + 2;
		if (leftChildPos < size() && rightChildPos < size()) {
			if (list.get(leftChildPos) > list.get(pos) &&
					list.get(leftChildPos) >= list.get(rightChildPos)) {
				swap(leftChildPos, pos);
				siftDown(leftChildPos);
			} else if (list.get(rightChildPos) > list.get(pos) &&
					list.get(rightChildPos) >= list.get(leftChildPos)) {
				swap(rightChildPos, pos);
				siftDown(rightChildPos);
			} else {
				return;
			}
		} else if (leftChildPos < size()) {
			if (list.get(leftChildPos) > list.get(pos)) {
				swap(leftChildPos, pos);
				siftDown(leftChildPos);
			}
		} else {
			return;
		}
		
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public String toString() {
		return list.toString().replaceAll("[\\[\\]]", "");
	}
}
