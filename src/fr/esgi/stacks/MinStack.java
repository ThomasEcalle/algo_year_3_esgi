//package fr.esgi.stacks;
//
//import java.util.EmptyStackException;
//import java.util.Objects;
//
///**
// * Created by Thomas Ecalle on 27/03/2017.
// */
//public class MinStack<T> extends Stack
//{
//
//    private Stack minStack;
//
//    public MinStack()
//    {
//        super();
//        minStack = new Stack();
//    }
//
//    @Override
//    public void push(T value)
//    {
//        super.push(value);
//        if (minStack.isEmpty())
//        {
//            minStack.push(value);
//        } else
//        {
//            if (value <= minStack.peek())
//            {
//                minStack.push(value);
//            }
//        }
//    }
//
//    @Override
//    public T pop()
//    {
//        Object value = super.pop();
//        if(value == minStack.peek())
//        {
//            minStack.pop();
//        }
//        return (T) value;
//    }
//
//
//    @Override
//    public int min()
//    {
//        if (minStack != null && !minStack.isEmpty())
//        {
//            return minStack.peek();
//        }
//        throw new EmptyStackException();
//    }
//}
