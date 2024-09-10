package prob;
import java.awt.Font;
import java.awt.*;
import java.awt.Image;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class swing5 extends JFrame implements ActionListener {
    
    Random ran = new Random();
    int itemNumber = ran.nextInt(999999);
    
    JTextField tfItemName, tfItemNo, tfItemCost;
    JButton addItem, back;
    
    swing5() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Item");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelItemName = new JLabel("Item Name");
        labelItemName.setBounds(50, 150, 150, 30);
        labelItemName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelItemName);
        
        tfItemName = new JTextField();
        tfItemName.setBounds(200, 150, 150, 30);
        add(tfItemName);
        
        JLabel labelItemNo = new JLabel("Item No");
        labelItemNo.setBounds(400, 150, 150, 30);
        labelItemNo.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelItemNo);
        
        tfItemNo = new JTextField("" + itemNumber);
        tfItemNo.setBounds(600, 150, 150, 30);
        add(tfItemNo);
        
        JLabel labelItemCost = new JLabel("Item Cost");
        labelItemCost.setBounds(50, 200, 150, 30);
        labelItemCost.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelItemCost);
        
        tfItemCost = new JTextField();
        tfItemCost.setBounds(200, 200, 150, 30);
        add(tfItemCost);
        
        addItem = new JButton("Add Item");
        addItem.setBounds(250, 550, 150, 40);
        addItem.addActionListener(this);
        addItem.setBackground(Color.BLACK);
        addItem.setForeground(Color.WHITE);
        add(addItem);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addItem) {
            String itemName = tfItemName.getText();
            String itemNo = tfItemNo.getText();
            String itemCost = tfItemCost.getText();
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("item_details.txt", true))) {
                writer.write("Item No: " + itemNo);
                writer.newLine();
                writer.write("Item Name: " + itemName);
                writer.newLine();
                writer.write("Item Cost: " + itemCost);
                writer.newLine();
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new swing2();
        }
    }

    public static void main(String[] args) {
        new swing5();
    }
}
