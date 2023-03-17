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
        assertTrue(bt.contains(57));
    }

    @Test
    public void BT_sizeOfFive_five(){
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(57);
        bt.setRoot(new BinaryTreeNode<>(1));
        bt.getRoot().addRightChild(b2);
        bt.getRoot().getRightChild().addLeftChild(b3);
        bt.getRoot().getRightChild().addRightChild(b4);
        bt.getRoot().getRightChild().getRightChild().addRightChild(b5);
        assertEquals(5,bt.size());
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
    public void BT_getNullRoot_null(){
        assertNull(bt.getRoot());
    }

    @Test
    public void BT_setRootAndGetIt_rootValue(){
        bt.setRoot(new BinaryTreeNode<>(10));
        assertEquals(10,bt.getRoot().getElement());
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

    @Test
    public void BT_preOrderPrint_order(){
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> b6 = new BinaryTreeNode<>(19);
        BinaryTreeNode<Integer> b7 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> b8 = new BinaryTreeNode<>(100);
        bt.setRoot(new BinaryTreeNode<>(10));
        bt.getRoot().addLeftChild(b2);
        bt.getRoot().addRightChild(b3);
        b2.addLeftChild(b4);
        b2.addRightChild(b5);
        b3.addLeftChild(b6);
        b3.addRightChild(b7);
        b7.addRightChild(b8);
        assertEquals("[10, 5, 3, 11, 20, 19, 25, 100]",bt.preOrder().toString());
    }

    @Test
    public void BT_postOrderPrint_order(){
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> b6 = new BinaryTreeNode<>(19);
        BinaryTreeNode<Integer> b7 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> b8 = new BinaryTreeNode<>(100);
        bt.setRoot(new BinaryTreeNode<>(10));
        bt.getRoot().addLeftChild(b2);
        bt.getRoot().addRightChild(b3);
        b2.addLeftChild(b4);
        b2.addRightChild(b5);
        b3.addLeftChild(b6);
        b3.addRightChild(b7);
        b7.addRightChild(b8);
        assertEquals("[3, 11, 5, 19, 100, 25, 20, 10]", bt.postOrder().toString());
    }

    @Test
    public void BT_levelOrderPrint_order(){
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> b6 = new BinaryTreeNode<>(19);
        BinaryTreeNode<Integer> b7 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> b8 = new BinaryTreeNode<>(100);
        bt.setRoot(new BinaryTreeNode<>(10));
        bt.getRoot().addLeftChild(b2);
        bt.getRoot().addRightChild(b3);
        b2.addLeftChild(b4);
        b2.addRightChild(b5);
        b3.addLeftChild(b6);
        b3.addRightChild(b7);
        b7.addRightChild(b8);
        assertEquals("[10, 5, 20, 3, 11, 19, 25, 100]", bt.levelOrder().toString());
    }
}