import java.sql.*;

public class MySQLCon{
    private static MySQLCon uniqueInstance = null;
    private Boolean con = false;

    private MySQLCon(){}

    public static MySQLCon getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new MySQLCon();
        }

        return uniqueInstance;
    }

    public Connection getConnection()
    {
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mammals?autoReconnect=true&useSSL=false","root","");

            con = true;

        }catch(Exception e){
            System.out.println(e);
        }

        return conn;
    }

    public Boolean addBoolean(){
        return con;
    }

    public void databaseClose(){
        try{
            getConnection().close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
