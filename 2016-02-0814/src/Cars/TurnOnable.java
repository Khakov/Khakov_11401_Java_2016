package Cars;

import MotorType.Motor;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface TurnOnable {
    void turnOnMotor();
    void turnOffMotor();
    String getTypeOfTurn();
}
