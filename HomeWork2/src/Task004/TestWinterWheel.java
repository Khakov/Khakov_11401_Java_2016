package Task004;

import Task004.Wheels.*;
import org.junit.*;
import org.junit.Test;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestWinterWheel {
    public static Wheel winterWheel;
    public static double EPS = 1e-9;

    @BeforeClass
    public static void beforeClass(){
        winterWheel = new WinterWheel();
    }

    @org.junit.Test
    public void protectedDecreaseShouldBeCorrect(){
        Assert.assertEquals(6,winterWheel.getProtectorHight());
    }

    @Test
    public void inflatedWheelMethodShouldBeCorrect(){
        winterWheel.inflatedWheel(2.0);
        Assert.assertEquals(4,winterWheel.getWheelPressuare(),EPS);
    }
}
