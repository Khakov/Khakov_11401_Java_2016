package Task010;

import Task006.Wheels.SummerWheel;
import Task006.Wheels.Wheel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestSummerWheel {
    public static Wheel summerWheel;
    public static double EPS = 1e-9;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");


    @BeforeClass
    public static void beforeClass(){
        summerWheel = (SummerWheel) ac.getBean("summerWheel");
    }

    @Test
    public void protectedDecreaseShouldBeCorrect(){
        summerWheel.protectorDecrease(4);
        Assert.assertEquals(6,summerWheel.getProtectorHight());
    }

    @Test
    public void inflatedWheelMethodShouldBeCorrect(){
        summerWheel.inflatedWheel(2.0);
        Assert.assertEquals(4,summerWheel.getWheelPressuare(),EPS);
    }
}
