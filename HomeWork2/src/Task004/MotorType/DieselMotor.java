package Task004.MotorType;

/**
 * Created by Рустам on 12.02.2016.
 */
public class DieselMotor implements Motor {
    int horsepower = 150;
    double motorpower = 1.5;

    @Override
    public int getHowHorsepower() {
        return horsepower;
    }

    @Override
    public String getMotorType() {
        return "I am Diesel motor";
    }

    @Override
    public double getMotorPower() {
        return motorpower;
    }

    @Override
    public String doVoice() {
        return "Dring-Dring-Dring";
    }
}
