package fr.esgi.stacks;

import java.util.EmptyStackException;
import java.util.Objects;

/**
 * Created by Thomas Ecalle on 27/03/2017.
 */
public class Stack<T> implements IStack
{
    protected Node<T> top;
    protected int size;

    public Stack()
    {
        this.size = 0;
    }

    @Override
    public void push(Object value)
    {
        final Node<T> n = new Node<T>((T)value);
        n.next = top;
        top = n;
        this.size++;
    }

    @Override
    public T pop()
    {
        if (top == null)
        {
            throw new EmptyStackException();
        }
        final Node<T> oldTop = top;

        top = oldTop.next;
        this.size--;
        return oldTop.value;
    }

    @Override
    public T peek()
    {
        if (top == null)
        {
            throw new EmptyStackException();
        }
        return top.value;
    }

    @Override
    public boolean isEmpty()
    {
        if (size == 0) return true;
        return false;
    }

    @Override
    public int getSize()
    {
        return this.size;
    }

    @Override
    public void printStack()
    {
        Node tmp = top;
        while (tmp != null)
        {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

//    @Override
//    public int min()
//    {
//        if (top != null)
//        {
//            if (top.min != null) return top.min.value;
//            else return top.value;
//        }
//        return 0;
//    }

}
