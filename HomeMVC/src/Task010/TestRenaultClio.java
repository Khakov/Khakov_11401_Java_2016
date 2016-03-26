package Task010;

import Task006.Cars.Car;
import Task006.Cars.RenaultClio;
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
public class TestRenaultClio {
    public static Car car;
    public static RenaultClio clio;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");


    @BeforeClass
    public static void beforeClass() {
        car = (RenaultClio) ac.getBean("renaultClio");
        clio = (RenaultClio) ac.getBean("renaultClio");
    }

    @Test
    public void setSummerWheelShouldBeCorrect() {
        Car newCar = (RenaultClio) ac.getBean("renaultClio");
        Wheel wheel = (WinterWheel) ac.getBean("winterWheel");
        Wheel oldWheel = newCar.getWheel();
        newCar.setNewWheel(wheel);
        Assert.assertNotEquals(newCar.getWheel().getTypeOfWheel(), oldWheel.getTypeOfWheel());
    }

    @Test
    public void setNewMotorShouldBeCorrect() {
        Car newCar = (RenaultClio) ac.getBean("renaultClio");
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
        Assert.assertEquals(180,car.getMaxSpeed(car.getMotor(),gearBox));
    }

    @Test
    public void accelerationShouldBeCorrect(){
        GearBox gearBox = (MechanicGearBox) ac.getBean("mechanicGearBox");
        Assert.assertEquals(12,car.getAcceleration(car.getMotor(),gearBox));
    }

    @Test
    public void hotAirShouldBeTurnOn(){
        clio.hotAirOff();
        clio.hotAirOn();
        Assert.assertTrue(clio.isHot());
    }

    @Test
    public void hotAirShouldBeTurnOff(){
        clio.hotAirOn();
        clio.hotAirOff();
        Assert.assertTrue(!clio.isHot());
    }

    @Test
    public void coldAirShouldBeTurnOn(){
        clio.coldAirOff();
        clio.coldAirOn();
        Assert.assertTrue(clio.isCold());
    }

    @Test
    public void coldAirShouldBeTurnOff(){
        clio.coldAirOn();
        clio.coldAirOff();
        Assert.assertTrue(!clio.isCold());
    }
}
