package Cars;

import GearBox.GearBox;
import MotorType.DieselMotor;
import MotorType.Motor;
import Wheels.SummerWheel;
import Wheels.Wheel;

/**
 * Created by Рустам on 12.02.2016.
 */
public class BmwX5 implements Car, Signalable, Coldable {
    Motor motor =  new DieselMotor();
    Wheel wheel = new SummerWheel();
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
        return "I am jeep-car from Bavaria";
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
        return "I am turn on with button";
    }

    @Override
    public int getMaxSpeed(Motor motor, GearBox gear) {
        return (int) (motor.getMotorPower() * 200 * gear.getCof());
    }

    @Override
    public void doMove() {
        System.out.println("I am very fast auto");
    }

    @Override
    public int getAcceleration(Motor motor, GearBox gear) {
        return (int) (15 /((motor.getMotorPower()* gear.getCof())));
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
            signal = "Yi-yi-yi";
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
