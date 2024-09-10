package prob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class swing6 extends JFrame implements ActionListener {

    JTextField tfItemNo, tfItemName;
    JButton delete, back;

    swing6() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Remove Item");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelItemNo = new JLabel("Item No");
        labelItemNo.setBounds(50, 150, 100, 30);
        labelItemNo.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelItemNo);

        tfItemNo = new JTextField();
        tfItemNo.setBounds(200, 150, 150, 30);
        add(tfItemNo);

        JLabel labelItemName = new JLabel("Item Name");
        labelItemName.setBounds(50, 200, 100, 30);
        labelItemName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelItemName);

        tfItemName = new JTextField();
        tfItemName.setBounds(200, 200, 150, 30);
        add(tfItemName);

        delete = new JButton("Remove Item");
        delete.setBounds(80, 300, 150, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(250, 300, 150, 30);
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
            String itemNo = tfItemNo.getText();
            String itemName = tfItemName.getText();

            try {
                File inputFile = new File("item_details.txt");
                File tempFile = new File("item_details_temp.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String currentLine;
                boolean found = false;

                while ((currentLine = reader.readLine()) != null) {
                    if (currentLine.contains("Item No: " + itemNo)) {
                        found = true;
                        // Skip the lines associated with this item number
                        for (int i = 0; i < 3; i++) {
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
                    JOptionPane.showMessageDialog(null, "Item Removed Successfully");
                } else {
                    tempFile.delete();
                    JOptionPane.showMessageDialog(null, "Item No Not Found");
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
        new swing6();
    }
}
