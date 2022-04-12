package empPorj.db;
/*
  	필요한 곳에서 new 시켜서 사용하는 클래스라서 메인함수 불필요
  	스스로 new될 필요 없음
  	
  	이 클래스는 오라클의 scott 계정으로 JDBC 작업을 할 때 필요한 scott 전용 부품을 만든다.
  	
  	어제까지 작업 내용을 보면 반복적인 작업이 많다.
  	편리하도록 나만의 부품을 만들어서 사용 
 */
import java.sql.*;
public class ScottJDBC {

	/*
	 	이 클래스를 사용하려면 new 명령으로 인스턴스를 만들 것
	 	이 때 생성자 함수가 호출되는데 그 순간에 오라클 드라이버 로딩을 자동으로 하면 편할 것
	 */
	public ScottJDBC() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		} catch(Exception e) {
			System.out.println("### 드라이버 로딩 실패 ###");
		} 
	}
	
	// 누군가 오라클 세션을 요구하면 대신 접속해서 커넥션을 반환해주는 함수
	public Connection getCON() {
		//반환값 변수
		Connection con = null;
		
		//커넥션에 필요한 정보 준비
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		//커넥션 연결
		try {
			con = DriverManager.getConnection(url, user, pw);
		} catch(Exception e) {}
		
		//커넥션 반환
		return con;
	}
	
	//명령 전달 도구 요구하면 준비해서 반환해주는 함수
	public Statement getSTMT(Connection con) {
		//반환값 변수
		Statement stmt = null;//변수 선언만 해주면 return에서 에러남.. heap에 만들어지는 것만 자동 초기화됨
		
		//명령 전달 도구 준비
		try {
			//양방향(위아래) Statement
			//인터페이스의 변수는 무조건 상수(public static final), 함수는 추상함수
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//완벽한 질의명령이라서 sql 불필요
			
			/*
			 	<양방향 이동가능한 statement 만들기>
			 	
			 		ResultSet의 Type
			 		
			 			1. TYPE_FORWARD_ONLY		: scroll 불가능한 전방향 전용
 			 			2. TYPE_SCROLL_INSENSITIVE  : scroll 가능하나 변경 사항 적용 불가능
			 			3. TYPE_SCROLL_SENSITIVE    : scroll 가능하고 변경 사항 적용 가능
			 		
			 		CONCURRENCY의 TYPE
			 			
			 			1. CONCUR_READ_ONLY : ResultSet 객체 변경 불가
			 			2. CONCUR_UPDATABLE : ResultSet 객체 변경 가능
			 			
			 		결과값을 ResultSet에 담을 때 그 결과값이 바뀌지 않도록..
			 */
		} catch(Exception e) {}//반환해줘야 하니까 finally로 닫으면 안 됨
		
		//반환
		return stmt;
	}
	
	//PreparedStatement 준비해서 반환해주는 함수
	public PreparedStatement getPSTMT(Connection con, String sql) {
		
		//반환값 변수
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {}
		return pstmt;
	}
	
	//사용하지 않는 자원을 반환해주는 함수
	public void close(Object o) {//어떤 데이터 타입이 입력될지 모르므로 Object 타입
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
