package prob;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class swing extends JFrame implements ActionListener{
	public swing()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel heading=new JLabel("	                            CRM SYSTEM ");
		heading.setHorizontalTextPosition(JLabel.CENTER);
		heading.setBounds(0,0,20041200,60);
		heading.setFont(new Font("serif",Font.ITALIC,60));
		heading.setForeground(Color.red);
		add(heading);
		
		ImageIcon i1=new ImageIcon("C:\\Users\\chait\\eclipse-workspace\\project\\src\\icons/front.jpg");
		Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(50,100,1050,500 );
		add(image);
		
		JButton clickhere=new JButton("CLICK HERE TO CONTINUE");
		clickhere.setBounds(400,400,300,70);
		clickhere.setBackground(Color.black);
		clickhere.setForeground(Color.white);
		clickhere.addActionListener(this);
		image.add(clickhere);
		
		setSize(1170,650);
		setLocation(200,50);
		setVisible(true);
		
		while(true) {
			heading.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
			heading.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
		}
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new swing1();
	}
	public static void main(String[] args) {
		new swing();
	}
}

