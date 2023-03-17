package classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E extends Comparable<E>>{

    private BinaryTreeNode<E> root;
    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public BinaryTreeNode<E> getRoot(){
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root){
        this.root = root;
        size++;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int size(){
        if(isEmpty()){
            return 0;
        }
        return inOrder().size();
    }

    public boolean contains(E element){
        if(root == null) return false;
        return inOrder().contains(element);
    }

    public ArrayList<E> inOrder(){
        ArrayList<E> list = new ArrayList<>();
        BinaryTreeNode<E> current = root;
        Stack<BinaryTreeNode<E>> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.getLeftChild();
            }
            current = stack.pop();
            list.add(current.getElement());
            current = current.getRightChild();
        }
        if(list.isEmpty()){
            return null;
        }
        return list;
    }

    public ArrayList<E> preOrder(){
        ArrayList<E> list = new ArrayList<>();
        Stack<BinaryTreeNode<E>> stack = new Stack<>();
        BinaryTreeNode<E> current = root;
        if(current != null){
            stack.push(current);
        }
        while(!stack.isEmpty()){
            BinaryTreeNode<E> current1 = stack.pop();
            list.add(current1.getElement());
            if(current1.getRightChild() != null){
                stack.push(current1.getRightChild());
            }
            if(current1.getLeftChild() != null){
                stack.push(current1.getLeftChild());
            }
        }
        if(list.isEmpty()){
            return null;
        }
        return list;
    }

    public ArrayList<E> postOrder() {
        ArrayList<E> list = new ArrayList<>();
        Stack<BinaryTreeNode<E>> stack = new Stack<>();
        BinaryTreeNode<E> previousNode = null;
        BinaryTreeNode<E> current = getRoot();
        while (!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.getLeftChild();
            }else{
                BinaryTreeNode<E> peekNode = stack.peek();
                if(peekNode.getRightChild() != null && previousNode != peekNode.getRightChild()){
                    current = peekNode.getRightChild();
                }else{
                    list.add(peekNode.getElement());
                    previousNode = stack.pop();
                }
            }
        }
        if(list.isEmpty()){
            return null;
        }
        return list;

    }

    public ArrayList<E> levelOrder(){
        ArrayList<E> list = new ArrayList<>();
        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        queue.add(getRoot());
        while (!queue.isEmpty()){
            BinaryTreeNode<E> current = queue.poll();
            list.add(current.getElement());

            if(current.getLeftChild() != null){
                queue.add(current.getLeftChild());
            }
            if(current.getRightChild() != null){
                queue.add(current.getRightChild());
            }
        }
        if(list.isEmpty()){
            return null;
        }
        return list;
    }

    public int height(){
        int heigth=0;
        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            BinaryTreeNode<E> peekNode = queue.peek();
            queue.remove();

            if(peekNode == null){
                heigth++;
            }

            if(peekNode != null){
                if(peekNode.leftChild != null){
                    queue.add(peekNode.getLeftChild());
                }
                if(peekNode.rightChild != null){
                    queue.add(peekNode.getRightChild());
                }
            }
            else if(!queue.isEmpty()){
                queue.add(null);
            }
        }
        return heigth;
    }
}
