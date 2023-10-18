package com.example.kiosk.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.kiosk.common.DataSource;
import com.example.kiosk.service.AdminServ;
import com.example.kiosk.service.AdminVO;

public class AdminservImpl implements AdminServ {
	private DataSource dao = DataSource.getInstance(); // DAO
	private Connection conn;	// DB Connection
	private PreparedStatement psmt; 	// SQL
	
	private void close() {
		try {
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertProduct(AdminVO vo) {
		int n = 0;
		String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?)";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getProductKey());
			psmt.setString(2, vo.getProductType());
			psmt.setString(3, vo.getProductName());
			psmt.setInt(4, vo.getProductPrice());
			psmt.setInt(5, vo.getProductKcal());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (n != 0) {
				System.out.println("추가 완료");
			}
			close();
		}
		return n;
	}
	
	@Override
	public int updateProduct(AdminVO vo) {
		int n = 0;
		String sql = "UPDATE PRODUCT SET PRODUCT_NAME = ?, PRODUCT_PRICE = ?, PRODUCT_KCAL = ? WHERE PRODUCT_KEY = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductName());
			psmt.setInt(2, vo.getProductPrice());
			psmt.setInt(3, vo.getProductKcal());
			psmt.setInt(4, vo.getProductKey());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (n != 0) {
				System.out.println("수정 완료");
			}
			close();
		}
		return n;
	}
	
	@Override
	public int deleteProduct(AdminVO vo) {
		int n = 0;
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_NAME LIKE ?";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductName());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (n == 0) {
				System.out.println("없는 제품입니다.");				
			} else {
				System.out.println("삭제 완료");
			}
			close();
		}
		return n;
	}
	
	@Override
	public List<AdminVO> selectListAdmin() {
		List<AdminVO> products = new ArrayList<>();
		AdminVO vo;
		String sql = "SELECT * FROM PRODUCT";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new AdminVO();
				vo.setProductKey(rs.getInt("PRODUCT_KEY"));
				vo.setProductType(rs.getString("PRODUCT_TYPE"));
				vo.setProductName(rs.getString("PRODUCT_NAME"));
				vo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				vo.setProductKcal(rs.getInt("PRODUCT_KCAL"));				
				products.add(vo);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}
	
}
