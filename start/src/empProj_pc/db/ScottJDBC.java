package empProj_pc.db;

import java.sql.*;

public class ScottJDBC {

	public ScottJDBC() {
		// 이 클래스를 new 시키는 순간 드라이버 자동 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println("### 드라이버 로딩 실패 ###");
		}
	}
	
	//커넥션 준비
	public Connection getCON() {
		Connection con = null;
		
		//정보 준비
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		//커넥션 연결
		try {
			con = DriverManager.getConnection(url, user, pw);
		} catch(Exception e) {}
		
		return con;
	}
	
	
	//stmt 준비
	public Statement getSTMT(Connection con) {
		
		Statement stmt = null;
		
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {}
		
		return stmt;
	}
	
	//pstmt
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {}
		
		return pstmt;
	}
	
	//사용하지 않는 자원 반환
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
