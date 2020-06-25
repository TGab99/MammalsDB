import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

public class MySQLConTest {
    Boolean con = false;

    @Before
    public void getConnection()
    {
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mammals?autoReconnect=true&useSSL=false","root","");

            con = true;

        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void addConnectionBoolean() {
        assertTrue(con);
    }
}