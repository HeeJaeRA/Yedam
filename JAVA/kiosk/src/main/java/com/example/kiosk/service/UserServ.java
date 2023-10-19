package com.example.kiosk.service;

import java.util.List;

public interface UserServ {
	
	List<UserVO> selectListUser();
	
	List<UserVO> orderList();
	
	List<UserVO> productList();
	
}
