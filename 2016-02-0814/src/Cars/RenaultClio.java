package Cars;

import GearBox.GearBox;
import MotorType.Motor;
import MotorType.PetrolMotor;
import Wheels.SummerWheel;
import Wheels.Wheel;

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
        return (int) (motor.getMotorPower() * 102 * gear.getCof());
    }

    @Override
    public String doMove() {
        return "I am comfort auto";
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
}
