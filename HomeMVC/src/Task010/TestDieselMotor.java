package Task010;

import Task006.MotorType.DieselMotor;
import Task006.MotorType.Motor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestDieselMotor {
    public static Motor motor;
    public static double EPS = 1e-9;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    @BeforeClass
    public static void beforeClass(){
        motor = (DieselMotor) ac.getBean("dieselMotor");
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
