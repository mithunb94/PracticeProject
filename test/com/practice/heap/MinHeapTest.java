package com.practice.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {
	
	@Test
	public void testInsert() {
		Heap h = new MinHeap();
		h.insert(18);
		h.insert(14);
		h.insert(16);
		h.insert(13);
		assertEquals("13, 14, 16, 18", h.toString());
	}

	@Test
	public void testRemove() {
		Heap h = new MinHeap();
		h.insert(18);
		h.insert(14);
		h.insert(16);
		h.insert(13);
		assertEquals("13, 14, 16, 18", h.toString());
		h.remove();
		assertEquals("14, 18, 16", h.toString());
		h.remove();
		assertEquals("16, 18", h.toString());
		h.remove();
		assertEquals("18", h.toString());
	}

}
