package Task005;

import Task005.Game.ConnectFrame;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestConnectionFrame {
    public static ConnectFrame frame;

    @BeforeClass
    public static void beforeClass(){
        frame = new ConnectFrame();
    }

    @Test
    public void connectionShouldBeConnectWithInetAdress(){
        InetAddress ia = mock(InetAddress.class);
        when(ia.toString()).thenReturn("/127.0.0.1");
        frame.connect(ia);
        Assert.assertFalse(frame.getSocket()!=null);
    }
}
