import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dogs extends StrategyMammals{
    @Override
    public String specie(){
        return "Dog";
    }

    @Override
    public int numbersInDB(Connection conn){
        Statement stmt = null;
        int count = 0;
        try {
            stmt = conn.createStatement();

            String query = "select count(*) from dogs";

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

            String query = "select count(subspecies) from dogs";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
