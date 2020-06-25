import java.sql.Connection;
import java.util.List;

public class Mammals {
    private StrategyMammals _mammals;

    public void MammalsChoice(StrategyMammals m){
        this._mammals = m;
    }

    public  String specie(){
        return this._mammals.specie();
    }

    public int numbersInDB(Connection conn){
        return this._mammals.numbersInDB(conn);
    }

    public int numbersOfSubspecies(Connection conn){
        return this._mammals.numbersOfSubspecies(conn);
    }

    public List<String> addData(Connection conn){
            return this._mammals.addData(conn);
    }
}
