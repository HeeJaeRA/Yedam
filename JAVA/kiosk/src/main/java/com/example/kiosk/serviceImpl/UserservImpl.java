package com.example.kiosk.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.kiosk.common.DataSource;
import com.example.kiosk.service.UserServ;
import com.example.kiosk.service.UserVO;

public class UserservImpl implements UserServ {
	private Scanner sc = new Scanner(System.in);
	private DataSource dao = DataSource.getInstance(); // DAO
	private Connection conn;
	private PreparedStatement psmt;
	
	private void close() {
		try {
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<UserVO> selectListUser() {
		List<UserVO> products = new ArrayList<>();
		UserVO vo;
		String sql = "SELECT * FROM PRODUCT ORDER BY PRODUCT_KEY";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new UserVO();
				vo.setProductType(rs.getString("PRODUCT_TYPE"));
				vo.setProductName(rs.getString("PRODUCT_NAME"));
				vo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				vo.setProductKcal(rs.getInt("PRODUCT_KCAL"));
				products.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}
	
	@Override
	public List<UserVO> orderList() {
		List<UserVO> products = new ArrayList<>();
		
		int priceSum = 0;
		int kcalSum = 0;
		
		UserVO vo;
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME = ?" ;
		String orderP = sc.nextLine();
		System.out.print("수량> ");
		int orderN = Integer.parseInt(sc.nextLine());
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, orderP);
			ResultSet rs = psmt.executeQuery();			
						
			while (rs.next()) {
				vo = new UserVO();
				vo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				vo.setProductKcal(rs.getInt("PRODUCT_KCAL"));
				products.add(vo);
				for(int i = 0; i < orderN; i++) {
					priceSum += vo.getProductPrice();
					kcalSum += vo.getProductKcal();
				}
			}
			
			System.out.printf("총 주문금액: %d원 총 칼로리: %dKcal\n", priceSum, kcalSum);
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}
	
	@Override
	public List<UserVO> productList() {
		List<UserVO> products = new ArrayList<>();
		UserVO vo;
		String sql = "SELECT * FROM PRODUCT ORDER BY PRODUCT_KEY";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new UserVO();
				vo.setProductName(rs.getString("PRODUCT_NAME"));
				vo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				products.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}


}
