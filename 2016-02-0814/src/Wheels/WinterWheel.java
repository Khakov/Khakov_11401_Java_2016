package Wheels;

/**
 * Created by Рустам on 12.02.2016.
 */
public class WinterWheel implements Wheel {
    int protectorHight = 8;
    double wheelPressuare = 1.8;
    boolean wheelLife = true;
    @Override
    public void inflatedWheel(double howPressure) {
        wheelPressuare +=howPressure;
    }

    @Override
    public String getTypeOfWheel() {
        return "Winter wheel with thorns";
    }

    @Override
    public int getProtectorHight() {
        return protectorHight;
    }

    @Override
    public int protectorDecrease(int hight) {
        protectorHight -=(hight/2);
        if (protectorHight<0)
            wheelLife = false;
        if(wheelPressuare<0)
            this.inflatedWheel(1.8);
        return protectorHight;
    }
}
