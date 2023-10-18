package com.example.kiosk.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.kiosk.common.DataSource;
import com.example.kiosk.service.UserServ;
import com.example.kiosk.service.UserVO;

public class UserservImpl implements UserServ {
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
		String sql = "SELECT * FROM PRODUCT";
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


}
