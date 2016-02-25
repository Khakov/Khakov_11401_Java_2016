package Task004;

import Task004.Wheels.*;
import org.junit.*;
import org.junit.Test;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestSummerWheel {
    public static Wheel summerWheel;
    public static double EPS = 1e-9;

    @BeforeClass
    public static void beforeClass(){
        summerWheel = new SummerWheel();
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
