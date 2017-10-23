package fr.esgi.trees;

/**
 * Created by robertmogos1 on 04/07/2017.
 */
public class BSTree<T extends Comparable<T>> extends BTree<T> {

    public BSTree(BNode<T> root) {
        super(root);
        if (!isBST()) {
            throw new NotBSTException();
        }
    }

    @Override
    public BNode<T> findNode(T value) {
        return findNode(root, value);
    }

    private BNode<T> findNode(BNode<T> node, T value) {
        if (node == null) return null;
        if (node.value.equals(value)) return node;
        if (node.value.compareTo(value) == -1) {
            return findNode(node.right, value);
        } else {
            return findNode(node.left, value);
        }
    }

    public BNode<T> findLCA(T l, T r) {
        return findLCA(root, l, r);
    }

    private BNode<T> findLCA(BNode<T> node, T l, T r) {
        if (node == null) return null;

        int compLeft = node.value.compareTo(l);
        int compRight = node.value.compareTo(r);

        if (compLeft == 0 || compRight == 0) return node;
        if (compLeft < 0 || compRight > 0) {
            return node;
        }else if (compLeft < 0 || compRight < 0) {
            return findLCA(node.right, l, r);
        }
        return findLCA(node.left, l, r);

    }

    public static void main(String[] args) {
        BTreePrinter<Integer> printer = new BTreePrinter<>();

        BNode<Integer> root2 = new BNode<>(5);
        root2.left = new BNode<>(3);
        root2.right = new BNode<>(8);

        root2.left.left = new BNode<>(2);
        root2.left.right= new BNode<>(4);


        root2.right.left = new BNode<>(7);
        root2.right.right= new BNode<>(9);
        BSTree<Integer> tree2 = new BSTree<>(root2);

        printer.prettyPrint(tree2);
        System.out.println("Find 7: " + tree2.findNode(7));
        System.out.println("Find 10: " + tree2.findNode(10));
    }
}
