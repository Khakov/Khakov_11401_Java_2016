package Task010;

import Task006.MotorType.Motor;
import Task006.MotorType.PetrolMotor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestPetrolMotor {
    public static Motor motor;
    public static double EPS = 1e-9;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");


    @BeforeClass
    public static void beforeClass() {
        motor = (PetrolMotor) ac.getBean("petrolMotor");
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
