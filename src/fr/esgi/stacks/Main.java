package fr.esgi.stacks;

/**
 * Created by Thomas Ecalle on 27/03/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        //        final Stack stack = new Stack();
        //        stack.push(45);
        //        stack.push(75);
        //        stack.push(47);
        //        stack.push(8);
        //        stack.push(13);
        //
        //        System.out.println("min : " + stack.min());
        //        stack.printStack();
        //        stack.pop();
        //        stack.printStack();
        //        System.out.println("peek : " + stack.peek());
        //        System.out.println("min : " + stack.min());
        //
        //        stack.pop();
        //        stack.pop();
        //
        //        System.out.println(stack.isEmpty());

        try
        {
            System.out.println(correction("6 2 / 6 +"));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println(validParenthese("{({})}()"));
    }

    public static double npi(final String s)
    {
        final Stack<Integer> numbers = new Stack<>();
        String[] array = s.split(" ");
        int result = 0;
        for (String item : array)
        {
            try
            {
                int value = Integer.parseInt(item);
                numbers.push(value);

            } catch (NumberFormatException e)
            {
                Integer number;
                switch (item)
                {
                    case "+":
                        number = numbers.pop();
                        while (number != null)
                        {
                            result += number;
                            number = numbers.pop();
                        }
                        break;
                    case "-":
                        number = numbers.pop();
                        result = number;
                        while (number != null)
                        {
                            result -= number;
                            number = numbers.pop();
                        }
                        break;
                    case "*":
                        number = numbers.pop();
                        while (number != null)
                        {
                            if (result == 0) result = 1;
                            result *= number;
                            number = numbers.pop();
                        }
                        break;
                    case "/":
                        number = numbers.pop();
                        while (number != null)
                        {
                            result /= number;
                            number = numbers.pop();
                        }
                        break;

                }
            }
        }
        return result;
    }

    public static double correction(String s) throws Exception
    {
        Stack<Double> stack = new Stack<>();
        String[] array = s.split(" ");

        for (String operation : array)
        {
            if (isOperator(operation))
            {
                Double second = Double.valueOf(stack.pop());
                Double first = Double.valueOf(stack.pop());
                Double result = operate(first, second, operation);
                stack.push(result);
            } else
            {
                stack.push(Double.valueOf(operation));
            }
        }

        return stack.top.value;
    }

    private static Double operate(Double first, Double second, String operation) throws Exception
    {
        switch (operation)
        {
            case "*":
                return first * second;
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "/":
                if (second == 0) throw new Exception("yo");
                return first / second;
        }
        return 0.0;
    }

    private static boolean isOperator(String operation)
    {
        return operation.equals("*") || operation.equals("+") || operation.equals("-") || operation.equals("/");
    }

    public static boolean validParenthese(final String s)
    {
        Stack<Character> elements = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            final char c = s.charAt(i);
            if (isOpening(c))
            {
                elements.push(c);
            } else
            {
                if (elements.isEmpty() || c != getReverseOf(elements.peek()))
                {
                    return false;
                } else
                {
                    elements.pop();
                }
            }
        }
        if (elements.size == 0)
            return true;
        else
            return false;

    }

    private static Character getReverseOf(char c)
    {
        switch (c)
        {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return null;
        }
    }

    private static boolean isOpening(char c)
    {
        return c == '(' || c == '{' || c == '[';
    }


}

