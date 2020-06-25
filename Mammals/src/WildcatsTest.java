import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class WildcatsTest {
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
    public void numbersOfSubspecies() {
        Wildcats wildcats = new Wildcats();

        int count = 0;
        try {
            Statement stmt = conn.createStatement();

            String query = "select count(*) from(select distinct subspecies from wildcats) wildcats";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(count,wildcats.numbersOfSubspecies(conn));
    }
}