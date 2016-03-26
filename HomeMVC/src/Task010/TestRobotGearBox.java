package Task010;

import Task006.GearBox.GearBox;
import Task006.GearBox.RobotGearBox;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestRobotGearBox {
    public static GearBox gearBox;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");


    @Test
    public void nextGearShouldBeCorrect(){
        gearBox = (RobotGearBox) ac.getBean("robotGearBox");
        Assert.assertEquals(1,gearBox.nextGear());
        Assert.assertEquals(99998, gearBox.getGearLife());
    }
    @Test
    public void lastGearShouldBeCorrect(){
        gearBox = (RobotGearBox) ac.getBean("robotGearBox");
        Assert.assertEquals(-1,gearBox.lastGear());
        Assert.assertEquals(99998, gearBox.getGearLife());
    }
    @Test
    public void rearGearShouldBeCorrect(){
        gearBox = (RobotGearBox) ac.getBean("robotGearBox");
        Assert.assertEquals(-1,gearBox.onRearGear());
        Assert.assertEquals(99998, gearBox.getGearLife());
    }
}
