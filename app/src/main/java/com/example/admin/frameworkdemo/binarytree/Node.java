package com.example.admin.frameworkdemo.binarytree;

/**
 * @author yanjim
 * @Date 2021/5/17 18:26
 */
public class Node {
    Node left;
    Node right;
    String data;

    public Node(Node left, Node right, String data) {
        this.left = left;
        this.right = right;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
