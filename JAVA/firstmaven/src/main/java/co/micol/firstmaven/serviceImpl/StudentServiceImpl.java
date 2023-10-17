package co.micol.firstmaven.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.firstmaven.common.DataSource;
import co.micol.firstmaven.service.StudentService;
import co.micol.firstmaven.service.StudentVO;

public class StudentServiceImpl implements StudentService {
	private DataSource dao = DataSource.getInstance(); // DAO 생성
	private Connection conn; // DB connection
	private PreparedStatement psmt; // SQL문 전달, 실행, 결과 리턴
	
	private void close() {
		try {
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StudentVO> selectListStudent() {
		// 전체 조회
		List<StudentVO> students = new ArrayList<>();
		StudentVO vo;
		String sql = "SELECT * FROM STUDENT";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery(); // SQL - SELECT문 실행 결과
			
			while(rs.next()) {
				vo = new StudentVO();
				vo.setStudentId(rs.getString("STUDENT_ID"));
				vo.setStudentName(rs.getString("STUDENT_NAME"));
				vo.setStudentPassword(rs.getString("STUDENT_PASSWORD"));
				vo.setStudentDept(rs.getString("STUDENT_DEPT"));
				vo.setStudentBirthday(rs.getDate("STUDENT_BIRTHDAY"));
				
				students.add(vo);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return students;
	}

	@Override
	public StudentVO selectStudent(StudentVO vo) {
		// TODO 자동 생성된 메소드 스텁
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setStudentId(rs.getString("STUDENT_ID"));
				vo.setStudentName(rs.getString("STUDENT_NAME"));
				vo.setStudentDept(rs.getString("STUDENT_DEPT"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertStudent(StudentVO vo) {
		int n = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			psmt.setString(2, vo.getStudentName());
			psmt.setString(3, vo.getStudentPassword());
			psmt.setString(4, vo.getStudentDept());
			psmt.setDate(5, vo.getStudentBirthday());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int updateStudent(StudentVO vo) {
		int n = 0;
		String sql = "UPDATE STUDENT "
				+ "SET STUDENT_NAME = ?, STUDENT_PASSWORD = ?, STUDENT_DEPT = ?, STUDENT_BIRTHDAY = ? WHERE STUDENT_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);			
			psmt.setString(1, vo.getStudentName());
			psmt.setString(2, vo.getStudentPassword());
			psmt.setString(3, vo.getStudentDept());
			psmt.setDate(4, vo.getStudentBirthday());
			psmt.setString(5, vo.getStudentId());			
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int deleteStudent(StudentVO vo) {
		int n = 0;
		String sql = "DELETE FROM STUDENT WHERE STUDENT_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public StudentVO loginStudent(StudentVO vo) {
		// TODO 자동 생성된 메소드 스텁
		String sql = "SELECT * FROM STUDENT "
				+ "WHERE STUDENT_ID = ? AND STUDENT_PASSWORD = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			psmt.setString(2, vo.getStudentPassword());
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setStudentId(rs.getString("STUDENT_ID"));
				vo.setStudentName(rs.getString("STUDENT_NAME"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

}
