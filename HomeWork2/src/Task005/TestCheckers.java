package Task005;

import Task005.Game.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

import static org.mockito.Mockito.mock;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestCheckers {
    public static Checkers checkers;

    @BeforeClass
    public static void beforeClass(){
        checkers = new Checkers(8,1,2);
    }

    @Test
    public void setJumpShouldBeCorrect(){
        JButton jb = mock(JButton.class);
        checkers.setJump(1,1,jb);
        Assert.assertFalse(checkers.isJump() && checkers.isStrokeLimit());
    }

    @Test
    public void openButtonShouldOpenButtonAndStrokeLimited(){
        checkers.setJump(false);
        checkers.setStrokeLimit(false);
        checkers.openButton(4, 4, 2, 2, 1, 1);
        Assert.assertTrue(checkers.isStrokeLimit());
    }

    @Test
    public void captureQueenShouldBeNotStrokeLimited(){
        checkers.setJump(false);
        checkers.setStrokeLimit(false);
        checkers.captureQueen(4, 4, 1, 1,false);
        Assert.assertFalse(checkers.isStrokeLimit());
    }

    @Test
    public void captureCheckerShouldBeNotStrokeLimited(){
        checkers.setJump(false);
        checkers.setStrokeLimit(false);
        checkers.capturedChecker(4, 4, 1, 1);
        Assert.assertFalse(checkers.isStrokeLimit());
    }

    @Test
    public void checkersShouldBeHighlighted(){
        checkers.highlightChecker(3,3,1,1);
        Assert.assertFalse(checkers.getQueue().isEmpty());
        checkers.getQueue().clear();
    }
    @Test
    public void createImageShouldBeCreateArrayWithImage(){
        checkers.createImage();
        Assert.assertTrue(checkers.getImage()[1]!=null);
    }
}
