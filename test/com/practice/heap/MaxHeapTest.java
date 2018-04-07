package com.practice.heap;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxHeapTest {

	@Test
	public void testInsert() {
		Heap h = new MaxHeap();
		h.insert(13);
		h.insert(14);
		h.insert(16);
		h.insert(18);
		assertEquals("18, 16, 14, 13", h.toString());
	}

	@Test
	public void testRemove() {
		Heap h = new MaxHeap();
		h.insert(13);
		h.insert(14);
		h.insert(16);
		h.insert(18);
		assertEquals("18, 16, 14, 13", h.toString());
		h.remove();
		assertEquals("16, 13, 14", h.toString());
		h.remove();
		assertEquals("14, 13", h.toString());
		h.remove();
		assertEquals("13", h.toString());
	}
}
