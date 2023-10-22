package com.example.kiosk.service;

import java.sql.SQLException;
import java.util.List;

public interface UserServ {
	
	List<UserVO> selectListUser();
	
	List<UserVO> orderList(String uID) throws SQLException;
	
	List<UserVO> productList();
	
}

