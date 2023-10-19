package com.example.kiosk.common.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.example.kiosk.menu.AdminMenu;
import com.example.kiosk.menu.AdminMenuPanel;
import com.example.kiosk.menu.UserMenu;

class PWHandler implements ActionListener {
	
	JTextField id;
	JTextField pw;
	
	public PWHandler(JTextField id, JTextField pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ID: " +id.getText());
//		System.out.println("PW: " +pw.getText());
		id.setText(null);
		pw.setText(null);
	}
	
}

public class LoginPanel implements ActionListener {
	
	JButton bt1;
	JButton bt2;
	JTextField idText;
	JTextField pwText;
	JFrame frame;
	JOptionPane opt;
	
	public LoginPanel() {
		frame = new JFrame("Kiosk");
		frame.setBounds(770, 350, 230, 140);
		frame.setLayout(new GridLayout(2, 2));
		
		JLabel idLabel = new JLabel("               ID ", SwingConstants.RIGHT); 
		idText = new JTextField(10);
		
		JLabel pwLabel = new JLabel("Password ", SwingConstants.RIGHT);
		pwText =new JPasswordField(10); 
//		pwText.setEchoChar('*'); 
		
		pwText.addActionListener(new PWHandler(idText, pwText));
		
		bt1 = new JButton("로그인");
		bt2 = new JButton("종료");		
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.add(idLabel);
		p1.add(idText);
		p1.add(pwLabel);
		p1.add(pwText);
			
		p2.add(bt1);
		p2.add(bt2);
		
		frame.add(p1,BorderLayout.CENTER);
		frame.add(p2,BorderLayout.NORTH);
	
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == bt1){
			String a = idText.getText();
			String b = pwText.getText();
			if ((a.equals("admin") || a.equals("ADMIN")) && b.equals("0000")){
				frame.dispose();
//				System.out.println("관리자님 환영합니다");
//				AdminMenu adminMenu = new AdminMenu();
//				adminMenu.run();
				new AdminMenuPanel();
				
			} else {
				frame.dispose();
				System.out.printf("%s님 환영합니다.\n", a);
				UserMenu userMenu = new UserMenu();
				userMenu.run();
			}
		}
		if(obj == bt2){
			frame.dispose();
			System.out.println("프로그램 종료");
		}
	}
}
