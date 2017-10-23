package tests.fr.esgi.stacks;

import fr.esgi.stacks.Main;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Thomas Ecalle on 11/04/2017.
 */
public class MainTest
{
    @Test
    public void testP()
    {
        assertTrue(Main.validParenthese("()"));
    }
}