import java.sql.Connection;
import java.util.List;

public abstract class StrategyMammals {

    public abstract String specie();

    public abstract int numbersInDB(Connection conn);

    public abstract int numbersOfSubspecies(Connection conn);

    public abstract  List<String> addData(Connection conn);
}
