package classes;
//tests
public class main {

    public static void main(String[] args) {

        BinaryTree<Integer> bt = new BinaryTree<>();
        BinaryTree<Integer> emptyTree = new BinaryTree<>();

        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b3 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> b6 = new BinaryTreeNode<>(19);
        BinaryTreeNode<Integer> b7 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> bTest = new BinaryTreeNode<>(100);
        bt.setRoot(new BinaryTreeNode<>(10));
        bt.getRoot().addLeftChild(b2);
        bt.getRoot().addRightChild(b3);
        b2.addLeftChild(b4);
        b2.addRightChild(b5);
        b3.addLeftChild(b6);
        b3.addRightChild(b7);
        b7.addRightChild(bTest);

        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(bt.getRoot());
        System.out.println();
        System.out.println(bt.inOrder());
        System.out.println();
        System.out.println(bt.preOrder());
        System.out.println();
        System.out.println(bt.postOrder());
        System.out.println();
        System.out.println(bt.height());
    }
}