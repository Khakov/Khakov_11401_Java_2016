package Task010;

import Task006.Cars.AudiQ7;
import Task006.Cars.CoolCar;
import Task006.GearBox.GearBox;
import Task006.GearBox.MechanicGearBox;
import Task006.MotorType.DieselMotor;
import Task006.MotorType.Motor;
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
public class TestAudiQ7 {
    public static CoolCar car;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    @BeforeClass
    public static void beforeClass() {
        car = (AudiQ7) ac.getBean("audiQ7");
    }

    @Test
    public void setSummerWheelShouldBeCorrect() {
        CoolCar newCar = (AudiQ7) ac.getBean("audiQ7");
        Wheel wheel = (SummerWheel) ac.getBean("summerWheel");
        Wheel oldWheel = newCar.getWheel();
        newCar.setNewWheel(wheel);
        Assert.assertNotEquals(newCar.getWheel().getTypeOfWheel(), oldWheel.getTypeOfWheel());
    }

    @Test
    public void setNewMotorShouldBeCorrect() {
        CoolCar newCar = (AudiQ7) ac.getBean("audiQ7");
        Motor motor = (DieselMotor) ac.getBean("dieselMotor");
        Motor oldMotor = newCar.getMotor();
        newCar.setNewMotor(motor);
        Assert.assertNotEquals(newCar.getMotor().getMotorType(), oldMotor.getMotorType());
    }

    @Test
    public void motorShouldBeTurnOn(){
        car.turnOnMotor();
        Assert.assertTrue(car.isTurn());
    }

    @Test
    public void motorShouldBeTurnOff(){
        car.turnOnMotor();
        car.turnOffMotor();
        Assert.assertTrue(!car.isTurn());
    }

    @Test
    public void maxSpeedShouldBeCorrect(){
        GearBox gearBox = (MechanicGearBox) ac.getBean("mechanicGearBox");
        Assert.assertEquals(300,car.getMaxSpeed(car.getMotor(),gearBox));
    }

    @Test
    public void accelerationShouldBeCorrect(){
        GearBox gearBox = (MechanicGearBox) ac.getBean("mechanicGearBox");
        Assert.assertEquals(10,car.getAcceleration(car.getMotor(),gearBox));
    }

    @Test
    public void hotAirShouldBeTurnOn(){
        car.hotAirOff();
        car.hotAirOn();
        Assert.assertTrue(car.isHot());
    }

    @Test
    public void hotAirShouldBeTurnOff(){
        car.hotAirOn();
        car.hotAirOff();
        Assert.assertTrue(!car.isHot());
    }

    @Test
    public void coldAirShouldBeTurnOn(){
        car.coldAirOff();
        car.coldAirOn();
        Assert.assertTrue(car.isCold());
    }

    @Test
    public void coldAirShouldBeTurnOff(){
        car.coldAirOn();
        car.coldAirOff();
        Assert.assertTrue(!car.isCold());
    }

    @Test
    public void signalShouldBeTurnOn(){
        car.signalTurn(true);
        Assert.assertFalse(car.getSignal().equals("none"));
    }
}
