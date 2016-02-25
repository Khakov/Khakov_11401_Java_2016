package Task004;

import Task004.GearBox.*;
import org.junit.*;
import org.junit.Test;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestRobotGearBox {
    public static GearBox gearBox;

    @Test
    public void nextGearShouldBeCorrect(){
        gearBox = new RobotGearBox();
        Assert.assertEquals(1,gearBox.nextGear());
        Assert.assertEquals(99998, gearBox.getGearLife());
    }
    @Test
    public void lastGearShouldBeCorrect(){
        gearBox = new RobotGearBox();
        Assert.assertEquals(-1,gearBox.lastGear());
        Assert.assertEquals(99998, gearBox.getGearLife());
    }
    @Test
    public void rearGearShouldBeCorrect(){
        gearBox = new RobotGearBox();
        Assert.assertEquals(-1,gearBox.onRearGear());
        Assert.assertEquals(99998, gearBox.getGearLife());
    }
}
