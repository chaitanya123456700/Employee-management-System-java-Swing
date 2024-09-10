package prob;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class swing1 extends JFrame implements ActionListener {

    JTextField field, newss;

    public swing1() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel username = new JLabel("USER NAME");
        username.setBounds(40, 20, 100, 30);
        add(username);

        field = new JTextField();
        field.setBounds(150, 20, 150, 30);
        add(field);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(40, 70, 100, 30);
        add(password);

        newss = new JTextField();
        newss.setBounds(150, 70, 150, 30);
        add(newss);

        JButton login = new JButton("LOGIN");
        login.setBounds(40, 140, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        JButton reset = new JButton("RESET");
        reset.setBounds(150, 140, 150, 30);
        reset.setBackground(Color.black);
        reset.setForeground(Color.white);
        reset.addActionListener(this);
        add(reset);

        JButton createAccount = new JButton("CREATE ACCOUNT");
        createAccount.setBounds(40, 180, 260, 30); // Placed below the LOGIN and RESET buttons
        createAccount.setBackground(Color.black);
        createAccount.setForeground(Color.white);
        createAccount.addActionListener(this);
        add(createAccount);

        ImageIcon i1 = new ImageIcon("C:\\Users\\chait\\eclipse-workspace\\project\\src\\icons/second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        if (action.equals("LOGIN")) {
            String username = field.getText();
            String password = newss.getText();
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_credentials.txt", true))) {
                writer.write("Username: " + username + ", Password: " + password);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            setVisible(false);
            new swing2();
        } else if (action.equals("CREATE ACCOUNT")) {
            String name = JOptionPane.showInputDialog(this, "Enter Name:");
            String age = JOptionPane.showInputDialog(this, "Enter Age:");
            String email = JOptionPane.showInputDialog(this, "Enter Email:");
            String password = JOptionPane.showInputDialog(this, "Enter Password:");
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_credentials.txt", true))) {
                writer.write("Name: " + name + ", Age: " + age + ", Email: " + email + ", Password: " + password);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (action.equals("RESET")) {
            String email = JOptionPane.showInputDialog(this, "Enter Email:");
            String newPassword = JOptionPane.showInputDialog(this, "Enter New Password:");
            
            File inputFile = new File("user_credentials.txt");
            File tempFile = new File("temp_user_credentials.txt");
            
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                String line;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("Email: " + email + ",")) {
                        String[] parts = line.split(", ");
                        parts[3] = "Password: " + newPassword;
                        writer.write(String.join(", ", parts));
                        writer.newLine();
                        found = true;
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(this, "Email not found.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            }
        }
    }

    public static void main(String[] args) {
        new swing1();
    }
}
	