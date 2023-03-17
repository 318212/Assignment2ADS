package classes;

public class BinaryTreeNode<E> {

    private E element;
    BinaryTreeNode<E> leftChild;
    BinaryTreeNode<E> rightChild;

    //BinaryTreeNode<E> right, BinaryTreeNode<E> left
    public BinaryTreeNode(E element) {
        this.element = element;
        rightChild = null;
        leftChild = null;
    }

    public E getElement(){
        return element;
    }

    public void setElement(E element){
        this.element = element;
    }

    public BinaryTreeNode<E> getLeftChild(){
        if(leftChild != null){
            return leftChild;
        }
        return null;
    }

    public BinaryTreeNode<E> getRightChild(){
        if(rightChild != null){
            return rightChild;
        }
        return null;
    }

    public void addLeftChild(BinaryTreeNode<E> left){
        this.leftChild = left;
    }

    public void addRightChild(BinaryTreeNode<E> right){
        this.rightChild = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "element=" + element +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
