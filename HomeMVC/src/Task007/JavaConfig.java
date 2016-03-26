package Task007; /**
 * Created by Rus on 02.03.2016.
 */

import Task006.GearBox.MechanicGearBox;
import Task006.GearBox.RobotGearBox;
import Task006.MotorType.DieselMotor;
import Task006.MotorType.ElectricMotor;
import Task006.MotorType.PetrolMotor;
import Task006.Wheels.SummerWheel;
import Task006.Wheels.WinterWheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"Task006.Cars", "Task006.Wheels", "Task006.MotorType", "Task006.GearBox"})
public class JavaConfig {
    @Bean
    @Qualifier("dieselMotor")
    public DieselMotor dieselMotor() {
        return new DieselMotor();
    }

    @Bean
    @Qualifier("electricMotor")
    public ElectricMotor electricMotor() {
        return new ElectricMotor();
    }

    @Bean
    @Qualifier("petrolMotor")
    public PetrolMotor petrolMotor() {
        return new PetrolMotor();
    }

    @Bean
    @Qualifier("winterWheel")
    public WinterWheel winterWheel() {
        return new WinterWheel();
    }

    @Bean
    @Qualifier("summerWheel")
    public SummerWheel summerWheel() {
        return new SummerWheel();
    }

    @Bean
    @Qualifier("mechanicGearBox")
    public MechanicGearBox mechanicGearBox() {
        return new MechanicGearBox();
    }
    @Bean
    @Qualifier("robotGearBox")
    public RobotGearBox robotGearBox() {
        return new RobotGearBox();
    }
}
