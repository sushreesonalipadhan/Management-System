package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1;

    public HotelManagementSystem() {

        setSize(1440, 900);          // setContentPane(300,300,1366,390);   frame size
        setLayout(null);
        setLocation(5, 10);

        l1 = new JLabel("");
        b1 = new JButton("Next");

        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFont(new Font("serif", Font.BOLD, 20));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1440, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        JLabel lid = new JLabel("HOTEL MANAGEMENT SYSTEM");
        lid.setBounds(50, 300, 1440, 900);
        lid.setFont(new Font("serif", Font.PLAIN, 50));
        lid.setForeground(Color.white);
        l1.add(lid);

        b1.setBounds(1100, 720, 150, 50);
        l1.setBounds(0, 0, 1440, 900);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
        setVisible(true);

        while (true) {
            lid.setVisible(false); // lid =  j label
            try {
                Thread.sleep(500); //1000 = 1 second
            } catch (Exception e) {
            }
            lid.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        HotelManagementSystem window = new HotelManagementSystem();
        window.setVisible(true);
    }
}
