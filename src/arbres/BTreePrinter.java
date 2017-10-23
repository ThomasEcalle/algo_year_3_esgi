package fr.esgi.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertmogos1 on 04/07/2017.
 */
public class BTreePrinter<T extends  Comparable<T>> {

    public void prettyPrint(BTree<T> tree) {
        List<BNode<T>> list = new ArrayList<>();
        list.add(tree.root);
        System.out.println();
        System.out.println();
        System.out.println(" -------------- ");
        print(list, tree.getHeight());
        System.out.println(" -------------- ");
        System.out.println();
        System.out.println();
    }

    private void print(List<BNode<T>> levelNodes, int level) {
        List<BNode<T>> nodes = new ArrayList<>();
        printIndentForLevel(level);

        for (BNode node: levelNodes) {
            System.out.print(node == null ? " " : node.value);
            printSpacingBetweenNodes(level);
            if(level>1){
                nodes.add(node == null ? null : node.left);
                nodes.add(node == null? null : node.right);
            }
        }
        System.out.println();
        if(level > 1){
            print(nodes, level-1);
        }
    }

    private void printIndentForLevel(int level){
        for (int i = (int) (Math.pow(2,level-1)); i >0; i--) {
            System.out.print(" ");
        }
    }

    private void printSpacingBetweenNodes(int level){
        for (int i = (int) ((Math.pow(2,level-1))*2)-1; i >0; i--) {
            System.out.print(" ");
        }
    }
}
