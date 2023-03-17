package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree<Integer> bt = new BinaryTree<>();

    @Test
    public void BT_contains_true(){
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(57);
        bt.setRoot(new BinaryTreeNode<>(1));
        bt.getRoot().addRightChild(b2);
        bt.getRoot().getRightChild().addLeftChild(b3);
        bt.getRoot().getRightChild().addRightChild(b4);
        bt.getRoot().getRightChild().getRightChild().addRightChild(b5);
        assertTrue(bt.contains(20));
    }

    @Test
    public void BT_contains_false(){
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(57);
        bt.setRoot(new BinaryTreeNode<>(1));
        bt.getRoot().addRightChild(b2);
        bt.getRoot().getRightChild().addLeftChild(b3);
        bt.getRoot().getRightChild().addRightChild(b4);
        bt.getRoot().getRightChild().getRightChild().addRightChild(b5);
        assertFalse(bt.contains(668));
    }

    @Test
    public void BT_newlyInitializedTreeIsEmpty_true(){
        assertTrue(bt.isEmpty());
    }

    @Test
    public void BT_inOrderEmptyPrintReturnsNull_null(){
        assertNull(bt.inOrder());
    }

    @Test
    public void BT_inOrderPrint_order(){
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> b6 = new BinaryTreeNode<>(19);
        BinaryTreeNode<Integer> b7 = new BinaryTreeNode<>(25);
        bt.setRoot(new BinaryTreeNode<>(10));
        bt.getRoot().addLeftChild(b2);
        bt.getRoot().addRightChild(b3);
        b2.addLeftChild(b4);
        b2.addRightChild(b5);
        b3.addLeftChild(b6);
        b3.addRightChild(b7);
        assertEquals("[3, 5, 11, 10, 19, 20, 25]", bt.inOrder().toString());
    }
}