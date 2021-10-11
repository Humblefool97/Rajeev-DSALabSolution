package com.greatlearning.labsession;

import java.util.ArrayList;
import java.util.Collections;

public class LongestPath {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(50);
        root.left.left.left = new Node(5);

        root.right = new Node(130);
        root.right.left = new Node(110);
        root.right.right = new Node(140);


        ArrayList<Integer> result = longestPath(root);
        int n = result.size();

        Collections.reverse(result);
        for (Integer data : result) {
            System.out.print(data + "->");
        }
        System.out.println();
    }

    private static ArrayList<Integer> longestPath(Node root) {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> left = longestPath(root.left);
        ArrayList<Integer> right = longestPath(root.right);

        if (left.size() > right.size()) {
            left.add(root.data);
            return left;
        } else {
            right.add(root.data);
            return right;
        }
    }
}
