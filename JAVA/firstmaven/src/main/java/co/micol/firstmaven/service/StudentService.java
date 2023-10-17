package co.micol.firstmaven.service;

import java.util.List;

public interface StudentService {
	List<StudentVO> selectListStudent();	//전체 조회
	StudentVO selectStudent(StudentVO vo);	//개별 조회
	int insertStudent(StudentVO vo);		//학생 추가
	int updateStudent(StudentVO vo);		//학생 수정
	int deleteStudent(StudentVO vo);		//학생 삭제
	
	StudentVO loginStudent(StudentVO vo);
}
