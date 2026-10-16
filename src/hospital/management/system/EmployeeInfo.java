package hospital.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfo extends JFrame {
    EmployeeInfo(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(173,216,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,400);
        table.setBackground(new Color(173,216,163));
        panel.add(table);

        try{
            Connect c = new Connect();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(15,11,70,20);
        label1.setFont(new Font("Aptos",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(175,11,70,20);
        label2.setFont(new Font("Aptos",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Contact no.");
        label3.setBounds(335,11,90,20);
        label3.setFont(new Font("Aptos",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(500,11,70,20);
        label4.setFont(new Font("Aptos",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(665,11,70,20);
        label5.setFont(new Font("Aptos",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar no.");
        label6.setBounds(827,11,90,20);
        label6.setFont(new Font("Aptos",Font.BOLD,14));
        panel.add(label6);

        JButton button = new JButton("BACK");
        button.setBounds(750,440,120,30);
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
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
