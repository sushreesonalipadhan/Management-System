/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    Login() {

        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 20, 150, 150);
        add(l3);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600, 300);
        setLocation(400, 350);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                conn c1 = new conn();
                String user = t1.getText();
                String pass = t2.getText();

                String query = "select * from login where username= '" + user + "' and password= '" + pass + "'";

                ResultSet rs = c1.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login id or password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
//            setVisible(false);
            System.exit(0);

        }
    }

    public static void main(String[] arg) {
        new Login();
    }
}
