package com.example.kiosk.menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import com.example.kiosk.common.login.LoginPanel;

public class UserMenuPanel implements ActionListener {
	JFrame frame;
	JMenuBar bar;
	JMenu mu;
	JMenuItem it;
	
	public UserMenuPanel() {
		frame = new JFrame("User Page");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(800, 900);
		frame.setLocationRelativeTo(null);
		
		bar = new JMenuBar();
		mu = new JMenu("메뉴");
		it = new JMenuItem("로그아웃");
		
		mu.add(it);
		bar.add(mu);
		frame.setJMenuBar(bar);
		
		it.addActionListener(this);
		
		
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 자동 생성된 메소드 스텁
		Object obj = e.getSource();
		String str = e.getActionCommand();
		
		if (str.equals("로그아웃")) {
			frame.dispose();
			new LoginPanel();
		}
		
	}
	
}
