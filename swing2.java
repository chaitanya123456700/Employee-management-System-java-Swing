package prob;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swing2 extends JFrame implements ActionListener {
    JButton add, remove, prod1, prod2, logout;

    public swing2() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\chait\\eclipse-workspace\\project\\src\\icons\\home.jpg");
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("                 CRM SYSTEM");
        heading.setBounds(650, 20, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("ADD EMP");
        add.setBounds(650, 80, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        image.add(add);

        remove = new JButton("REMOVE EMP");
        remove.setBounds(870, 80, 150, 40);
        remove.setBackground(Color.black);
        remove.setForeground(Color.white);
        remove.addActionListener(this);
        image.add(remove);

        prod1 = new JButton("ADD ITEM");
        prod1.setBounds(650, 140, 150, 40);
        prod1.setBackground(Color.black);
        prod1.setForeground(Color.white);
        prod1.addActionListener(this);
        image.add(prod1);

        prod2 = new JButton("REMOVE ITEM");
        prod2.setBounds(870, 140, 150, 40);
        prod2.setBackground(Color.black);
        prod2.setForeground(Color.white);
        prod2.addActionListener(this);
        image.add(prod2);

        
        int logoutX = (650 + 75) + ((870 + 75) - (650 + 75)) / 2 - 75;
        int logoutWidth = 150;

        logout = new JButton("LOGOUT");
        logout.setBounds(logoutX, 200, logoutWidth, 40);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        image.add(logout);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            new swing3();
        } else if (ae.getSource() == remove) {
            new swing4();
        } else if (ae.getSource() == prod1) {
            new swing5();
        } else if (ae.getSource() == prod2) {
            new swing6();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new swing1(); 
        }
    }

    public static void main(String args[]) {
        new swing2();
    }
}
