package Task004;

import Task004.Cars.*;
import Task004.GearBox.RobotGearBox;
import Task004.MotorType.DieselMotor;
import Task004.Wheels.Wheel;
import Task004.Wheels.SummerWheel;
import Task004.Wheels.WinterWheel;


/**
 * Created by Рустам on 12.02.2016.
 */
public class Test {
    public static void main(String[] args) {
        Wheel winterWheel = new WinterWheel();
        Wheel summerWheel = new SummerWheel();
        winterWheel.inflatedWheel(0.5);
        winterWheel.protectorDecrease(4);
        summerWheel.inflatedWheel(0.6);
        summerWheel.protectorDecrease(4);
        System.out.println(winterWheel.getTypeOfWheel()+ " : " + winterWheel.getProtectorHight());
        BmwX5 BmwX5 = new BmwX5();
        BmwX5.turnOnMotor();
        BmwX5.setNewWheel(winterWheel);
        BmwX5.setNewWheel(summerWheel);
        BmwX5.signalTurn(true);
        BmwX5.doSignal();
        BmwX5.hotAirOn();
        BmwX5.hotAirOff();
        AudiQ7 AudiQ7 = new AudiQ7();
        AudiQ7.doMove();
        AudiQ7.doSignal();
        AudiQ7.coldAirOn();
        AudiQ7.coldAirOff();
        System.out.println("Max Horsepower: " + AudiQ7.getMaxSpeed(new DieselMotor(), new RobotGearBox()));
        System.out.println("Acceleration: " + AudiQ7.getAcceleration(new DieselMotor(), new RobotGearBox()));
        AudiQ7.setNewMotor(new DieselMotor());
        System.out.println(AudiQ7.getTypeOfTurn()+ " " + AudiQ7.getTypeOfCar());

        Car smartCar = new SmartCar();//восходящее преобразование
        Car renaultClio = new RenaultClio();
        smartCar.doMove();
        renaultClio.turnOnMotor();// позднее связывание
        renaultClio.turnOffMotor();
        System.out.println(renaultClio.getTypeOfCar());
    }
}
