package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
    BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(20);
    BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(11);
    BinaryTreeNode<Integer> b6 = new BinaryTreeNode<>(19);
    BinaryTreeNode<Integer> b7 = new BinaryTreeNode<>(25);

    @Test
    public void BST_insertIntoEmptyTree_true(){
        BinaryTreeNode<Integer> nodeToInsert = new BinaryTreeNode<>(10);
        assertTrue(bst.insert(nodeToInsert.getElement()));
    }

    @Test
    public void BST_inserTwoChildrenForRoot_true(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(20);
        assertTrue(bst.insert(root.getElement()));
        assertTrue(bst.insert(leftChild.getElement()));
        assertTrue(bst.insert(rightChild.getElement()));
    }

    @Test
    public void BST_findMinValue_MinValue(){
        bst.insert(root.getElement());
        bst.insert(b2.getElement());
        bst.insert(b3.getElement());
        bst.insert(b4.getElement());
        bst.insert(b5.getElement());
        bst.insert(b6.getElement());
        bst.insert(b7.getElement());
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(bst.getRoot());
        int minValueFromTheTree = bst.findMin();
        assertEquals(3,minValueFromTheTree);
    }

    @Test
    public void BST_findMaxValue_MaxValue(){
        bst.insert(root.getElement());
        bst.insert(b2.getElement());
        bst.insert(b3.getElement());
        bst.insert(b4.getElement());
        bst.insert(b5.getElement());
        bst.insert(b6.getElement());
        bst.insert(b7.getElement());
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(bst.getRoot());
        int maxValueFromTheTree = bst.findMax();
        assertEquals(25, maxValueFromTheTree);
    }
}