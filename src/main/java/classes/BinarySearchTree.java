package classes;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree() {
        super();
    }


    public boolean insert(E element) {
        BinaryTreeNode<E> current = getRoot();
        BinaryTreeNode<E> parent = null;
        while (current != null) {
            parent = current;
            if (current.getElement().compareTo(element) < 0) {
                current = current.getRightChild();
            } else if (current.getElement().compareTo(element) > 0) {
                current = current.getLeftChild();
            } else {
                return false;
            }
        }
        BinaryTreeNode<E> newNodeToInsert = new BinaryTreeNode<>(element);
        if (parent == null) {
            setRoot(newNodeToInsert);
        } else if (parent.getElement().compareTo(element) < 0) {
            parent.addRightChild(newNodeToInsert);
        } else {
            parent.addLeftChild(newNodeToInsert);
        }
        return true;

    }

    public boolean removeElement(E element) {
        if (getRoot() == null) {
            return false;
        }

        BinaryTreeNode<E> tempNode = getRoot();
        BinaryTreeNode<E> parent = null;
        boolean isLeft = false;

        while (tempNode != null) {

            // travel left
            if (element.compareTo(tempNode.getElement()) < 0) {
                parent = tempNode;
                tempNode = tempNode.getLeftChild();
                isLeft = true;
            }

            // travel right
            else if (element.compareTo(tempNode.getElement()) > 0) {
                parent = tempNode;
                tempNode = tempNode.getRightChild();
                isLeft = false;
            }

            // element found
            else {

                // node has 2 children
                if (tempNode.getLeftChild() != null && tempNode.getRightChild() != null) {
                    tempNode = tempNode.getRightChild();
                    while (tempNode.getLeftChild() != null)
                        tempNode = tempNode.getLeftChild();

                    if (parent == null) {
                        tempNode.addLeftChild(getRoot().getLeftChild());
                        setRoot(tempNode);
                    } else if (isLeft) {
                        tempNode.addLeftChild(parent.getLeftChild().getLeftChild());
                        parent.addLeftChild(tempNode);
                    } else {
                        tempNode.addLeftChild(parent.getRightChild().getLeftChild());
                        parent.addRightChild(tempNode);
                    }
                }

                // node has 1 child
                else if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                    if (parent == null)
                        setRoot(tempNode.getLeftChild() != null ? tempNode.getLeftChild() : tempNode.getRightChild());
                    else if (isLeft)
                        parent.addLeftChild(tempNode.getLeftChild() != null ? tempNode.getLeftChild() : tempNode.getRightChild());
                    else
                        parent.addRightChild(tempNode.getLeftChild() != null ? tempNode.getLeftChild() : tempNode.getRightChild());
                }

                // node has not child
                else {
                    if (parent == null)
                        setRoot(null);
                    else if (isLeft)
                        parent.addLeftChild(null);
                    else
                        parent.addRightChild(null);
                }

                return true;
            }
        }

        return false;
    }
    public E findMin() {
        if (getRoot() == null) {
            return null;
        }

        BinaryTreeNode<E> node = getRoot();
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }

        return node.getElement();
    }

    public E findMax(){
        if (getRoot()==null){
            return null;
        }
        BinaryTreeNode<E> node = getRoot();
        while (node.getRightChild()!= null){
            node= node.getRightChild();
        }
        return node.getElement();
    }
    
 public boolean contains(E element) {
      return super.contains(element);
    }

    public void rebalance() {
        if (getRoot()==null||size()<2){
            return;
        }
        ArrayList<E> elements = inOrder();
        setRoot(new BinaryTreeNode<E>(elements.get(elements.size() / 2)));

        addSubtree(elements, 0, elements.size() / 2 - 1, getRoot());
        addSubtree(elements, elements.size() / 2 + 1, elements.size() - 1, getRoot());
    }

    private void addSubtree(ArrayList<E> elements, int start, int end, BinaryTreeNode<E> parent) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        BinaryTreeNode<E> child = new BinaryTreeNode<E>(elements.get(mid));
        if (child.getElement().compareTo(parent.getElement()) < 0) {
            parent.addLeftChild(child);
        } else {
            parent.addRightChild(child);
        }
        addSubtree(elements, start, mid - 1, child);
        addSubtree(elements, mid + 1, end, child);
    }
}
