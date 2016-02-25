package Task004;

import Task004.MotorType.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestElectricMotor {
    public static Motor motor;
    public static double EPS = 1e-9;

    @BeforeClass
    public static void beforeClass(){
        motor = new ElectricMotor();
    }

    @Test
    public void voiceShouldBeCorrect(){
        String voice = "MMMMM - MMMM - mmmmm";
        Assert.assertEquals(motor.doVoice(),voice);
    }

    @Test
    public void HorsepowerShouldBe100(){
        Assert.assertEquals(100,motor.getHowHorsepower());
    }

    @Test
    public void motorShouldBeCorrect(){
        Assert.assertEquals(1.0,motor.getMotorPower(), EPS);
    }
    @Test
    public void motorTypeShouldBeCorrect(){
        String type = "I am Electric motor";
        Assert.assertEquals(type,motor.getMotorType());
    }
}
