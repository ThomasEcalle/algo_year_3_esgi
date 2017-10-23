package tests.fr.esgi.hashmaps;

import hashmaps.MyHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Thomas Ecalle on 02/05/2017.
 */
public class MyHashMapTest
{
    MyHashMap<String, Integer> map = new MyHashMap<>();

    @Test
    public void put()
    {
        map.put("toto", 48);
        final int result = map.get("toto");
        Assert.assertTrue(result == 48);
        Assert.assertTrue(map.containskey("toto"));
    }

    @Test
    public void putOverride()
    {
        map.put("toto", 48);
        Assert.assertNotNull(map.get("toto"));
        map.put("toto", 5);
        Assert.assertNotNull(map.get("toto"));
        Assert.assertTrue(map.get("toto") == 5);
    }

    @Test
    public void get()
    {
        Assert.assertNull(map.get("titi"));
        map.put("titi", 50);
        Assert.assertNotNull(map.get("titi"));
        Assert.assertTrue(map.get("titi") == 50);
    }

    @Test
    public void contains()
    {
        map.put("titi", 50);
        Assert.assertTrue(map.containskey("titi"));
    }

    @Test
    public void containsNot()
    {
        Assert.assertTrue(map.containskey("bob") == false);
    }

    @Test
    public void remove()
    {
        map.put("toto", 48);
        Assert.assertTrue(map.get("toto") == 48);
        map.remove("toto");

        Assert.assertTrue(map.containskey("toto") == false);

    }
}