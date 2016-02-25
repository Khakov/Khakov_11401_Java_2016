package Task004;

import Task004.Cars.*;
import Task004.GearBox.*;
import Task004.MotorType.*;
import Task004.Wheels.*;
import org.junit.*;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestBmwX5 {
    public static CoolCar car;

    @BeforeClass
    public static void beforeClass() {
        car = new BmwX5();
    }

    @Test
    public void setSummerWheelShouldBeCorrect() {
        CoolCar newCar = new BmwX5();
        Wheel wheel = mock(WinterWheel.class);
        Wheel oldWheel = newCar.getWheel();
        when(wheel.getTypeOfWheel()).thenReturn("I'm not a wheel, I'm mock!");
        newCar.setNewWheel(wheel);
        Assert.assertNotEquals(newCar.getWheel().getTypeOfWheel(), oldWheel.getTypeOfWheel());
    }

    @Test
    public void setNewMotorShouldBeCorrect() {
        CoolCar newCar = new BmwX5();
        Motor motor = mock(PetrolMotor.class);
        Motor oldMotor = newCar.getMotor();
        when(motor.getMotorType()).thenReturn("I'm not a motor, I'm mock!");
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
        GearBox gearBox = mock(MechanicGearBox.class);
        when(gearBox.getCof()).thenReturn(1.0);
        Assert.assertEquals(300,car.getMaxSpeed(car.getMotor(),gearBox));
    }

    @Test
    public void accelerationShouldBeCorrect(){
        GearBox gearBox = mock(MechanicGearBox.class);
        when(gearBox.getCof()).thenReturn(1.0);
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