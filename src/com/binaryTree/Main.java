package com.binaryTree;

public class Main {

    public static void main(String[] args) {
        var tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        tree.insert(8);

        var tree1 =  new  Tree();
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(9);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(10);
        tree1.insert(9);

        tree.traverseLevelOrder();

//        var list = tree.getNodeAtDistance(2);
//        for(var item : list)
//            System.out.println(item);

//        tree.swapRoot();
//        System.out.println(tree.isBinarySearchTree());

//        System.out.println(tree.equals(tree1));

//        System.out.println(tree.min());
//        System.out.println(tree.Min());

//        System.out.println(tree.height());

        //tree.traversePreOrder();



//        System.out.println("done");
//         System.out.println(tree.find(2));
//         System.out.println(tree.Find(6));
    }
}
