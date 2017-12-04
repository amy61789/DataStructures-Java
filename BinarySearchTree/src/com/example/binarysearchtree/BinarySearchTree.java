package com.example.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    class Node {
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = null;
            right = null;
        }
    }
    Node root;

    BinarySearchTree(){
        root = null;
    }

    void insert(int data){
        root = insertRecursive(root, data);
    }

    Node insertRecursive(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data < root.data){
            root.left = insertRecursive(root.left, data);
        }else if(data > root.data){
            root.right = insertRecursive(root.right, data);
        }
        return root;
    }

    int depthOfTree(Node node, int data, int depth){
        if(node == null){return 0;}
        if(node.data == data){return depth;}
        int downDepth = depthOfTree(node.left, data, depth + 1);
        if(downDepth != 0){return downDepth;}

        downDepth = depthOfTree(node.right, data, depth + 1);
        return downDepth;
    }

    int getDepth (Node node, int data){
        return depthOfTree(node, data, 1);
    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(18);
        tree.insert(14);
        tree.insert(20);
        tree.insert(22);
        tree.insert(36);
        tree.insert(57);
        tree.insert(61);
        tree.insert(21);
        tree.insert(79);
        tree.insert(60);
        tree.insert(81);
        tree.insert(95);
        tree.insert(90);

        List<Integer> searchData = new ArrayList<>();
        searchData.add(14);
        searchData.add(95);
        searchData.add(90);
        searchData.add(35);
        searchData.add(17);
        searchData.add(63);

        for(int i = 0; i < searchData.size(); i++){
            int depth = tree.getDepth(tree.root, searchData.get(i));
            if (depth != 0){
                System.out.println("Depth of " + searchData.get(i) + " is " + tree.getDepth(tree.root, searchData.get(i)));
            }else{
                System.out.println(searchData.get(i) + " is not in the tree!");
            }
        }

    }
}
