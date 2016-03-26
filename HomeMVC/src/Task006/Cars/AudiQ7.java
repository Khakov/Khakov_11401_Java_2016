package Task006.Cars;

import Task006.GearBox.GearBox;
import Task006.MotorType.Motor;
import Task006.Wheels.Wheel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Рустам on 12.02.2016.
 */
@Component
public class AudiQ7 implements CoolCar {
    @Autowired
    @Qualifier("electricMotor")
    Motor motor;
    @Autowired
    @Qualifier("winterWheel")
    Wheel wheel;
    boolean isTurn = false;
    boolean cold = false;
    boolean hot = false;
    String signal = "none";

    public AudiQ7(){}
    public AudiQ7(Motor motor, Wheel wheel) {
        this.motor = motor;
        this.wheel = wheel;
    }

    @Override
    public String getSignal() {
        return signal;
    }

    public boolean isTurn() {
        return isTurn;
    }

    @Override
    public boolean isCold() {
        return cold;
    }

    @Override
    public boolean isHot() {
        return hot;
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
        System.out.println("I am new car from Ingoltchtad");
        return "I am new car from Ingoltchtad";
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
        System.out.println("I am turn on with button, with remote control");
        return "I am turn on with button, with remote control";
    }

    @Override
    public int getMaxSpeed(Motor motor, GearBox gear) {
        return (int) (motor.getMotorPower() * 300 * gear.getCof());
    }

    @Override
    public void doMove() {
        System.out.println("I am realy comfort auto");
    }

    @Override
    public int getAcceleration(Motor motor, GearBox gear) {
        return (int) (10 /((motor.getMotorPower()* gear.getCof())));
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

    @Override
    public void signalTurn(boolean signalOn) {
        if (signalOn)
            signal = "Bziyi-Bziyi";
        else
            signal = "none";
    }

    @Override
    public void doSignal() {
        System.out.println(signal);
    }

    @Override
    public void getRadar(double distanceToCar, double speedOfCar) {
        if(distanceToCar> 5 & speedOfCar >90)
            System.out.println("Oppps");
        else
            System.out.println("Good control");
    }
}
