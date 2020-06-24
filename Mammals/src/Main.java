import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;

public class Main {
    public static void main(String args[]){

        JFrame frame = new JFrame("Mammals Database");
        frame.setSize(500,600);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea();
        MySQLCon mysqlc = MySQLCon.getInstance();

        if(mysqlc.getConnection() == true)
            textArea.setText("Success connection!");
        else
            textArea.setText("No success connection!");
        textArea.setEditable(false);

        panel.add(textArea);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        /*MySQLCon mysqlc = MySQLCon.getInstance();

        if(mysqlc.getConnection() == true)
            System.out.println("Success connection!");
        else
            System.out.println("No success connection!");*/
    }
}
