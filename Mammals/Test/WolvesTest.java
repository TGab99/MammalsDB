import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class WolvesTest {
    Connection conn = null;

    @Before
    public void getConnection()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mammals?autoReconnect=true&useSSL=false","root","");

        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void numbersInDB() {
        int count = 0;
        Wolves wolf = new Wolves();
        try {
            Statement stmt = conn.createStatement();

            String query = "select count(*) from wolves";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(count,wolf.numbersInDB(conn));
    }
}