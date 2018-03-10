package com.practice.trees;

public class Node<T> {
    
    private T data;
    private Node<T> left;
    private Node<T> right;
    
    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public T getData() {
        return data;
    }
    
    public Node<T> getLeft() {
        return left;
    }
    
    public Node<T> getRight() {
        return right;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    
    public void setRight(Node<T> right) {
        this.right = right;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
    
    public static void main(String[] args) {
        Node<Integer> newNode = new Node<Integer>(5);
        System.out.println(newNode);
    }
}
