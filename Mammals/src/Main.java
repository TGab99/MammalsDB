import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.LabelUI;

public class Main {
    public static JTextArea specie = new JTextArea();
    public static JTextArea addText = new JTextArea("Give a species!");

    public static void main(String args[]){

        MySQLCon mysqlc = MySQLCon.getInstance();
        mysqlc.getConnection();
        if(mysqlc.addConnectionBoolean() == true)
            System.out.println("Success connection!");
        else
            System.out.println("No success connection!");

        Mammals mammal = new Mammals();
        mammal.MammalsChoice(new Wolves());
        System.out.println("Specie: " + mammal.specie());
        System.out.println("Numbers of record in the wolves table: " + mammal.numbersInDB(mysqlc.getConnection()));
        System.out.println("Numbers of the different subspecies: " + mammal.numbersOfSubspecies(mysqlc.getConnection()));
        System.out.println();
        System.out.println("Subspecies with data");
        List<String> list = mammal.addData(mysqlc.getConnection());
        for(int i = 0; i <list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println();

        Mammals mammal2 = new Mammals();
        mammal2.MammalsChoice(new Dogs());
        System.out.println("Specie: " + mammal2.specie());
        System.out.println("Numbers of records in the dogs table: " + mammal2.numbersInDB(mysqlc.getConnection()));
        System.out.println("Numbers of the different subspecies: " + mammal2.numbersOfSubspecies(mysqlc.getConnection()));
        System.out.println();
        System.out.println("Subspecies with data");
        List<String> list2 = mammal2.addData(mysqlc.getConnection());
        for(int i = 0; i <list2.size(); i++){
            System.out.println(list2.get(i));
        }

        System.out.println();

        Mammals mammal3 = new Mammals();
        mammal3.MammalsChoice(new Cats());
        System.out.println("Specie: " + mammal3.specie());
        System.out.println("Numbers of records in the cats table: " + mammal3.numbersInDB(mysqlc.getConnection()));
        System.out.println("Numbers of the different subspecies: " + mammal3.numbersOfSubspecies(mysqlc.getConnection()));
        System.out.println();
        System.out.println("Subspecies with data");
        List<String> list3 = mammal3.addData(mysqlc.getConnection());
        for(int i = 0; i <list3.size(); i++){
            System.out.println(list3.get(i));
        }

        System.out.println();

        Mammals mammal4 = new Mammals();
        mammal4.MammalsChoice(new Wildcats());
        System.out.println("Specie: " + mammal4.specie());
        System.out.println("Numbers of records in the wildcats table: " + mammal4.numbersInDB(mysqlc.getConnection()));
        System.out.println("Numbers of the different subspecies: " + mammal4.numbersOfSubspecies(mysqlc.getConnection()));
        System.out.println();
        System.out.println("Subspecies with data");
        List<String> list4 = mammal4.addData(mysqlc.getConnection());
        for(int i = 0; i <list4.size(); i++){
            System.out.println(list4.get(i));
        }

        mysqlc.databaseClose();
    }
}
