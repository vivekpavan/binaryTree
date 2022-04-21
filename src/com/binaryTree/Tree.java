package com.binaryTree;

import java.util.ArrayList;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node=" + value;
        }
    }
    private Node root;
    public void insert(int value){
        var node = new Node(value);
        if(root == null){
            root = node;
            return;
        }
        var current = root;
        while(true){
            if(value < current.value) {
                if(current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }
    //my find method
    public boolean find(int value){
        if(root == null)
            throw new IllegalStateException();
        var current = root;
        while (true){
            if(current.value == value){
                return true;
            }
            else if(value < current.value){
                if(current.leftChild == null)
                    break;
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null)
                    break;
                current = current.rightChild;
            }
        }
        return false;
    }
     //mosh find method
    public boolean Find(int value){
        var current =root;
        while (current != null){
            if(current.value > value)
                current = current.leftChild;
            else if(current.value < value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
     }
     public void traversePreOrder(){
        traversePreOrder(root);
     }
     private void traversePreOrder(Node root){
        //base condition
        if(root == null)
            return;

         System.out.println(root.value);
         traversePreOrder(root.leftChild);
         traversePreOrder(root.rightChild);
     }
     public void traverseInOrder(){
        traverseInOrder(root);
     }
     private void traverseInOrder(Node root){
         if(root == null)
             return;
         traverseInOrder(root.leftChild);
         System.out.println(root.value);
         traverseInOrder(root.rightChild);
     }

     public void traversePostOrder(){
        traversePostOrder(root);
     }
     private void traversePostOrder(Node root){
        if(root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
         System.out.println(root.value);
     }
     public int height(){
        return height(root);
     }
     private int height(Node root){
        if(root == null){
            return -1;
        }
        if(isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
     }

     //binary search tree : O(log n)
     public int Min(){
        if(root == null){
            throw new IllegalStateException();
        }
        var current = root;
        var last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
     }

     public int min(){
        return min(root);
     }

     //binary tree O(n)
     private int min(Node root){
        if(isLeaf(root))
            return root.value;
        var left = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.min(Math.min(left,right),root.value);
     }

     public boolean equals(Tree other){
        if(other == null)
            return false;
        return equals(root,other.root);
     }

     private boolean equals(Node first,Node second){
        if(first == null && second == null)
            return true;
        if(first != null && second != null){
            return first.value == second.value
                    && equals(first.leftChild,second.leftChild)
                    && equals(first.rightChild,second.rightChild);
        }
        return false;
        }

    //unnecessary
    public void swapRoot(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }


    public boolean isBinarySearchTree(){
            return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        private boolean isBinarySearchTree(Node root,int min,int max){
        if(root == null)
            return true;
        return root.value > min && root.value < max
                &&  isBinarySearchTree(root.leftChild,min,root.value)
                &&  isBinarySearchTree(root.rightChild, root.value,max);
        }

        public ArrayList<Integer> getNodeAtDistance(int distance){
            ArrayList<Integer> list = new ArrayList<>();
            getNodeAtDistance(root,distance,list);
            return list;
        }
        private void getNodeAtDistance(Node root, int distance,ArrayList<Integer> list){
            if(root == null)
                return;

            if(distance == 0){
                list.add(root.value);
                return;
            }
            getNodeAtDistance(root.leftChild,distance -1,list);
            getNodeAtDistance(root.rightChild,distance-1,list);
        }

        public void traverseLevelOrder(){
        for(var i = 0;i<=height();i++){
            for(var value : getNodeAtDistance(i))
                System.out.println(value);
        }
        }

     private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
     }

}
