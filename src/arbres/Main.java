package arbres;

/**
 * Created by Thomas Ecalle on 04/07/2017.
 */
public class Main
{

    public static void main(String[] args)
    {
        final BNode<Integer> root = new BNode<>(5);
        root.left = new BNode<>(3);
        root.right = new BNode<>(8);

        root.left.left = new BNode<>(2);
        root.left.right = new BNode<>(4);
        //root.left.right.right = new BNode<>(8);

        root.right.left = new BNode<>(7);
        root.right.right = new BNode<>(9);

        final BSTree<Integer> binaryTree = new BSTree<>(root);

        System.out.println(binaryTree.getHeight());
        System.out.println("is complete ? " + binaryTree.isComplete());
        System.out.println("is BST ? " + binaryTree.isBST());

        System.out.println("*******************************");

        int value = 9;
        final BNode<Integer> node = binaryTree.findNode(value);
        if (node != null)
        {
            System.out.println("trouvé un noeud à " + value);
        } else
        {
            System.out.println("pas trouvé de noeud à " + value);
        }
    }
}
