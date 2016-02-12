package Wheels;

/**
 * Created by Рустам on 12.02.2016.
 */
public class SummerWheel implements Wheel {
    int protectorHight = 10;
    double wheelPressuare = 2.0;
    boolean wheelLife = true;
    @Override
    public void inflatedWheel(double howPressure) {
        wheelPressuare +=howPressure;
    }

    @Override
    public String getTypeOfWheel() {
        return "Summer Wheel";
    }

    @Override
    public int getProtectorHight() {
        return protectorHight;
    }
    @Override
    public int protectorDecrease(int hight) {
        protectorHight -=hight;
        wheelPressuare -= 0.5;
        if (protectorHight<0)
            wheelLife = false;
        if(wheelPressuare<0)
            this.inflatedWheel(2.0);
        return protectorHight;
    }
}
