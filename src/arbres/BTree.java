package fr.esgi.trees;

/**
 * Created by robertmogos1 on 04/07/2017.
 */
public class BTree<T extends  Comparable<T>> {
    public BNode<T> root;

    public BTree(BNode<T> root) {
        this.root = root;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BNode<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left),
                            getHeight(node.right));
    }

    public boolean isComplete() {
        int height = getHeight();
        int size = getSize();
        return (Math.pow(2, height) - 1 == size);
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(BNode<T> node) {
        if (node == null) return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }

    public boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(BNode<T> node, BNode<T> min, BNode<T> max) {
        if (node == null) return true;
        if (min != null && min.value.compareTo(node.value) == 1) {
            return false;
        }
        if (max != null && max.value.compareTo(node.value) == -1) {
            return false;
        }
        return isBST(node.left, min, node) && isBST(node.right, node, max);
    }

    public BNode<T> findNode(T value) {
        return null;
    }


    public static void main(String[] args) {
        BTreePrinter<Integer> printer = new BTreePrinter<>();

        BNode<Integer> root = new BNode<>(1);
        root.left = new BNode<>(2);
        root.right = new BNode<>(3);

        root.left.left = new BNode<>(4);
        root.left.right= new BNode<>(5);
        //root.left.right.right= new BNode<>(8);

        root.right.left = new BNode<>(6);
        root.right.right= new BNode<>(7);

        BTree<Integer> tree = new BTree<>(root);

        printer.prettyPrint(tree);
        System.out.println("Tree height: " + tree.getHeight());
        System.out.println("Is complete: " + tree.isComplete());
        System.out.println("Is BST: " + tree.isBST());

        BNode<Integer> root2 = new BNode<>(5);
        root2.left = new BNode<>(3);
        root2.right = new BNode<>(8);

        root2.left.left = new BNode<>(2);
        root2.left.right= new BNode<>(4);


        root2.right.left = new BNode<>(7);
        root2.right.right= new BNode<>(9);
        root2.right.right.right= new BNode<>(9);
        BTree<Integer> tree2 = new BTree<>(root2);

        printer.prettyPrint(tree2);
        System.out.println("Is BST: " + tree2.isBST());
    }
}
