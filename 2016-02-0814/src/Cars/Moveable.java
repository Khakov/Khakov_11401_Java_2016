package Cars;

import GearBox.GearBox;
import MotorType.Motor;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface Moveable {
    int getMaxSpeed(Motor motor, GearBox gear);
    int getAcceleration(Motor motor, GearBox gear);
    String doMove();
}
