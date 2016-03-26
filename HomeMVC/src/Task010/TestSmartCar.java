package Task010;

import Task006.Cars.Car;
import Task006.Cars.SmartCar;
import Task006.GearBox.GearBox;
import Task006.GearBox.MechanicGearBox;
import Task006.MotorType.DieselMotor;
import Task006.MotorType.Motor;
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
public class TestSmartCar {
    public static Car car;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    @BeforeClass
    public static void beforeClass() {
        car = (SmartCar) ac.getBean("smartCar");
    }

    @Test
    public void setSummerWheelShouldBeCorrect() {
        Car newCar = (SmartCar) ac.getBean("smartCar");
        Wheel wheel = (WinterWheel) ac.getBean("winterWheel");
        Wheel oldWheel = newCar.getWheel();
        newCar.setNewWheel(wheel);
        Assert.assertNotEquals(newCar.getWheel().getTypeOfWheel(), oldWheel.getTypeOfWheel());
    }

    @Test
    public void setNewMotorShouldBeCorrect() {
        Car newCar = (SmartCar) ac.getBean("smartCar");
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
        Assert.assertEquals(100,car.getMaxSpeed(car.getMotor(),gearBox));
    }

    @Test
    public void accelerationShouldBeCorrect(){
        GearBox gearBox = (MechanicGearBox) ac.getBean("mechanicGearBox");
        Assert.assertEquals(15,car.getAcceleration(car.getMotor(),gearBox));
    }
    @Test
    public void signalShouldBeTurnOn(){
        SmartCar smartCar = (SmartCar) ac.getBean("smartCar");
        smartCar.signalTurn(true);
        Assert.assertFalse(smartCar.getSignal().equals("none"));
    }
}
