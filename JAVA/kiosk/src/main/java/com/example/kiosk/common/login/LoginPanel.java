package com.example.kiosk.common.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.example.kiosk.menu.AdminMenuPanel;
import com.example.kiosk.menu.UserMenuPanel;

public class LoginPanel extends JFrame{
	
	private JPanel contentPane;
	private JButton bt1;
	private JButton bt2;
	private JTextField idText;
	private JPasswordField pwText;
	
	private static final String ID = "ADMIN";
	private static final String PW = "0000";
	
	public LoginPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 472, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel(" 아이디");
		idLabel.setBounds(108, 62, 54, 30);
		contentPane.add(idLabel);
		
		idText = new JTextField();
		idText.setBounds(193, 67, 150, 21);
		contentPane.add(idText);
		idText.setColumns(10);
		
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(108, 113, 54, 30);
		contentPane.add(pwLabel);
		
		pwText = new JPasswordField();
		pwText.setBounds(193, 118, 150, 21);
		contentPane.add(pwText);
		
		bt1 = new JButton("로그인");
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj == bt1){
					String id = idText.getText();
					String pw = pwText.getText();
					if (id.toUpperCase().equals(ID)){
						if (pw.equals(PW)) {
							dispose();
							JOptionPane.showMessageDialog(null, "관리자님 환영합니다.");
							new AdminMenuPanel();
						} else {
							JOptionPane.showMessageDialog(null, "로그인 실패");
						}
					} else if (id.length() > 1 && pw.length() > 3){
						dispose();
						JOptionPane.showMessageDialog(null, id + "님 환영합니다.");
						new UserMenuPanel();
					} else {
						JOptionPane.showMessageDialog(null, "로그인 실패");
					}
				}
			}
			
		});
		bt1.setBounds(108, 187, 105, 30);
		contentPane.add(bt1);
		
		bt2 = new JButton("종료");
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj == bt2){
					dispose();
				}
			}
		});
		bt2.setBounds(238, 187, 105, 30);
		contentPane.add(bt2);
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
