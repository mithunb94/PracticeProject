package com.practice.trees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TreesTest {

	public Tree<String> bTree;
	
	@Before
	public void setUpBeforeClass(){
		bTree = new BinaryTree<>();
		bTree.add("A");
		bTree.add("B");
		bTree.add("C");
		bTree.add("D");
		bTree.add("E");
		bTree.add("F");
		bTree.add("G");
	}

	@Test
	public void testPreOrder() {
		assertEquals("ABDECFG", bTree.preOrder());
	}

	@Test
	public void testInOrder() {
		assertEquals("DBEAFCG", bTree.inOrder());
	}
	
	@Test
	public void testPostOrder() {
		assertEquals("DEBFGCA", bTree.postOrder());
	}
	
	@Test
	public void testPostOrderUsingTwoStacks() {
		assertEquals("DEBFGCA", ((BinaryTree<String>) bTree).postOrderUsingTwoStacks());
	}
	
	@Test
	public void testLevelOrder() {
		assertEquals("ABCDEFG", bTree.levelOrder());
	}
	
	@Test
	public void testSearchRecursive() {
		assertTrue(((BinaryTree<String>) bTree).searchRecursive(bTree.getRoot(), "F"));
		assertTrue(!((BinaryTree<String>) bTree).searchRecursive(bTree.getRoot(), "X"));
	}
	
	@Test
	public void testSearchNonRecursive() {
		assertTrue(((BinaryTree<String>) bTree).searchNonRecursive("F"));
		assertTrue(!((BinaryTree<String>) bTree).searchNonRecursive("X"));
	}
	
	@Test
	public void testSize() {
		assertEquals(7, bTree.size(bTree.getRoot()));
	}
	
	@Test
	public void testGetDeepest() {
		assertEquals("G", bTree.getDeepest().getData());
	}
	
	@Test
	public void testGetParentUsingData() {
		assertEquals("A", ((BinaryTree<String>)bTree).getParent("B").getData());
	}
	
	@Test
	public void testDeleteRecursive() {
		bTree.deleteRecursive(bTree.getRoot());
		assertNull(bTree.getRoot());
	}
	
	@Test
	public void testDeleteNonRecursive() {
		bTree.deleteNonRecursive();
		assertNull(bTree.getRoot());
	}
	
	
}
