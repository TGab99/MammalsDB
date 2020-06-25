import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Wolves extends StrategyMammals{

    @Override
    public String specie(){
        return "Wolf";
    }

    @Override
    public int numbersInDB(Connection conn) {
        Statement stmt = null;
        int count = 0;
        try {
            stmt = conn.createStatement();

            String query = "select count(*) from wolves";

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

            String query = "select count(*) from(select distinct subspecies from wolves) wolves";

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
            String query = "select * from wolves ;";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getObject(1).toString();
                String subspecies = rs.getObject(2).toString();
                String age = rs.getObject(3).toString();
                String gender = rs.getObject(4).toString();
                String bodyLength = rs.getObject(5).toString();
                String height = rs.getObject(6).toString();
                String weight = rs.getObject(7).toString();
                String offspring = rs.getObject(8).toString();
                String s = id+ " " + subspecies + " " + age + " " + gender + " " + bodyLength + " " + height + " " + weight + " " + offspring;

                data.add(s);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
