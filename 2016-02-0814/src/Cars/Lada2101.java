package Cars;

import GearBox.GearBox;
import MotorType.Motor;
import MotorType.PetrolMotor;
import Wheels.SummerWheel;
import Wheels.Wheel;

/**
 * Created by Рустам on 12.02.2016.
 */
public class Lada2101 implements Car {
    Motor motor =  new PetrolMotor();
    Wheel wheel = new SummerWheel();
    boolean isTurn = false;
    @Override
    public void setNewWheel(Wheel new_wheel) {
        wheel = new_wheel;
    }

    @Override
    public void setNewMotor(Motor new_motor) {
        motor = new_motor;
    }

    @Override
    public String getTypeOfCar() {
        return "I am new car from Russia, best auto in the World";
    }

    @Override
    public String turnOnMotor() {
        isTurn = true;
        motor.doVoice();
        return "I am turn on";
    }

    @Override
    public String turnOffMotor() {
        isTurn = false;
        return "I am turn off";
    }

    @Override
    public String getTypeOfTurn() {
        return "I am turn on with key";
    }

    @Override
    public int getMaxSpeed(Motor motor, GearBox gear) {
        return (int) (motor.getMotorPower() * 80 * gear.getCof());
    }

    @Override
    public String doMove() {
        return "Best auto in world";
    }

    @Override
    public int getAcceleration(Motor motor, GearBox gear) {
        return (int) (25 /((motor.getMotorPower()* gear.getCof())));
    }
}
