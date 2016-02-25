package Task004.Cars;

import Task004.GearBox.GearBox;
import Task004.MotorType.*;
import Task004.Wheels.*;

/**
 * Created by Рустам on 12.02.2016.
 */
public class RenaultClio implements Car, Coldable {
    Motor motor =  new PetrolMotor();
    Wheel wheel = new SummerWheel();
    boolean isTurn = false;
    boolean cold = false;
    boolean hot = false;

    @Override
    public boolean isTurn() {
        return isTurn;
    }

    @Override
    public Wheel getWheel() {
        return wheel;
    }

    @Override
    public Motor getMotor() {
        return motor;
    }

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
        return "I am car from France";
    }

    @Override
    public void turnOnMotor() {
        isTurn = true;
        motor.doVoice();
        System.out.println("I am turn on");
    }

    @Override
    public void turnOffMotor() {
        isTurn = false;
        System.out.println("I am turn off");
    }

    @Override
    public String getTypeOfTurn() {
        return "I am turn on with key";
    }

    @Override
    public int getMaxSpeed(Motor motor, GearBox gear) {
        return (int) (motor.getMotorPower() * 150 * gear.getCof());
    }

    @Override
    public void doMove() {
        System.out.println("I am good auto");
    }

    @Override
    public int getAcceleration(Motor motor, GearBox gear) {
        return (int) (15 /((motor.getMotorPower()* gear.getCof())));
    }

    @Override
    public void coldAirOn() {
        cold = true;
    }

    @Override
    public void hotAirOn() {
        hot = true;
    }

    @Override
    public void coldAirOff() {
        cold = false;
    }

    @Override
    public void hotAirOff() {
        hot = false;
    }

    public boolean isHot() {
        return hot;
    }

    public boolean isCold() {
        return cold;
    }
}
