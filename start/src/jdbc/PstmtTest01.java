package jdbc;
//데이터베이스 연결된 모든 클래스는 아래 패키지 안에..
import java.sql.*;
import java.util.*;
/*
 	이 클래스는 
 	오라클에 있는 emp 테이블에서 부서번호가 ?? 번인 사원들의 정보를 조회해서 출력해주는 기능을 가진 클래스 
 	따라서 이 클래스는 객체가 되는 순간 데이터베이스에 연결할 준비가 되어 있어야 한다.
 	==> 드라이버 로딩이 끝나야 한다는 뜻
	
 */
public class PstmtTest01 {
	//사용할 변수
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs; //select 질의명령에선 무조건 만들어지는 변수
	
	public PstmtTest01() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 부서 번호를 입력하세요! : ");
		int dno = sc.nextInt();
		
		try {
			// 작업 순서
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 커넥션 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			//위 명령이 정상적으로 실행되면 오라클에서 세션 하나를 확보한 상태
			
			//3. 질의명령 준비
			StringBuffer buff = new StringBuffer();
			buff.append("SELECT ");
			buff.append("	empno eno, ename, job, mgr, TO_CHAR(hiredate, 'YYYY/MM/dd') hdate, deptno dno ");
			buff.append("FROM ");
			buff.append("	emp ");
			buff.append("WHERE ");
			buff.append("	deptno = ? ");
			
			String sql = buff.toString();
			
			//4. 질의명령 전달할 도구 준비
			/*
			 	Statement
			 	==> 프로그램에서 JDBC로 명령을 전달하는 도구
			 		이 때 사용해야 하는 질의명령은 완벽한 질의명령이어야 한다.
				
				우리의 경우는 매번 부서 번호를 정해서 바꿔야 하는 불완전한 질의명령
				이럴 때 사용하는 명령 전달 도구로 PreparedStatement가 있다.
			 	
			 	질의명령이 미리 셋팅되어야 해서 질의명령이 필요하다.
			 */
			pstmt = con.prepareStatement(sql);
			//명령 전달 도구는 준비가 되어 있지만 도구 안에 셋팅된 질의명령은 아직 완벽한 질의명령은 아니다.
			//따라서 질의명령을 완벽하게 만들어 줘야 한다.
			//완벽한 질의명령으로 만드는 방법은 ? 에 정확한 데이터를 채워주면 된다.
			/*
			 	불완전한 질의명령(? 있는 질의명령)에 데이터를 채우는 방법
			 		
			 		문자열인 경우 
			 			pstmt.setString(위치값, 데이터);
			 		정수(int)인 경우
			 			pstmt.setInt(위치값, 데이터);
			 		...
			 		
			 		이 때 위치값은 문제열 중에서 ?의 순서를 의미하고 
			 		시작값은 1부터 시작한다.(데이터베이스니까)
			 		
			 */
			pstmt.setInt(1, dno);
			
			//질의명령이 완성이 됐으므로 JDBC에게 전달하고 결과를 받으면 된다.
			//ResultSet : 인라인 뷰 기억하는 클래스
			rs = pstmt.executeQuery();
			//몇 사람이 조회될 지 알 수 없으므로
			while(rs.next()) {
				//rs.next() : 작업 실행 줄을 한 줄 내려주는 함수. 이 때 꺼내올 데이터가 있으면 true 반환, 없으면(eof 이동) false 반환
				
				//각 사원의 데이터 꺼내고
				int eno = rs.getInt(1);
				String name = rs.getString(2);
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hdate = rs.getString("hdate");
				dno = rs.getInt("dno");
				
				//출력
				System.out.printf("%5d - %15s - %10s - %5d - %10s - %4d\n", eno, name, job, mgr, hdate, dno);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {}
		}
		
		
	}

	public static void main(String[] args) {
		new PstmtTest01();
	}

}
