package com.example.admin.frameworkdemo.binarytree;

/**
 * @author yanjim
 * @Date 2021/5/17 18:25
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        Node g = new Node(null, null, "g");
        Node f = new Node(null, null, "f");
        Node d = new Node(null, null, "d");
        Node e = new Node(null, null, "e");
        Node c = new Node(f, g, "c");
        Node b = new Node(d, e, "b");
        Node root = new Node(b, c, "a");
        //System.out.println(root.getData());
        //prePrint(root);
        //inPrint(root);
        nextPrint(root);
    }

    // 前序遍历
    public static void prePrint(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        prePrint(root.getLeft());
        prePrint(root.getRight());
    }

    //中序遍历
    public static void inPrint(Node root) {
        if (root == null) {
            return;
        }
        inPrint(root.getLeft());
        System.out.println(root.getData());
        inPrint(root.getRight());
    }

    //后续遍历
    public static void nextPrint(Node root) {
        if (root == null) {
            return;
        }
        nextPrint(root.getLeft());
        nextPrint(root.getRight());
        System.out.println(root.getData());
    }
}
