package arbres;

/**
 * Created by Thomas Ecalle on 04/07/2017.
 */
public class BNode<T>
{
    T value;
    BNode<T> left;
    BNode<T> right;

    public BNode(T value)
    {
        this.value = value;
    }
}
