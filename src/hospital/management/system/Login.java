package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    Login() {
        JLabel namelabel = new JLabel("Username:");
        namelabel.setBounds(100, 40, 100, 50);
        namelabel.setFont(new Font("Aptos", Font.BOLD, 16));
        namelabel.setForeground(Color.WHITE);
        add(namelabel);

        JLabel password = new JLabel("Password:");
        password.setBounds(100, 50, 100, 125);
        password.setFont(new Font("Aptos", Font.BOLD, 16));
        password.setForeground(Color.WHITE);
        add(password);

        textField = new JTextField();
        textField.setBounds(200, 55, 150, 30);
        textField.setFont(new Font("Aptos", Font.PLAIN, 16));
        textField.setBackground(new Color(50, 168, 149));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(200, 97, 150, 30);
        jPasswordField.setFont(new Font("Aptos", Font.PLAIN, 16));
        jPasswordField.setBackground(new Color(50, 168, 149));
        add(jPasswordField);

        JLabel medcare = new JLabel("MEDCARE");
        medcare.setBounds(490, 60, 400, 200);
        medcare.setFont(new Font("Aptos", Font.BOLD, 25));
        medcare.setForeground(Color.WHITE);
        add(medcare);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(350, 10, 400, 200);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(100, 150, 110, 30);
        b1.setFont(new Font("Aptos", Font.BOLD, 15));
        b1.setBackground(Color.MAGENTA);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(240, 150, 110, 30);
        b2.setFont(new Font("Aptos", Font.BOLD, 15));
        b2.setBackground(Color.MAGENTA);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(50, 104, 168));
        setSize(750, 300);
        setLocation(375, 275);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            try {
                Connect c = new Connect();
                String user = textField.getText();
                String Pass = jPasswordField.getText();

                String q = "select * from Login where ID = '" + user + "' and PW ='" + Pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }


            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            System.exit(10);

        }
    }
}


