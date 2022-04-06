package jdbc;

import java.sql.*;
import java.util.*;
import java.util.Date;// sql과 util 둘 다 date 있음. 어떤 패키지 안의 date인지 명시
import java.text.*;

/*
 	emp 테이블의 데이터를 조회하는데 
 	
 	dno라는 문자열을 입력받으면 부서번호를 입력받아서 
 		해당 부서의 부서원들의 사원번호, 사원이름, 직급, 입사일, 급여, 부서번호, 부서이름, 부서위치 출력해주고
 	
 	job이라는 문자열을 입력받으면 해당 직급을 가진 사원들의
 		사원번호, 사원이름, 직급, 입사일, 급여, 급여등급, 커미션 조회
 	
 	--------질의명령 안에 ?가 들어감. PreparedStatement
 	
 	all 입력받으면 
 		모든 사원들의 사원번호, 사원이름, 직급, 입사일 조회하는 프로그램 작성 
 	
 	--------? 없음. Statement
 	
 	질의명령의 결과가 jdbc로 왔을 때 인라인테이블이 만들어진다. ResultSet
 	
 	단, exit라는 단어가 입력되면 프로그램이 즉시 종료되게 하라
 */

/*
 	이 클래스는 사용자가 어떤 것을 입력하든지 결국 오라클을 사용할 준비가 돼야 한다.
 	따라서 이 클래스가 new 되는 순간 드라이버 로딩이 완료되면 편할 것
 */
public class JdbcTest01 {
	
	public final int SEL_ALL = 0;// final -> 데이터 수정 불가
	public final int SEL_DNOINFO = 1;
	public final int SEL_JOBINFO = 2;
	
	//작업에 필요한 변수 선언
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public JdbcTest01() {
		//드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			getInput();
		} catch(Exception e)  {
			System.out.println("### 서버 로딩 실패 ###");
		}
		
/*
		String sql1 = getSQL(SEL_ALL);
		System.out.println(sql1);
		
		String sql2 = getSQL(SEL_DNOINFO);
		System.out.println(sql2);
		
		String sql3 = getSQL(SEL_JOBINFO);
		System.out.println(sql3);

		System.out.println(getSQL(this.SEL_ALL));
		System.out.println(getSQL(this.SEL_DNOINFO));
		System.out.println(getSQL(this.SEL_JOBINFO));
 */
		
	}
	
	//1. 코드(정수) 입력받으면 그 코드에 해당하는 질의명령을 반환해주는 함수
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_ALL: 
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate "); 
			buff.append("FROM ");
			buff.append("	emp ");			
			break;
		case SEL_DNOINFO: 
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate, sal, e.deptno, dname, loc "); 
			buff.append("FROM ");
			buff.append("	emp e, dept d ");
			buff.append("WHERE ");
			buff.append("	e.deptno = d.deptno ");
			buff.append("	AND e.deptno = ? ");
			break;	
		case SEL_JOBINFO:
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate, sal, grade, NVL(TO_CHAR(comm), '커미션없음') comm "); 
			buff.append("FROM ");
			buff.append("	emp, salgrade ");
			buff.append("WHERE ");
			buff.append("	sal BETWEEN losal AND hisal ");
			buff.append("	AND job = ? ");
			break;
		}
		
		//buff에 담긴 내용 문자열로 변환해서 반환
		return buff.toString();
	}
	
	//2. 문자열 입력받는 함수
	public void getInput() {
		//Scanner 이용해서 문자열을 입력받고
		//각 문자열들마다 입력받을 내용도 다시 받아서 실행시켜주는 함수
		
		//작업순서
		
		//입력받을 준비
		Scanner sc = new Scanner(System.in);
		//메세지 출력
		System.out.print("부서번호로 조회 : dno\n직급으로 조회 : job\n모든 사원 조회 : all\n명령 입력 : ");
		String str = sc.nextLine();
		
		switch(str) {
		case "dno":
			getAll();
			break;
		case "job":
			getAll();
			break;
		case "all":
			getAll();
			break;
		
		}
		
	}
	
	//3. 모든 사원 정보 출력해주는 함수
	public void getAll() {
		//할일
		try {
			//이 함수에서는 데이터베이스에 연결해서
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";
			con = DriverManager.getConnection(url, user, pw);
			//질의명령 준비
			String sql = getSQL(SEL_ALL);
			//명령 전달 도구 준비
			stmt = con.createStatement();
			//질의명령을 보내고 결과를 받아서
			rs = stmt.executeQuery(sql); 
			//결과를 출력
			//몇 행을 꺼내왔는지 알 수 없으므로
			while(rs.next()) {
				//empno, ename, job, hiredate
				int eno = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("job");
				
				/*
				 	[참고]
				 		jdbc에서는 데이터베이스에서 날짜데이터를 꺼내올 때 날짜와 시간을 따로 꺼내오도록 
				 		함수를 분리해서 만들어놨다.
				 */
				
				//날짜데이터
				Date hdate = rs.getDate("hiredate"); // 날짜만 꺼내오는 함수
				//시간
				Time htime = rs.getTime("hiredate"); // 시간만 꺼내오는 함수, Date 상속 받은 Time 클래스.
				
				/*
				 	날짜데이터를 원하는 문자열로 바꿔주는 형식화 클래스
				 		
				 		SimpleDateFormat form = new SimpleDateFormat(날짜형식문자열);
						String sdate = form.format(hdate);
				 */
				SimpleDateFormat form1 = new SimpleDateFormat("YYYY년 MM월 dd일 ");
				SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss");
				String sdate = form1.format(hdate) + form2.format(htime);
				
				//출력
				System.out.printf("%5d | %10s | %10s | %24s\n", eno, name, job, sdate);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				//열린 자원 반환
				rs.close();
				stmt.close();
				con.close();
			} catch(Exception e) {} 
		}
	}
	
	
	public static void main(String[] args) {
		new JdbcTest01();
	}

}
