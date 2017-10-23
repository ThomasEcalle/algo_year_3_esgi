package fr.esgi.stacks;

import java.util.Objects;

/**
 * Created by Thomas Ecalle on 27/03/2017.
 */
public interface IStack<T>
{
    void push(T value);
    T pop();
    T peek();
    boolean isEmpty();
    int getSize();
    void printStack();
//    int min();
}
