package com.example.kiosk.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	public List<UserVO> orderList(String uID) throws SQLException {
		List<UserVO> products = new ArrayList<>();
		
		String receipt = "";
		int priceSum = 0;
		int kcalSum = 0;
		
		LocalDateTime date = LocalDateTime.now();
		String now = date.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
		
		UserVO vo;
		
		String[] types = {"햄버거", "음료", "사이드"};
		
		for (int j = 0; j < types.length; j++) {
			System.out.printf("-----%s-----\n", types[j]);
			String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME = ?" ;
			System.out.print("제품명> ");
			String orderP = sc.nextLine();
			System.out.print("수량> ");
			String orderN = sc.nextLine();
			
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, orderP);
			ResultSet rs = psmt.executeQuery();			
			while (rs.next()) {
				vo = new UserVO();
				vo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				vo.setProductKcal(rs.getInt("PRODUCT_KCAL"));
				products.add(vo);
				for(int i = 0; i < Integer.parseInt(orderN); i++) {
					priceSum += vo.getProductPrice();
					kcalSum += vo.getProductKcal();
				}
				receipt += orderP + " " + orderN + "개" + "  ";
			}
			rs.close();
		}
		close();
		
		String sql = "UPDATE MEMBER SET MEMBER_ONUM = MEMBER_ONUM + 1, MEMBER_OPRICE = MEMBER_OPRICE + ? WHERE MEMBER_ID = ?";
		conn = dao.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, priceSum);
		psmt.setString(2, uID);
		psmt.executeUpdate();
		
		close();
		
		updateGrade(uID);
		
		System.out.println();
		System.out.println("-----주문내역-----");
		System.out.println(receipt);
		System.out.println("-----주문시간-----");
		System.out.println(now);
		System.out.println("----------------");
		System.out.printf("총 주문금액: %d원 총 칼로리: %dKcal\n", priceSum, kcalSum);
		System.out.println();
		
		return products;
	}

	
	@Override
	public List<UserVO> productList() {
		List<UserVO> products = new ArrayList<>();
		UserVO vo;
		String sql = "SELECT * FROM PRODUCT ORDER BY PRODUCT_TYPE DESC, PRODUCT_KEY";
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

	@Override
	public int updateGrade(String uID) {
		int n = 0;
		String sql1 = "UPDATE MEMBER SET MEMBER_GRADE = 'GREEN' WHERE MEMBER_ID = ? AND MEMBER_OPRICE >= 10000";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, uID);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		String sql2 = "UPDATE MEMBER SET MEMBER_GRADE = 'GOLD' WHERE MEMBER_ID = ? AND MEMBER_OPRICE >= 30000";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, uID);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}



}
