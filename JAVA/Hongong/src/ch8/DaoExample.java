package ch8;

public class DaoExample {
	
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		dbWork(new OracleDao());
		dbWork(new MysqlDao());
		
	}

}
