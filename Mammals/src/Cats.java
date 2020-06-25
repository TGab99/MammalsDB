import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cats extends StrategyMammals{
    @Override
    public String specie(){
        return "Cats";
    }

    @Override
    public int numbersInDB(Connection conn) {
        Statement stmt = null;
        int count = 0;
        try {
            stmt = conn.createStatement();

            String query = "select count(*) from cats";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public int numbersOfSubspecies(Connection conn){
        Statement stmt = null;
        int count = 0;
        try {
            stmt = conn.createStatement();

            String query = "select count(*) from(select distinct subspecies from cats) cats";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public List<String> addData(Connection conn){
        List<String> data = new ArrayList<String>();

        try {
            Statement stmt = conn.createStatement();
            String query = "select * from cats ;";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getObject(1).toString();
                String name = rs.getObject(2).toString();
                String subspecies = rs.getObject(3).toString();
                String age = rs.getObject(4).toString();
                String gender = rs.getObject(5).toString();
                String s = id+ " " + name + " " + subspecies + " " + age + " " + gender;

                data.add(s);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
