package Task006.Cars;

import Task006.MotorType.Motor;
import Task006.Wheels.Wheel;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface Car extends TurnOnable, Moveable {
    Wheel getWheel();
    Motor getMotor();
    boolean isTurn();
    void setNewWheel(Wheel new_wheel);
    void setNewMotor(Motor new_motor);
    String getTypeOfCar();
}
