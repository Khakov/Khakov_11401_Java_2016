package Cars;

import GearBox.GearBox;
import MotorType.ElectricMotor;
import MotorType.Motor;
import Wheels.Wheel;
import Wheels.WinterWheel;

/**
 * Created by Рустам on 12.02.2016.
 */
public class AudiQ7 implements Car, Signalable, Coldable {
    Motor motor =  new ElectricMotor();
    Wheel wheel = new WinterWheel();
    boolean isTurn = false;
    boolean cold = false;
    boolean hot = false;
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
        System.out.println("I am new car from Ingoltchtad");
        return "I am new car from Ingoltchtad";
    }

    @Override
    public String turnOnMotor() {
        isTurn = true;
        motor.doVoice();
        System.out.println("I am turn on");
        return "I am turn on";
    }

    @Override
    public String turnOffMotor() {
        isTurn = false;
        System.out.println("I am turn off");
        return "I am turn off";
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
    public String doMove() {
        System.out.println("I am realy comfort auto");
        return "I am realy comfort auto";
    }

    @Override
    public int getAcceleration(Motor motor, GearBox gear) {
        return (int) (10 /((motor.getMotorPower()* gear.getCof())));
    }

    @Override
    public void ColdAirOn() {
        cold = true;
    }

    @Override
    public void HotAirOn() {
        hot = true;
    }

    @Override
    public void ColdAirOff() {
        cold = false;
    }

    @Override
    public void HotAirOff() {
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
    public String doSignal() {
        return signal;
    }

    @Override
    public String getRadar(double distanceToCar, double speedOfCar) {
        if(distanceToCar> 5 & speedOfCar >90)
            return "Oppps";
        else
            return "Good control";
    }
}
