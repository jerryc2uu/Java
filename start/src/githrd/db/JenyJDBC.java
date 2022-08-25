package githrd.db;
/*
 	이 클래스는 JENNIE 계정으로 데이터베이스 작업할 경우

 	필요한 드라이버 로딩, 커넥션, statement 반환
 * @author 박소연
 * @since 2022.04.15
 * @version v.1.0
 */
import java.sql.*;

public class JenyJDBC {
	//여기 만드는 변수는 heap에 올라가고 기본데이터 타입은 0으로 그외는 null로 자동초기화 된다.
	public JenyJDBC() {
		//이 클래스가 new 될 때 드라이버 로딩도 끝나야 한다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println("### 드라이버 로딩 실패 ###");
		}	
	}
	
	//DB 작업 위해 접속 필요할 때 커넥션 만들어서 반환해주는 함수
	public Connection getCon() {
		Connection con = null;//선언만 하면 기억하고 있는 게 없다. 반환해줄 수가 없음..
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jennie";
		String pw = "12345";
		try {
			con = DriverManager.getConnection(url, user, pw);
		} catch(Exception e) {}
		return con;
	}
	
	public Connection getCon(String user, String pw) {
		Connection con = null;//선언만 하면 기억하고 있는 게 없다. 반환해줄 수가 없음..
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		//오버로딩 : 함수이름 같고, 매개변수 다르고, 반환값 상관 없음
		try {
			con = DriverManager.getConnection(url, user, pw);
		} catch(Exception e) {}
		return con;
	}
	
	// Statement 반환 함수
	public Statement getStmt(Connection con) {
		Statement stmt = null;
		
		try {
			//걍 외우세요..
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {}
		return stmt;
	}
	
	// PreparedStatement 반환 함수
	public PreparedStatement getPstmt(Connection con, String sql) {
		PreparedStatement pstmt = null;
		
		try {
			//걍 외우세요..
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {}
		return pstmt;
	}

	//사용 않는 자원 반환 함수
	public void close(Object o) {
		try {
			if(o instanceof Connection) {
				//입력된 데이터가 커넥션 타입인가?
				((Connection) o).close();
				/*
				 	(Connection) o.close(); o의 멤버인 close() 호출한 결과를 Connection으로 강제형변환
				 */
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
