package fr.esgi.stacks;

/**
 * Created by Thomas Ecalle on 27/03/2017.
 */
public class Node<T>
{
    T value;
    Node next;
    Node min;

    public Node(T value)
    {
        this.value = value;
    }
}
