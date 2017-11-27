package com.example.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    public void addNode(int data) {

        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            Node parent;

            while (true) {
                parent = currentNode;

                if (data < currentNode.data) {

                    currentNode = currentNode.leftChild;

                    if (currentNode == null) {

                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.rightChild;

                    if (currentNode == null) {

                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    private Integer count(Node n) {

        if (n == null) {
            return 0;
        } else {
            return 1 + count(n.leftChild) + count((n.rightChild));
        }
    }

    public Integer size() {
        return count(root);
    }

    private Integer sumOfNodes(Node n) {

        if (root == null) {
            System.out.println("Tree is empty!");
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int totalSum = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            totalSum += node.data;
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
        return totalSum;
    }

    public Integer sumNode() {
        return sumOfNodes(root);
    }

    private Integer findMax(Node n) {

        if (n == null) {
            return -1;
        }
        int max = n.data;
        int leftMax = findMax(n.leftChild);
        int rightMax = findMax(n.rightChild);

        if (leftMax > rightMax) {
            max = leftMax;
        }
        if (rightMax > max) {
            max = rightMax;
        }
        return max;
    }

    public Integer max() {
        return findMax(root);
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.addNode(50);
        tree.addNode(25);
        tree.addNode(15);
        tree.addNode(30);
        tree.addNode(75);
        tree.addNode(85);

        System.out.println(tree.size());
        System.out.println(tree.sumNode());
        System.out.println(tree.max());
    }
}

class Node {
    int data;

    Node leftChild;
    Node rightChild;

    Node(int data) {

        this.data = data;
    }
}