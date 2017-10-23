package fr.esgi.trees;

/**
 * Created by robertmogos1 on 04/07/2017.
 */
public class BNode<T> {
    BNode<T> left;
    BNode<T> right;
    T value;

    public BNode(T val) {
        this.value = val;
    }
}
