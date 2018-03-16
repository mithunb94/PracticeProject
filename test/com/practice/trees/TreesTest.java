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
}
