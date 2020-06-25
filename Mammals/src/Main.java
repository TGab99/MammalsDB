import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.LabelUI;

public class Main {
    public static JTextArea specie = new JTextArea();
    public static JTextArea addText = new JTextArea("Give a species!");

    public static void main(String args[]){

        MySQLCon mysqlc = MySQLCon.getInstance();
        mysqlc.getConnection();
        if(mysqlc.addBoolean() == true)
            System.out.println("Success connection!");
        else
            System.out.println("No success connection!");

        Mammals mammal = new Mammals();
        mammal.MammalsChoice(new Wolves());
        System.out.println(mammal.specie());
        System.out.println(mammal.numbersInDB(mysqlc.getConnection()));
        System.out.println(mammal.numbersOfSubspecies(mysqlc.getConnection()));

        Mammals mammal2 = new Mammals();
        mammal2.MammalsChoice(new Dogs());
        System.out.println(mammal2.specie());
        System.out.println(mammal2.numbersInDB(mysqlc.getConnection()));
        System.out.println(mammal2.numbersOfSubspecies(mysqlc.getConnection()));

        Mammals mammal3 = new Mammals();
        mammal3.MammalsChoice(new Cats());
        System.out.println(mammal3.specie());
        System.out.println(mammal3.numbersInDB(mysqlc.getConnection()));
        System.out.println(mammal3.numbersOfSubspecies(mysqlc.getConnection()));

        Mammals mammal4 = new Mammals();
        mammal4.MammalsChoice(new Wildcats());
        System.out.println(mammal4.specie());
        System.out.println(mammal4.numbersInDB(mysqlc.getConnection()));
        System.out.println(mammal4.numbersOfSubspecies(mysqlc.getConnection()));

        mysqlc.databaseClose();
    }
}
