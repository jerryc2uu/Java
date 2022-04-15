package empProj_pc.db;

import java.sql.*;
public class ScottJDBC {

	//1. 오라클 드라이버 자동 로딩
	public ScottJDBC() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println("### 드라이버 로딩 실패 ###");
		}
	}
	
	//2. 오라클 세션 반환
	public Connection getCON() {
		
		// 반환값 변수
		Connection con = null;
		// 필요 정보 준비
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "12345";
		
		//커넥션 반환
		return con;
	}
	
	//3. Statement 반환
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		
		try {
			//양방향 이동가능한 Statement
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//532번째줄..???
		} catch(Exception e) {}
		return stmt;
	}
	
	//4. PreparedStatement 반환 
	public PreparedStatement getPSTMT(Connection con, String sql) {
		
		//반환값
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
		} catch(Exception e) {}
		
		return pstmt;
	}

	//5. 사용하지 않는 자원 반환
	public void close(Object o) {
		try {
			if(o instanceof Connection) {
				((Connection) o).close();
			} else if(o instanceof Statement) {
				((Statement) o).close();
			} else if(o instanceof PreparedStatement) {
				((PreparedStatement) o).close();
			} else if(o instanceof ResultSet) {
				((ResultSet) o).close();
			}
		} catch(Exception e) {}
	}
	

}
