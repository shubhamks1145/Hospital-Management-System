package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class NewPatient extends JFrame implements ActionListener{

    JComboBox comboBox;
    JTextField textFieldNumber, textName,textFieldDisease,textFieldDeposite;
    JRadioButton r1,r2,r3;
    Choice c1;
    JLabel date;
    JButton b1,b2;

    NewPatient(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(230,247,245));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/Patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Aptos",Font.BOLD,20));
        labelName.setForeground(Color.darkGray);
        panel.add(labelName);
        //For Gov. Id
        JLabel labelID = new JLabel("Govt.ID:");
        labelID.setBounds(35,70,200,25);
        labelID.setFont(new Font("Aptos",Font.BOLD,20));
        labelID.setForeground(Color.GRAY);
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter ID","PAN Card","Driving License"});
        comboBox.setBounds(145,70,200,25);
        comboBox.setBackground(new Color(3,47,48));
        comboBox.setForeground(Color.GRAY);
        comboBox.setFont(new Font("Aptos",Font.BOLD,20));
        panel.add(comboBox);

        //For ID Number
        JLabel labelNumber = new JLabel("ID Number:");
        labelNumber.setBounds(35,105,200,25);
        labelNumber.setFont(new Font("Aptos", Font.BOLD,20));
        labelNumber.setForeground(Color.GRAY);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(145,105,200,25);
        panel.add(textFieldNumber);

        //For Name Section
        JLabel labelName1 = new JLabel("Name:");
        labelName1.setBounds(35,140,200,25);
        labelName1.setFont(new Font("Aptos",Font.BOLD, 20));
        labelName1.setForeground(Color.GRAY);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(145,140,200,25);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(35,170,200,25);
        labelGender.setFont(new Font("Aptos",Font.BOLD,20));
        labelGender.setForeground(Color.GRAY);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Aptos",Font.BOLD,20));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(3,47,48));
        r1.setBounds(145,175,200,25);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Aptos",Font.BOLD,20));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(3,47,48));
        r2.setBounds(145,205,200,25);
        panel.add(r2);

        r3 = new JRadioButton("Transgender");
        r3.setFont(new Font("Aptos",Font.BOLD,20));
        r3.setForeground(Color.white);
        r3.setBackground(new Color(3,47,48));
        r3.setBounds(145,235,200,25);
        panel.add(r3);

        JLabel labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(35,270,200,20);
        labelDisease.setFont(new Font("Aptos",Font.BOLD,20));
        labelDisease.setForeground(Color.GRAY);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(145,270,200,25);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room:");
        labelRoom.setFont(new Font("Aptos",Font.BOLD,20));
        labelRoom.setForeground(Color.GRAY);
        labelRoom.setBounds(35,300,90,20);
        panel.add(labelRoom);

        c1 = new Choice();
        try{
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from room where Availability != 'Occupied'");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(145,300,200,25);
        c1.setFont(new Font("Aptos",Font.BOLD,18));
        c1.setForeground(Color.GRAY);
        c1.setBackground(new Color(3,47,48));
        panel.add(c1);

        JLabel labelDate = new JLabel("Time:");
        labelDate.setBounds(35,330,200,20);
        labelDate.setFont(new Font("Aptos",Font.BOLD,20));
        labelDate.setForeground(Color.GRAY);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setForeground(Color.BLUE);
        date.setFont(new Font("Aptos",Font.BOLD,16));
        date.setBounds(145,330,250,25);
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposite:");
        labelDeposite.setBounds(35,360,200,20);
        labelDeposite.setFont(new Font("Aptos",Font.BOLD,20));
        labelDeposite.setForeground(Color.GRAY);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(145,360,200,25);
        panel.add(textFieldDeposite);

        b1 = new JButton ("ADD");
        b1.setBounds(35,400,100,25);
        b1.setForeground(Color.white);
        b1.setBackground(Color.ORANGE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(145,400,100,25);
        b2.setForeground(Color.white);
        b2.setBackground(Color.ORANGE);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            Connect c = new Connect();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN = "Male";
            }else if (r2.isSelected()){
                radioBTN = "Female";
            }else if (r3.isSelected()){
                radioBTN = "Transgender";
            }
            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try{
                String q = "insert into patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update Room set Availability = 'Occupied' where room_no ="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }


    }
    public static void main(String[] args){
        new NewPatient();
    }
}
