package com.practice.trees;

import static org.junit.Assert.*;
import org.junit.Test;

public class NodeTest {

	@Test
	public void testCreateNode() {
		Node<Integer> node = new Node<Integer>(5);
		assertEquals("5", node.toString());
	}
}
