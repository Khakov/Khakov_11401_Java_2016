package Cars;

import MotorType.Motor;
import Wheels.Wheel;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface Car extends TurnOnable, Moveable {
    void setNewWheel(Wheel new_wheel);
    void setNewMotor(Motor new_motor);
    String getTypeOfCar();
}
