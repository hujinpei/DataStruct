package com.hu.struct.tree;

public class Node {

    private Node parent;

    private Node left;

    private Node right;

    int value;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(Node parent, Node left, Node right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node(Node parent, Node left, Node right, int value) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node() {
    }
}
