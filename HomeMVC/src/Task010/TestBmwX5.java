package Task010;

import Task006.Cars.CoolCar;
import Task006.GearBox.GearBox;
import Task006.GearBox.MechanicGearBox;
import Task006.MotorType.Motor;
import Task006.MotorType.PetrolMotor;
import Task006.Wheels.Wheel;
import Task006.Wheels.WinterWheel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestBmwX5 {
    public static CoolCar car;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    @BeforeClass
    public static void beforeClass() {
        car = (CoolCar) ac.getBean("bmwX5");
    }

    @Test
    public void setSummerWheelShouldBeCorrect() {
        CoolCar newCar = (CoolCar) ac.getBean("bmwX5");
        Wheel wheel = (WinterWheel) ac.getBean("winterWheel");
        Wheel oldWheel = newCar.getWheel();
        newCar.setNewWheel(wheel);
        Assert.assertNotEquals(newCar.getWheel().getTypeOfWheel(), oldWheel.getTypeOfWheel());
    }

    @Test
    public void setNewMotorShouldBeCorrect() {
        CoolCar newCar = (CoolCar) ac.getBean("bmwX5");
        Motor motor = (PetrolMotor) ac.getBean("petrolMotor");
        Motor oldMotor = newCar.getMotor();
        newCar.setNewMotor(motor);
        Assert.assertNotEquals(newCar.getMotor().getMotorType(), oldMotor.getMotorType());
    }

    @Test
    public void motorShouldBeTurnOn(){
        car.turnOffMotor();
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