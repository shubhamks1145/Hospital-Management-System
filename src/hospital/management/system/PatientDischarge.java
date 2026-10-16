/*package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class PatientDischarge extends JFrame {
    PatientDischarge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,800,400);
        panel.setBackground(new Color(176,216,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(10,10,150,20);
        label.setFont(new Font("Aptos",Font.BOLD,16));
        label.setForeground(Color.BLUE);
        panel.add(label);

        JLabel label1 = new JLabel("Customer Id");
        label1.setBounds(10,40,100,20);
        label1.setFont(new Font("Aptos",Font.BOLD,16));
        label1.setForeground(Color.DARK_GRAY);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(120,40,150,25);
        panel.add(choice);

        try{
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room No.");
        label2.setBounds(10,80,100,20);
        label2.setFont(new Font("Aptos",Font.BOLD,16));
        label2.setForeground(Color.DARK_GRAY);
        panel.add(label2);

        JLabel RNo = new JLabel();
        RNo.setBounds(120,80,100,20);
        RNo.setFont(new Font("Aptos",Font.BOLD,16));
        RNo.setForeground(Color.DARK_GRAY);
        panel.add(RNo);

        JLabel label3 = new JLabel("In Time:");
        label3.setBounds(10,120,100,20);
        label3.setFont(new Font("Aptos",Font.BOLD,16));
        label3.setForeground(Color.DARK_GRAY);
        panel.add(label3);

        JLabel INTime = new JLabel();
        INTime.setBounds(120,120,250,20);
        INTime.setFont(new Font("Aptos",Font.BOLD,14));
        INTime.setForeground(Color.DARK_GRAY);
        panel.add(INTime);

        JLabel label4 = new JLabel("Out Time:");
        label4.setBounds(10,160,100,20);
        label4.setFont(new Font("Aptos",Font.BOLD,16));
        label4.setForeground(Color.DARK_GRAY);
        panel.add(label4);

        Date date = new Date();

        JLabel OutTime = new JLabel(""+date);
        OutTime.setBounds(120,160,250,20);
        OutTime.setFont(new Font("Aptos",Font.BOLD,14));
        OutTime.setForeground(Color.DARK_GRAY);
        panel.add(OutTime);

        JButton discharge = new JButton("DISCHARGE");
        discharge.setBounds(10,250,120,30);
        discharge.setBackground(Color.ORANGE);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect c = new Connect();
                try {
                    c.statement.executeUpdate("delete from patient_info where number ='" +choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability ='Available' where room_no='"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done \uD83D\uDC4D");
                    setVisible(false);
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Check = new JButton("CHECK");
        Check.setBounds(150,250,120,30);
        Check.setBackground(Color.ORANGE);
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect c = new Connect();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));

                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("BACK");
        Back.setBounds(290,250,120,30);
        Back.setBackground(Color.ORANGE);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PatientDischarge();
    }
}*/
package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class PatientDischarge extends JFrame {

    double totalAmount = 0;
    double paidAmount = 0;
    double remainingAmount = 0;

    PatientDischarge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,800,400);
        panel.setBackground(new Color(176,216,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(10,10,150,20);
        label.setFont(new Font("Aptos",Font.BOLD,16));
        label.setForeground(Color.BLUE);
        panel.add(label);

        JLabel label1 = new JLabel("Customer Id");
        label1.setBounds(10,40,100,20);
        label1.setFont(new Font("Aptos",Font.BOLD,16));
        label1.setForeground(Color.DARK_GRAY);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(120,40,150,25);
        panel.add(choice);

        try{
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room No.");
        label2.setBounds(10,80,100,20);
        label2.setFont(new Font("Aptos",Font.BOLD,16));
        label2.setForeground(Color.DARK_GRAY);
        panel.add(label2);

        JLabel RNo = new JLabel();
        RNo.setBounds(120,80,100,20);
        RNo.setFont(new Font("Aptos",Font.BOLD,16));
        RNo.setForeground(Color.DARK_GRAY);
        panel.add(RNo);

        JLabel label3 = new JLabel("In Time:");
        label3.setBounds(10,120,100,20);
        label3.setFont(new Font("Aptos",Font.BOLD,16));
        label3.setForeground(Color.DARK_GRAY);
        panel.add(label3);

        JLabel INTime = new JLabel();
        INTime.setBounds(120,120,250,20);
        INTime.setFont(new Font("Aptos",Font.BOLD,14));
        INTime.setForeground(Color.DARK_GRAY);
        panel.add(INTime);

        JLabel label4 = new JLabel("Out Time:");
        label4.setBounds(10,160,100,20);
        label4.setFont(new Font("Aptos",Font.BOLD,16));
        label4.setForeground(Color.DARK_GRAY);
        panel.add(label4);

        Date date = new Date();

        JLabel OutTime = new JLabel(""+date);
        OutTime.setBounds(120,160,250,20);
        OutTime.setFont(new Font("Aptos",Font.BOLD,14));
        OutTime.setForeground(Color.DARK_GRAY);
        panel.add(OutTime);

        // ---------------- BILLING SECTION ----------------

        JLabel label5 = new JLabel("Total Amount:");
        label5.setBounds(10,200,120,20);
        label5.setFont(new Font("Aptos",Font.BOLD,16));
        label5.setForeground(Color.DARK_GRAY);
        panel.add(label5);

        JLabel TotalAmt = new JLabel("0.0");
        TotalAmt.setBounds(120,200,120,20);
        TotalAmt.setFont(new Font("Aptos",Font.BOLD,14));
        TotalAmt.setForeground(Color.DARK_GRAY);
        panel.add(TotalAmt);

        JLabel label6 = new JLabel("Remaining Amt:");
        label6.setBounds(280,200,120,25);
        label6.setFont(new Font("Aptos",Font.BOLD,16));
        label6.setForeground(Color.DARK_GRAY);
        panel.add(label6);

        JLabel RemainingAmt = new JLabel("0.0");
        RemainingAmt.setBounds(400,200,120,20);
        RemainingAmt.setFont(new Font("Aptos",Font.BOLD,14));
        RemainingAmt.setForeground(Color.RED);
        panel.add(RemainingAmt);

        JLabel label7 = new JLabel("Add Amount:");
        label7.setBounds(10,230,100,20);
        label7.setFont(new Font("Aptos",Font.BOLD,16));
        label7.setForeground(Color.DARK_GRAY);
        panel.add(label7);

        JTextField addAmtField = new JTextField();
        addAmtField.setBounds(120,230,120,25);
        panel.add(addAmtField);

        JButton addAmtBtn = new JButton("ADD AMOUNT");
        addAmtBtn.setBounds(250,230,140,25);
        addAmtBtn.setBackground(Color.ORANGE);
        addAmtBtn.setForeground(Color.WHITE);
        panel.add(addAmtBtn);

        // ---------------------------------------------------

        JButton discharge = new JButton("DISCHARGE");
        discharge.setBounds(10,290,120,30);
        discharge.setBackground(Color.ORANGE);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (remainingAmount > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Cannot discharge. Remaining amount: " + remainingAmount);
                    return;
                }

                Connect c = new Connect();
                try {
                    c.statement.executeUpdate("delete from patient_info where number ='" +choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability ='Available' where room_no='"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done \uD83D\uDC4D");
                    setVisible(false);
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Check = new JButton("CHECK");
        Check.setBounds(150,290,120,30);
        Check.setBackground(Color.ORANGE);
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect c = new Connect();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));

                        totalAmount = resultSet.getDouble("Total_Amount");
                        paidAmount = resultSet.getDouble("Paid_Amount");
                        remainingAmount = totalAmount - paidAmount;

                        TotalAmt.setText(String.valueOf(totalAmount));
                        RemainingAmt.setText(String.valueOf(remainingAmount));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        addAmtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = addAmtField.getText().trim();
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter an amount first.");
                    return;
                }

                double addValue;
                try {
                    addValue = Double.parseDouble(text);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid number.");
                    return;
                }

                if (choice.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Select a customer first.");
                    return;
                }

                Connect c = new Connect();
                try {
                    paidAmount += addValue;
                    remainingAmount = totalAmount - paidAmount;

                    c.statement.executeUpdate(
                            "update patient_info set Paid_Amount = " + paidAmount +
                                    " where number ='" + choice.getSelectedItem() + "'"
                    );

                    RemainingAmt.setText(String.valueOf(remainingAmount));
                    addAmtField.setText("");

                    JOptionPane.showMessageDialog(null, "Amount added. Remaining: " + remainingAmount);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("BACK");
        Back.setBounds(290,290,120,30);
        Back.setBackground(Color.ORANGE);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PatientDischarge();
    }
}
