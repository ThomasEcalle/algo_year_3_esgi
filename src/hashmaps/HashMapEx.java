package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Thomas Ecalle on 11/04/2017.
 */
public class HashMapEx
{
    private class Person
    {
        private String name;
        private int age;
        private String adress;

        private Person(String name, int age, String adress)
        {
            this.name = name;
            this.age = age;
            this.adress = adress;
        }

        public String getName()
        {
            return name;
        }

        public int getAge()
        {
            return age;
        }

        public String getAdress()
        {
            return adress;
        }

        @Override
        public String toString()
        {
            return "[" + name + "," + age + "," + adress + "]";
        }

    }

    public void wordCount(String text)
    {
        final String[] array = text.split(" ");
        final HashMap<String, Integer> hashMap = new HashMap();

        for (String s : array)
        {
            if (hashMap.containsKey(s))
            {
                final int result = hashMap.get(s) + 1;
                hashMap.put(s, result);
            } else
            {
                hashMap.put(s, 1);
            }
        }
        for (String key : hashMap.keySet())
        {
            System.out.println(key + " - " + hashMap.get(key));
        }
    }

    // a = 1,3,6,9
    // b = 3,4,9
    // a inter b => 3,9
    // a - b => 1,6
    // b - a => 4
    public static void noIdea(int[] a, int[] b)
    {
        final HashMap<Integer, String> hashMap = new HashMap<>();
        final ArrayList<Integer> aIb = new ArrayList<>();
        final ArrayList<Integer> bMa = new ArrayList<>();
        final ArrayList<Integer> aMb = new ArrayList<>();

        for (int i = 0; i < a.length; i++)
        {
            hashMap.put(a[i], "foo");
        }

        for (int j = 0; j < b.length; j++)
        {
            if (hashMap.containsKey(b[j]))
            {
                aIb.add(b[j]);
                hashMap.remove(b[j]);
            }
            else
            {
                bMa.add(b[j]);
            }
        }

        // Comme on a préalablement retiré toutes les clés communes aux deux, on se retrouve avec
        // Ceux unique à A
        aMb.addAll(hashMap.keySet());
    }

    public static void main(String[] args)
    {
        HashMapEx hashMapEx = new HashMapEx();
        hashMapEx.wordCount("thomas thomas jean titi robin titi");
    }
}
