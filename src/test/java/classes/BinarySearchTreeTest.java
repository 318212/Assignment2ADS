package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree<Integer> bst = new BinarySearchTree<>();


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

}