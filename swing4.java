package prob;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class swing4 extends JFrame implements ActionListener {

    JTextField tfEmpId, tfName, tfPhone, tfEmail;
    JButton delete, back;

    swing4() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);

        tfEmpId = new JTextField();
        tfEmpId.setBounds(200, 50, 150, 30);
        add(tfEmpId);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);

        tfName = new JTextField();
        tfName.setBounds(200, 100, 150, 30);
        add(tfName);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 150, 150, 30);
        add(tfPhone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 200, 150, 30);
        add(tfEmail);

        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);

        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            String empId = tfEmpId.getText();
            String name = tfName.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();

            try {
                File inputFile = new File("employee_details.txt");
                File tempFile = new File("employee_details_temp.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String currentLine;
                boolean found = false;

                while ((currentLine = reader.readLine()) != null) {
                   
                    String trimmedLine = currentLine.trim();
                    if (trimmedLine.contains("Employee ID: " + empId)) {
                        found = true;
                       
                        for (int i = 0; i < 10; i++) {
                            currentLine = reader.readLine();
                        }
                        continue;
                    }
                    writer.write(currentLine + System.getProperty("line.separator"));
                }

                writer.close();
                reader.close();

                if (found) {
                    inputFile.delete();
                    tempFile.renameTo(inputFile);
                    JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                } else {
                    tempFile.delete();
                    JOptionPane.showMessageDialog(null, "Employee ID Not Found");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new swing2();
        }
    }

    public static void main(String[] args) {
        new swing4();
    }
}
