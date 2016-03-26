package Task006.MotorType;

/**
 * Created by Рустам on 12.02.2016.
 */
public class PetrolMotor implements Motor {
    int horsepower = 180;
    double motorpower = 1.2;


    @Override
    public int getHowHorsepower() {
        return horsepower;
    }

    @Override
    public String getMotorType() {
        return "I am Petrol motor";
    }

    @Override
    public double getMotorPower() {
        return motorpower;
    }

    @Override
    public String doVoice() {
        return "Bring-Bring-Bring";
    }
}
