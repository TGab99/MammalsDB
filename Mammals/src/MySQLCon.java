import java.sql.*;

public class MySQLCon{
    private static MySQLCon uniqueInstance = null;

    private MySQLCon(){}

    public static MySQLCon getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new MySQLCon();
        }

        return uniqueInstance;
    }

    public Boolean getConnection(){
        Boolean con = false;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mammals?autoReconnect=true&useSSL=false","root","");

            Statement stmt = conn.createStatement();
            con = true;
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }

        return con;
    }
}
