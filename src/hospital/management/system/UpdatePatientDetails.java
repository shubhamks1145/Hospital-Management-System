package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;


public class UpdatePatientDetails extends JFrame {
    UpdatePatientDetails(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(128,128,175));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/Update.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,50,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(100,25,222,25);
        label1.setFont(new Font("Aptos",Font.BOLD,25));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(40,80,80,25);
        label2.setFont(new Font("Aptos",Font.BOLD,20));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(120,80,150,25);
        panel.add(choice);

        try{
            Connect c =new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(40,120,120,25);
        label3.setFont(new Font("Aptos",Font.BOLD,15));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time");
        label4.setBounds(40,140,80,25);
        label4.setFont(new Font("Aptos",Font.BOLD,20));
        label4.setForeground(Color.white);
        panel.add(label4);



        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }
    public static void main(String[] args) {

        new UpdatePatientDetails();
    }
}
