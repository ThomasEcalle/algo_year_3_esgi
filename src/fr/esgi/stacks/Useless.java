package fr.esgi.stacks;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by Thomas Ecalle on 21/05/2017.
 */
public class Useless
{
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MasSuperAnnotation
    {

    }

    @MasSuperAnnotation
    public void a()
    {
        System.out.println("toujours appelée avant");
    }

    public void b()
    {
        System.out.println("b");
    }

    public static void main(String[] args)
    {
        Class c = Useless.class;

        for (Method method : c.getDeclaredMethods())
        {

            if (method.isAnnotationPresent(MasSuperAnnotation.class))
            {
                try
                {
                    Object o = c.newInstance();
                    method.invoke(o);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }


        Useless useless = new Useless();
        useless.b();
    }
}


