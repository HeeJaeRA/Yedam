package com.example.kiosk.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.kiosk.common.DataSource;
import com.example.kiosk.service.MemberServ;
import com.example.kiosk.service.MemberVO;

public class MemberImpl implements MemberServ {
	
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
	public List<MemberVO> loginMemeber() {
		List<MemberVO> members = new ArrayList<>();
		MemberVO vo;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setMemberPw(rs.getString("MEMBER_PW"));
				vo.setMemberOnumber(rs.getInt("MEMBER_ONUM"));
				vo.setMemberOprice(rs.getInt("MEMBER_OPRICE"));
				members.add(vo);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return members;
	}


	@Override
	public int joinMember(MemberVO vo) {
		int n = 0;
		String sql = "INSERT INTO MEMBER VALUES(?, ?)";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPw());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("");
		} finally {
			if (n != 0) {
				System.out.println("회원가입이 완료되었습니다.\n");
			}
		}
		return n;
	}

	@Override
	public int updateMember(MemberVO vo) {
		int n = 0;
		String sql = "UPDATE MEMBER SET MEMBER_PW = '0000' WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("");
		} finally {
			if (n != 0) {
				System.out.printf("%s 회원의 비밀번호가 초기화 되었습니다.\n", vo.getMemberId());
			} else {
				System.out.println("ID가 존재하지 않습니다.");
			}
		}
		return n;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		int n = 0;
		String sql = "DELETE MEMBER WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("");
		} finally {
			if (n != 0) {
				System.out.printf("%s 회원정보가 삭제되었습니다.\n", vo.getMemberId());
			} else {
				System.out.println("ID가 존재하지 않습니다.");
			}
		}
		return n;
	}

}
