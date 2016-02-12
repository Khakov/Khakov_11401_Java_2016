package Cars;

import GearBox.GearBox;
import MotorType.ElectricMotor;
import MotorType.Motor;
import Wheels.SummerWheel;
import Wheels.Wheel;

/**
 * Created by Рустам on 12.02.2016.
 */
public class SmartCar implements Car, Signalable {
    Motor motor =  new ElectricMotor();
    Wheel wheel = new SummerWheel();
    boolean isTurn = false;
    String signal = "none";
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
        return "I am new car from Ingoltchtad";
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
        return "I am turn on with button, with remote control";
    }

    @Override
    public int getMaxSpeed(Motor motor, GearBox gear) {
        return (int) (motor.getMotorPower() * 100 * gear.getCof());
    }

    @Override
    public String doMove() {
        return "I am realy comfort auto";
    }

    @Override
    public int getAcceleration(Motor motor, GearBox gear) {
        return (int) (15 /((motor.getMotorPower()* gear.getCof())));
    }

    @Override
    public void signalTurn(boolean signalOn) {
        if (signalOn)
            signal = "Yayuyauyu";
        else
            signal = "none";
    }

    @Override
    public String doSignal() {
        return signal;
    }

    @Override
    public String getRadar(double distanceToCar, double speedOfCar) {
        if(distanceToCar> 5 & speedOfCar >90)
            return "Oppps";
        else
            return "Excellent";
    }
}

