package hospital.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(5,45,600,350);
        table.setBackground(new Color(173,216,163));
        table.setFont(new Font("Aptos",Font.BOLD,15));
        table.setForeground(Color.DARK_GRAY);
        panel.add(table);

        try{
            Connect c = new Connect();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel label1 = new JLabel("Department");
        label1.setBounds(5,10,200,25);
        label1.setFont(new Font("Aptos",Font.BOLD,18));
        label1.setForeground(Color.BLUE);
        panel.add(label1);

        JLabel label2 = new JLabel("Phone no");
        label2.setBounds(305,10,200,25);
        label2.setFont(new Font("Aptos",Font.BOLD,18));
        label2.setForeground(Color.BLUE);
        panel.add(label2);

        JButton b1 = new JButton("BACK");
        b1.setBounds(300,400,100,25);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Department();
    }
}
