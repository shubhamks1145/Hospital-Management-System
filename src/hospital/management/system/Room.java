package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;
    Room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(173,216,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/room.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);


        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(173,216,163));
        panel.add(table);

        try{
            Connect c = new Connect();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12,15,80,18);
        label1.setFont(new Font("Aptos",Font.BOLD,15));
        label1.setForeground(Color.DARK_GRAY);
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(135,15,80,18);
        label2.setFont(new Font("Aptos",Font.BOLD,15));
        label2.setForeground(Color.DARK_GRAY);
        panel.add(label2);

        JLabel label3 = new JLabel("Room Price");
        label3.setBounds(260,15,100,18);
        label3.setFont(new Font("Aptos",Font.BOLD,15));
        label3.setForeground(Color.DARK_GRAY);
        panel.add(label3);

        JLabel label4 = new JLabel("Room Type");
        label4.setBounds(385,15,100,18);
        label4.setFont(new Font("Aptos",Font.BOLD,15));
        label4.setForeground(Color.DARK_GRAY);
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(200,440,120,30);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Room();
    }
}
