package com.example.kiosk.menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.example.kiosk.common.login.LoginPanel;

public class AdminMenuPanel implements ActionListener{
	
	AdminMenu ad = new AdminMenu();
	
	JFrame frame;
	JButton bt_C;
	JButton bt_R;
	JButton bt_U;
	JButton bt_D;
		
	public AdminMenuPanel() {
		frame = new JFrame("Admin Page");
		frame.setBounds(550, 100, 650, 500);
		frame.setLayout(new FlowLayout());
		
		JMenuBar bar = new JMenuBar();
		JMenu mu = new JMenu("메뉴");
		JMenuItem item = new JMenuItem("로그아웃");
		
		mu.add(item);
		bar.add(mu);		
		frame.setJMenuBar(bar);
		
		item.addActionListener(this);
		
		JPanel panRead = new JPanel();
		bt_R = new JButton();
		
		frame.add(panRead);
		panRead.add(bt_R);
		
		panRead.setPreferredSize(new Dimension(300, 200));
		bt_R.setPreferredSize(new Dimension(200, 100));
		
		bt_R.addActionListener(this);
		
		JPanel panCreate = new JPanel();
		bt_C = new JButton();
		
		frame.add(panCreate);
		panCreate.add(bt_C);
		
		panCreate.setPreferredSize(new Dimension(300, 200));
		bt_C.setPreferredSize(new Dimension(200, 100));
		
		bt_C.addActionListener(this);
		
		JPanel panUpdate = new JPanel();
		bt_U = new JButton();
		
		frame.add(panUpdate);
		panUpdate.add(bt_U);
		
		panUpdate.setPreferredSize(new Dimension(300, 200));
		bt_U.setPreferredSize(new Dimension(200, 100));
		
		bt_U.addActionListener(this);
		
		JPanel panDelete = new JPanel();
		bt_D = new JButton();
		
		frame.add(panDelete);
		panDelete.add(bt_D);
		
		panDelete.setPreferredSize(new Dimension(300, 200));
		bt_D.setPreferredSize(new Dimension(200, 100));
		
		bt_R.addActionListener(this);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String str = e.getActionCommand();
		
//		if (obj == bt_C) ad.insert();
//		if (obj == bt_R) ad.selectAllProduct();
//		if (obj == bt_U) ad.update();
//		if (obj == bt_D) ad.delete();

		if (str.equals("로그아웃")) {
			frame.dispose();
			new LoginPanel();
		}
	}

}
