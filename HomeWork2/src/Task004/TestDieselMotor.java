package Task004;

import Task004.MotorType.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestDieselMotor {
    public static Motor motor;
    public static double EPS = 1e-9;

    @BeforeClass
    public static void beforeClass(){
        motor = new DieselMotor();
    }

    @Test
    public void voiceShouldBeCorrect(){
        String voice = "Dring-Dring-Dring";
        Assert.assertEquals(motor.doVoice(),voice);
    }

    @Test
    public void HorsepowerShouldBe150(){
        Assert.assertEquals(150,motor.getHowHorsepower());
    }

    @Test
    public void motorShouldBeCorrect(){
        Assert.assertEquals(1.5,motor.getMotorPower(), EPS);
    }
    @Test
    public void motorTypeShouldBeCorrect(){
        String type = "I am Diesel motor";
        Assert.assertEquals(type,motor.getMotorType());
    }
}
