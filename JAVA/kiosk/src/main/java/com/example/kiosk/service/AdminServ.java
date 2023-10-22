package com.example.kiosk.service;

import java.util.List;

public interface AdminServ {
	
	int insertProduct(AdminVO vo);
	
	int updateProduct(AdminVO vo);
	
	int deleteProduct(AdminVO vo);
	
	List<AdminVO> selectListAdmin();
	
}
