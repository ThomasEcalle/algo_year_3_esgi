package arbres;

/**
 * Created by Thomas Ecalle on 04/07/2017.
 */
public class BSTree<T extends Comparable<T>> extends BinaryTree<T>
{


    public BSTree(BNode<T> root)
    {
        super(root);
        if (!isBST())
        {
            throw new NotBstException();
        }
    }

    @Override
    public BNode<T> findNode(T value)
    {
        return find(root, value);
    }

    private BNode<T> find(BNode<T> node, T value)
    {
        if (node == null) return null;
        if (node.value.equals(value)) return node;

        if (node.value.compareTo(value) == 1) return find(node.left, value);
        else return find(node.right, value);
    }

    public BNode<T> findLowestCommonAncestror(BNode<T> node, T left, T right)
    {
        if (node == null) return null;

        int comLeft = node.value.compareTo(left);
        int comRight = node.value.compareTo(right);

        if (comLeft == 0 || comRight == 0) return node;
        if (comLeft < 0 || comRight > 0)
        {
            return node;
        } else
        {
            //            return findLowestCommonAncestror(right, left, right);
        }
        return null; // not finished yet

    }


}
