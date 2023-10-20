package com.example.kiosk.menu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.example.kiosk.common.login.LoginPanel;

public class AdminMenuPanel extends JFrame{
	
	private JPanel contentPane;

	public AdminMenuPanel() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(600, 150, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btSel = new JButton("전체 조회");
		btSel.setBounds(101, 113, 579, 85);
		contentPane.add(btSel);
		
		
		JButton btInsert = new JButton("상품 추가");
		btInsert.setBounds(101, 254, 173, 85);
		contentPane.add(btInsert);
		
		
		JButton btUpdate = new JButton("상품 수정");
		btUpdate.setBounds(306, 254, 173, 85);
		contentPane.add(btUpdate);
		
		
		JButton btDelete = new JButton("상품 삭제");
		btDelete.setBounds(507, 254, 173, 85);
		contentPane.add(btDelete);
		
		
		setVisible(true);
		
		JMenuBar bar = new JMenuBar();
		JMenu mu = new JMenu("메뉴");
		JMenuItem item = new JMenuItem("로그아웃");
		
		mu.add(item);
		bar.add(mu);		
		setJMenuBar(bar);
		
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				String str = e.getActionCommand();
				
//				if (obj == bt_C) ad.insert();
//				if (obj == bt_R) ad.selectAllProduct();
//				if (obj == bt_U) ad.update();
//				if (obj == bt_D) ad.delete();
				
				if (str.equals("로그아웃")) {
					dispose();
					new LoginPanel();
				}
			}
		});
		
		
		
	}
	
}
