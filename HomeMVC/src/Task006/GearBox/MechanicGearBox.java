package Task006.GearBox;

/**
 * Created by Рустам on 12.02.2016.
 */
public class MechanicGearBox implements GearBox{
    String gearType = "Mechanic gear";
    int thisGear = 0;
    int gearLife = 100000;

    double cof = 1.0;

    public int getGearLife() {
        return gearLife;
    }
    @Override
    public String getGearType() {
        return gearType;
    }

    @Override
    public int nextGear() {
        thisGear++;
        gearLife--;
        return thisGear;
    }

    @Override
    public int lastGear() {
        thisGear--;
        gearLife--;
        return thisGear;
    }

    @Override
    public double getCof() {
        return cof;
    }

    @Override
    public int onRearGear() {
        thisGear = -1;
        gearLife--;
        return thisGear;
    }
}
