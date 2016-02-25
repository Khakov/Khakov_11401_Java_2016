package Task004;

import Task004.Cars.*;
import Task004.GearBox.*;
import Task004.MotorType.*;
import Task004.Wheels.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestSmartCar {
    public static Car car;

    @BeforeClass
    public static void beforeClass() {
        car = new SmartCar();
    }

    @Test
    public void setSummerWheelShouldBeCorrect() {
        Car newCar = new SmartCar();
        Wheel wheel = mock(WinterWheel.class);
        Wheel oldWheel = newCar.getWheel();
        when(wheel.getTypeOfWheel()).thenReturn("I'm not a wheel, I'm mock!");
        newCar.setNewWheel(wheel);
        Assert.assertNotEquals(newCar.getWheel().getTypeOfWheel(), oldWheel.getTypeOfWheel());
    }

    @Test
    public void setNewMotorShouldBeCorrect() {
        Car newCar = new SmartCar();
        Motor motor = mock(DieselMotor.class);
        Motor oldMotor = newCar.getMotor();
        when(motor.getMotorType()).thenReturn("I'm not a motor, I'm mock!");
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
        GearBox gearBox = mock(MechanicGearBox.class);
        when(gearBox.getCof()).thenReturn(1.0);
        Assert.assertEquals(100,car.getMaxSpeed(car.getMotor(),gearBox));
    }

    @Test
    public void accelerationShouldBeCorrect(){
        GearBox gearBox = mock(MechanicGearBox.class);
        when(gearBox.getCof()).thenReturn(1.0);
        Assert.assertEquals(15,car.getAcceleration(car.getMotor(),gearBox));
    }
    @Test
    public void signalShouldBeTurnOn(){
        SmartCar smartCar = new SmartCar();
        smartCar.signalTurn(true);
        Assert.assertFalse(smartCar.getSignal().equals("none"));
    }
}
