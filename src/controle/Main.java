package controle;

import java.util.HashMap;

/**
 * Created by Thomas Ecalle on 23/05/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        int[] a = new int[]{1, 4, 3, 9, 1};
        System.out.println(diff(a,1));
//        System.out.println(validParanthese("))((()())"));
    }

    static int validParanthese(String string)
    {

        java.util.Stack<Character> opening = new java.util.Stack<>();

        for (int i = 0; i < string.length(); i++)
        {
            Character c = string.charAt(i);

            Character a = null;
            if (opening.isEmpty() == false)
            {
                a = opening.peek();
            }

            if (a != null && a == '(' && c == ')')
            {
                opening.pop();
            } else
            {
                opening.push(c);
            }


        }

        return string.length() - opening.size();
    }


    static boolean diff(int[] A, int k)
    {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < A.length; i++)
        {
            if (map.containsKey(A[i] + k) || map.containsKey(A[i] - k))
            {
                return true;
            }
            else
            {
                map.put(A[i], "o");
            }
        }
        return false;

    }
}
