package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AllPatientInfo extends JFrame {
    AllPatientInfo() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(173,216,163));
        //panel.setLayout(new BorderLayout());
        panel.setLayout(null);
        add(panel);

        /*JTable table = new JTable();
        table.setBounds(5,40,900,450);
        table.setBackground(new Color(173,216,163));
        table.setFont(new Font("Aptos", Font.BOLD,14));
        panel.add(table);*/
        JTable table = new JTable();

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30,40,900,450);
        table.setBackground(new Color(173,216,163));

        panel.add(sp);

        try{
            Connect c = new Connect();
            String q ="select * from Patient_Info";
            ResultSet resultSet =c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        /*JLabel label1 = new JLabel("Govt. ID");
        label1.setBounds(15,11,100,18);
        label1.setFont(new Font("Aptos",Font.BOLD,16));
        panel.add(label1);

        JLabel label2 = new JLabel("ID Number");
        label2.setBounds(120,11,100,18);
        label2.setFont(new Font("Aptos",Font.BOLD,16));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(230,11,100,18);
        label3.setFont(new Font("Aptos",Font.BOLD,16));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(340,11,100,18);
        label4.setFont(new Font("Aptos",Font.BOLD,16));
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(455,11,100,18);
        label5.setFont(new Font("Aptos",Font.BOLD,16));
        panel.add(label5);

        JLabel label6 = new JLabel("Room no.");
        label6.setBounds(570,11,100,18);
        label6.setFont(new Font("Aptos",Font.BOLD,16));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(678,11,100,18);
        label7.setFont(new Font("Aptos",Font.BOLD,16));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(795,11,100,25);
        label8.setFont(new Font("Aptos",Font.BOLD,16));
        panel.add(label8);*/

        JButton button = new JButton("BACK");
        button.setBounds(795,500,150,30);
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,600);
        setLayout(new BorderLayout());
        //setLayout(null);
        setLocation(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AllPatientInfo();
    }
}
