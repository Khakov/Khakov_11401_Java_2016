package Task012;

import org.springframework.aop.framework.ProxyFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Рустам on 17.02.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Connection conn = FunnyDb.getDBConn();
        Statement st = conn.createStatement();
        ProxyFactory pf = new ProxyFactory(st);
        pf.addAdvice(new LogExecute());
        st = (Statement) pf.getProxy();
        st.execute("select * from; drop table users");
        st.execute("select * from ..");
        st.execute("hello * from ..");
    }
}
