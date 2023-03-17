package classes;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree() {
        super();
    }


    public boolean insert(E element){
        BinaryTreeNode<E> current = getRoot();
        BinaryTreeNode<E> parent = null;
        while(current != null){
            parent = current;
            if(current.getElement().compareTo(element) < 0){
                current = current.getRightChild();
            } else if (current.getElement().compareTo(element) > 0) {
                current = current.getLeftChild();
            }else {
                return false;
            }
        }
        BinaryTreeNode<E> newNodeToInsert = new BinaryTreeNode<>(element);
        if(parent == null){
            setRoot(newNodeToInsert);
        } else if (parent.getElement().compareTo(element) < 0) {
            parent.addRightChild(newNodeToInsert);
        }else{
            parent.addLeftChild(newNodeToInsert);
        }
        return true;
//        if(getRoot() == null){
//            setRoot(new BinaryTreeNode<>(element));
//            return true;
//        }
//        if (contains(element)){
//            return false;
//        }
//        if (element.compareTo(getRoot().getElement()) < 0){
//
//        }
//        if (element.compareTo(getRoot().getElement()) > 0){
//
//        }

    }

}
