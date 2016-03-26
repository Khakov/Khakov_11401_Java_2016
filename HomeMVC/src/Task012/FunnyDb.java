package Task012;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Рустам on 17.02.2016.
 */
public class FunnyDb {
    public static Connection getDBConn() throws SQLException {
        Connection conn = mock(Connection.class);
        Statement st = mock(Statement.class);
        when(conn.createStatement()).thenReturn(st);
        ResultSet rs = mock(ResultSet.class);
        when(st.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true, true, true, false);
        when(rs.getString("id")).thenReturn("1", "2");
        when(rs.getString("name")).thenReturn("Vasiliy");
        when(rs.getString("date")).thenReturn("01.01.01");
        return conn;
    }
}
