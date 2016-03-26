package Task006.Cars;

import Task006.GearBox.GearBox;
import Task006.MotorType.Motor;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface Moveable {
    int getMaxSpeed(Motor motor, GearBox gear);
    int getAcceleration(Motor motor, GearBox gear);
    void doMove();
}
