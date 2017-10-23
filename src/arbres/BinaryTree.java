package arbres;

/**
 * Created by Thomas Ecalle on 04/07/2017.
 */
public class BinaryTree<T extends Comparable>
{
    BNode<T> root;

    public BinaryTree(BNode<T> root)
    {
        this.root = root;
    }

    public int getHeight()
    {
        return getHeight(root);
    }

    private int getHeight(BNode<T> node)
    {
        if (node == null) return 0;

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public boolean isComplete()
    {
        int height = getHeight();
        int nbNodes = getSize();

        return (Math.pow(2, height) - 1 == nbNodes);
    }

    private int getSize()
    {
        return getSize(root);
    }

    private int getSize(BNode<T> node)
    {
        if (node == null) return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }

    /**
     * Arbre binaire de recherche
     *
     * @return
     */
    public boolean isBST()
    {
        return isBST(root, null, null);
    }

    private boolean isBST(BNode<T> node, BNode<T> min, BNode<T> max)
    {
        if (node == null) return true;
        if (min != null && min.value.compareTo(node.value) == 1) return false;
        if (max != null && max.value.compareTo(node.value) == -1) return false;

        return isBST(node.left, min, node) && isBST(node.right, node, max);
    }

    public BNode<T> findNode(T value)
    {
        return null;
    }

}

