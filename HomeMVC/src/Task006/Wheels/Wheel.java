package Task006.Wheels;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface Wheel {
    void inflatedWheel(double howPressure);
    String getTypeOfWheel();
    int getProtectorHight();
    int protectorDecrease(int hight);
    double getWheelPressuare();
}
