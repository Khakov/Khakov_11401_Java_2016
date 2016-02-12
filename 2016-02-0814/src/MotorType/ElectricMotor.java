package MotorType;

/**
 * Created by Рустам on 12.02.2016.
 */
public class ElectricMotor implements Motor {
    int horsepower = 100;
    double motorpower = 1.0;

    @Override
    public int getHowHorsepower() {
        return horsepower;
    }

    @Override
    public String getMotorType() {
        return "I am Electric motor";
    }

    @Override
    public double getMotorPower() {
        return motorpower;
    }
    @Override
    public String doVoice() {
        return "MMMMM - MMMM - mmmmm";
    }
}
