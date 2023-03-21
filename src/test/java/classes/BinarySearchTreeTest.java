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
    BinaryTreePrint print = new BinaryTreePrint();
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
    public void BST_removeFromEmptyTree_false(){
        assertFalse(bst.removeElement(10));
    }

    @Test
    public void BST_removeRootFromOneElementTree_true(){
        bst.insert(root.getElement());
        assertTrue(bst.removeElement(root.getElement()));
    }

    @Test
    public void BST_removeOneOfTheRootsChildren_true(){
        bst.insert(root.getElement());
        bst.insert(b2.getElement());
        bst.insert(b3.getElement());
        print.printTree(bst.getRoot());
        assertTrue(bst.removeElement(20));
        System.out.println();
        System.out.println("<<<<------------------------------------------------------------------------------------------------------------------------------------------>>>>");
        print.printTree(bst.getRoot());
    }

    //for root value 10, left child value 5 and right child value 20 -> upon deleting root right child became a root
    @Test
    public void BST_removeRootWhenItHasTwoChildren_true(){
        bst.insert(root.getElement());
        bst.insert(b2.getElement());
        bst.insert(b3.getElement());
        print.printTree(bst.getRoot());
        assertTrue(bst.removeElement(10));
        print.printTree(bst.getRoot());
    }

    //same as above
    @Test
    public void BST_removeNodeThatIsBothParentAndChild(){
        bst.insert(root.getElement());
        bst.insert(b2.getElement());
        bst.insert(b3.getElement());
        bst.insert(b4.getElement());
        bst.insert(b5.getElement());
        bst.insert(b6.getElement());
        bst.insert(b7.getElement());
        print.printTree(bst.getRoot());
        assertTrue(bst.removeElement(20));
        System.out.println();
        print.printTree(bst.getRoot());
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
        print.printTree(bst.getRoot());
        int maxValueFromTheTree = bst.findMax();
        assertEquals(25, maxValueFromTheTree);
    }

    @Test
    public void visualRepresentationOfRebalance_Null(){
        bst.insert(root.getElement());
        bst.insert(b2.getElement());
        bst.insert(b3.getElement());
        bst.insert(b4.getElement());
        bst.insert(b5.getElement());
        bst.insert(b6.getElement());
        bst.insert(b7.getElement());
        print.printTree(bst.getRoot());
        bst.rebalance();
        System.out.println();
        print.printTree(bst.getRoot());
    }

    @Test
    public void rebalanceOnNotBalanceableTree_Null(){
        bst.insert(root.getElement());
        bst.insert(b2.getElement());
        print.printTree(bst.getRoot());
        System.out.println();
        bst.rebalance();
        print.printTree(bst.getRoot());
    }
}