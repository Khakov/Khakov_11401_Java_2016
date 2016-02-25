package Task005;

import Task005.Game.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.Queue;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestConnection {
    public static Task005.Game.Connection connection;
    @BeforeClass
    public static void beforeClass() throws IOException, ClassNotFoundException {
        Server server = mock(Server.class);
        Socket socket1 = mock(Socket.class);
        Socket socket2 = mock(Socket.class);
        ObjectInputStream is = mock(ObjectInputStream.class);
        when(is.readObject()).thenReturn("Hello I am mock");
        ObjectOutputStream os = mock(ObjectOutputStream.class);
        when(socket1.getOutputStream()).thenReturn(os);
        when(socket2.getOutputStream()).thenReturn(os);
        when(socket1.getInputStream()).thenReturn(is);
        when(socket2.getInputStream()).thenReturn(is);
        connection = new Task005.Game.Connection(server,socket1,socket2);
    }
    @Test(expected = NullPointerException.class)
    public void runShouldBeCorrect(){
        connection.run();

    }

}
