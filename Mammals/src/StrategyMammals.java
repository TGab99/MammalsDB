import java.sql.Connection;

public abstract class StrategyMammals {

    public abstract String specie();

    public abstract int numbersInDB(Connection conn);

    public abstract int numbersOfSubspecies(Connection conn);
}
