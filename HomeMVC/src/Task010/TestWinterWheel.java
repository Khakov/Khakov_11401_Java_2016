package Task010;

import Task006.Wheels.Wheel;
import Task006.Wheels.WinterWheel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestWinterWheel {
    public static Wheel winterWheel;
    public static double EPS = 1e-9;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");


    @BeforeClass
    public static void beforeClass(){
        winterWheel = (WinterWheel) ac.getBean("winterWheel");
    }

    @Test
    public void protectedDecreaseShouldBeCorrect(){
        Assert.assertEquals(8,winterWheel.getProtectorHight());
    }

    @Test
    public void inflatedWheelMethodShouldBeCorrect(){
        winterWheel.inflatedWheel(2.0);
        Assert.assertEquals(3.8,winterWheel.getWheelPressuare(),EPS);
    }
}
