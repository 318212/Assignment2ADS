package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {
    BinaryTreeNode<Integer> btn1;

    @Test
    public void BTN_testIfNull_null(){
        btn1 = new BinaryTreeNode<>(null);
        assertNull(btn1.getElement());
    }
    @Test
    public void BTN_settingAnElement(){
        btn1 = new BinaryTreeNode<>(null);
        btn1.setElement(12);
        assertEquals(12, btn1.getElement());
    }

    @Test
    public void BTN_returnAddedChildren_Children(){
        btn1 = new BinaryTreeNode<>(23);
        BinaryTreeNode<Integer> leftChildToAdd = new BinaryTreeNode<>(12);
        BinaryTreeNode<Integer> rightChildToAdd = new BinaryTreeNode<>(34);
        btn1.addLeftChild(leftChildToAdd);
        btn1.addRightChild(rightChildToAdd);
        assertEquals(leftChildToAdd, btn1.getLeftChild());
        assertEquals(rightChildToAdd, btn1.getRightChild());
    }

}