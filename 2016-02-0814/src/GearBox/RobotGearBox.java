package GearBox;

/**
 * Created by Рустам on 12.02.2016.
 */
public class RobotGearBox implements GearBox {
    String gearType = "Robot gear box";
    int thisGear = 0;
    int gearLife = 100000;
    double cof = 1.2;
    @Override
    public String getGearType() {
        return gearType;
    }

    @Override
    public int nextGear() {
        thisGear++;
        gearLife-=2;
        return thisGear;
    }

    @Override
    public int lastGear() {
        thisGear--;
        gearLife -=2;
        return thisGear;
    }

    @Override
    public double getCof() {
        return cof;
    }

    @Override
    public int OnRearGear() {
        thisGear = -1;
        return thisGear;
    }
}
