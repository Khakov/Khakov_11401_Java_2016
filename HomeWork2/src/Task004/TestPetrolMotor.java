package Task004;

import Task004.MotorType.*;
import org.junit.Test;
import org.junit.*;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestPetrolMotor {
    public static Motor motor;
    public static double EPS = 1e-9;

    @BeforeClass
    public static void beforeClass() {
        motor = new PetrolMotor();
    }
    
    @Test
    public void voiceShouldBeCorrect() {
        String voice = "Bring-Bring-Bring";
        Assert.assertEquals(motor.doVoice(), voice);
    }

    @Test
    public void HorsepowerShouldBe180() {
        Assert.assertEquals(180, motor.getHowHorsepower());
    }

    @Test
    public void motorShouldBeCorrect() {
        Assert.assertEquals(1.2, motor.getMotorPower(), EPS);
    }

    @Test
    public void motorTypeShouldBeCorrect() {
        String type = "I am Petrol motor";
        Assert.assertEquals(type, motor.getMotorType());
    }
}
