package Task005;

import Task005.Game.Checker;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestChecker {
    public static Checker checker;

    @BeforeClass
    public static void beforeClass(){
        checker = new Checker(1);
    }

    @Test
    public void firstParamShouldBeSaved(){
        checker.setX(1);
        Assert.assertEquals(1,checker.getX());
    }

    @Test
    public void secondParamShouldBeSaved(){
        checker.setY(1);
        Assert.assertEquals(1,checker.getY());
    }

    @Test
    public void imageShouldBeSaved(){
        checker.setImage(1);
        Assert.assertEquals(1,checker.getImage());
    }

    @Test
    public void colorShouldBeSaved(){
        checker.setColor(0);
        Assert.assertEquals(0,checker.getColor());
    }

    @Test
    public void queenShouldBeSaved(){
        checker.setColor(1);
        checker.setQueen();
        Assert.assertTrue(checker.isQueen());
    }

    @Test
    public void newCheckerShouldBeSaved(){
        checker = new Checker(2);
        Assert.assertEquals(2,checker.getColor());
    }
}
