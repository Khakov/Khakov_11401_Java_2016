package Task004.GearBox;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface GearBox {
    String getGearType();
    int nextGear();
    int lastGear();
    double getCof();
    int onRearGear();
    int getGearLife();
}
