package empProj.dao;

/*
 	이 클래스는 JEmp 테이블에 관련된 데이터베이스 작업만 전담한다...
 	
 	이 클래스가 new 되는 순간 데이터베이스를 사용할 준비가 돼야 한다.
 */
import empProj.db.*;


import empProj.sql.*;
import empProj.vo.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;//util과 sql에 모두 Date가 있으니까 명시
public class JEmpDao {
	
	private ScottJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private JEmpSQL jSQL;
	
	public JEmpDao() {
		//ScottJDBC의 생성자 함수에서 드라이버를 로딩..
		db = new ScottJDBC();
		jSQL = new JEmpSQL();
	}
	
	//JEMP 테이블 생성 여부 조회 함수
	public int tabCnt() {
		//반환값 변수
		int cnt = 0;
		
		//할일
		//커넥션
		con = db.getCON();
		//질의명령
		String sql = jSQL.getSQL(jSQL.SEL_TNAME);
		//명령 전달 도구
		stmt = db.getSTMT(con);
		//질의명령 보내고 결과 받고
		try {
			rs = stmt.executeQuery(sql); //executeQuary : 변경된 행 수 반환
			//꺼내서 변수에 담고
			rs.next(); //가상 레코드 포인터 한 줄 내리고
			cnt = rs.getInt("cnt");			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		//반환
		return cnt;
	}

	//EMP 테이블 구조만 복사해서 JEMP 테이블 만드는 함수
	public void addJEmp() {
		//할일
		//커넥션 꺼내고
		con = db.getCON();
		//질의명령 꺼내고
		String sql = jSQL.getSQL(jSQL.ADD_TABLE);
		//명령 전달 도구 꺼내고
		stmt = db.getSTMT(con);
		//질의명령 보내고
		try {
			stmt.execute(sql);
			System.out.println("### JEmp 테이블 생성 완료 ###");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//rs는 select 질의명령에서만 생긴다.
			db.close(stmt);
			db.close(con);
		}
	}
	
	//이름, 직급, 부서번호 jemp 테이블에 추가해주는 함수
	public int insertJEMP(EmpVO eVO) {
		//할일
		//반환값 변수
		int cnt = 0;
		//커넥션
		con = db.getCON();
		//질의명령
		String sql = jSQL.getSQL(jSQL.INSERT_JEMP);
		//명령 전달 도구
		pstmt = db.getPSTMT(con, sql);
		try {
			//질의명령 완성
			String name = eVO.getEname();
			String job = eVO.getJob();
			int dno = eVO.getDno();
			
			pstmt.setString(1, name);
			pstmt.setString(2, job);
			pstmt.setInt(3, dno);
			//질의명령 보내고 [결과 받고]
			cnt = pstmt.executeUpdate();//반환값 타입 int, 변경된 행 수 : 1 or 0
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	//가장 최근 입사한 사원 조회 함수
	public EmpVO getLast() {//질의명령 완벽하므로 전달받아야 할 데이터도 없음
		//할일
		//반환값 변수
		EmpVO eVO = new EmpVO();
		//커넥션
		con = db.getCON();
		//질의명령
		String sql = jSQL.getSQL(jSQL.SEL_LAST);
		//명령 전달 도구
		stmt = db.getSTMT(con);
		try {
			//질의명령 보내고 결과 받고
			rs = stmt.executeQuery(sql);
			//꺼내서 VO에 채워주고
			//가상 레코드 포인터 한 줄 내리고
			rs.next();//begin of file, end of file
			//데이터 꺼내서 VO에 담고
			int eno = rs.getInt("eno");
			String name = rs.getString("name");
			String job = rs.getString("job");
			Date hdate = rs.getDate("hdate");
			Time htime = rs.getTime("hdate");
			int dno = rs.getInt("dno");
			
			//꺼낸 데이터 VO에 담고
			eVO.setEno(eno);
			eVO.setEname(name);
			eVO.setJob(job);
			eVO.setHdate(hdate);
			eVO.setHtime(htime);
			eVO.setSdate();
			eVO.setDno(dno);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		
		//데이터 반환
		return eVO;
	}
	
	//30번 부서 사원들 백업 전담 처리 함수
	public int backupDno30() {
		//할일
		//반환값 변수 : executeUdate() 반환값 타입 int, 변경된 행 수
		int cnt = 0;
		//커넥션
		con = db.getCON();
		//질의명령
		String sql = jSQL.getSQL(jSQL.INSERT_JEMP_D30);//백업임..
		//명령 전달 도구
		stmt = db.getSTMT(con);
		//질의명령 보내고 결과 받고
		try {
			cnt = stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(stmt);
			db.close(con);
		}
		//데이터 반환
		return cnt;
	}
	
	//30번 부서원 삭제 전담 처리 함수
	public int delDno30() {
		//할일
		//반환값 변수 만들고
		int cnt = 0;
		//커넥션
		con = db.getCON();
		//질의명령
		String sql = jSQL.getSQL(jSQL.DEL_JEMP_D30);
		//명령전달도구
		stmt = db.getSTMT(con);
		//질의명령 보내고 결과 받고
		try {
			cnt = stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(stmt);
			db.close(con);
		}
		//결과 내보내고
		return cnt;
	}
}
