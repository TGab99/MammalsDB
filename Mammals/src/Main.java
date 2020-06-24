import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;

public class Main {
    public static void main(String args[]){

        /*JFrame frame = new JFrame("Mammals Database");
        frame.setSize(500,600);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea();
        MySQLCon mysqlc = MySQLCon.getInstance();
        Connection conn = mysqlc.getConnection();

        if(mysqlc.addBoolean() == true)
            textArea.setText("Success connection!");
        else
            textArea.setText("No success connection!");
        textArea.setEditable(false);

        JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);

        JTextArea addText = new JTextArea("Give a species!");
        addText.setEditable(true);
        addText.setSize(100,10);
        JButton add = new JButton("Add");
        add.setSize(10,10);

        JTextArea specie = new JTextArea();
        specie.setColumns(10);
        JTextField numbersindb = new JTextField();
        numbersindb.setColumns(10);
        JTextField numbersofsubspecies = new JTextField();
        numbersofsubspecies.setColumns(10);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addText.getText().toLowerCase() == "wolf"){
                    Mammals mammal = new Mammals();
                    mammal.MammalsChoice(new Wolves());
                    String s = mammal.specie();
                    specie.setText(s);
                    numbersindb.setText(" " + mammal.numbersInDB(conn));
                    numbersofsubspecies.setText(" " + mammal.numbersofSubspecies(conn));
                }
            }
        });

        panel.add(textArea);
        panel.add(sep1);
        panel.add(addText);
        panel.add(add);
        panel.add(specie);
        panel.add(numbersindb);
        panel.add(numbersofsubspecies);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);*/

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
        mysqlc.databaseClose();
    }
}
