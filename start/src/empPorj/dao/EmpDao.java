package empPorj.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import empPorj.db.*;
import empPorj.sql.*;
import empPorj.vo.EmpVO;

/*
 	이 클래스를 사용한다는 것은 new 시켜서 오라클에 접속해서 
 	scott 계정이 가지고 있는 테이블의 내용을 조회, 수정, 삭제하는 것 의미
 	따라서 이 클래스가 객체가 될 때는 오라클을 사용할 준비가 되어 있어야 한다.
 	드라이버 로딩 완료 상태여야...
 */
public class EmpDao {
	private ScottJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private EmpSQL eSQL;
	
	public EmpDao() {
		
		//이 순간 ScottJDBC의 인스턴스가 만들어지며, 오라클 드라이버를 로딩한 상태가 된다.	
		db = new ScottJDBC();
		
		
		//질의명령을 사용할 준비
		eSQL = new EmpSQL();
		
		
	}
	
	//1. 모든 사원의 정보를 조회해서 반환해주는 함수
	public ArrayList<EmpVO> getAll() {
		//할일
		//반환값 변수 만들고
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		//이미 드라이버 로딩은 끝난 상태이므로 커넥션을 꺼내온다.
		con = db.getCON();
		//질의명령 꺼내고
		String sql = eSQL.getSQL(eSQL.SEL_ALL);
		
		// 명령 전달 도구 준비
		stmt = db.getSTMT(con);
		
		try {
			//질의명령 보내고 결과 받고
			rs = stmt.executeQuery(sql);
			//데이터 추출해서 반환
			while(rs.next()) {
				//한 명의 데이터를 저장할 VO를 new 시키고..
				EmpVO eVO = new EmpVO();
				
				//데이터 꺼내고
				int eno = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("job");
				Date hdate = rs.getDate("hiredate");
				Time htime = rs.getTime("hiredate");
				
				//VO에 채우고
				eVO.setEno(eno);
				eVO.setEname(name);
				eVO.setJob(job);
				eVO.setHdate(hdate);
				eVO.setHtime(htime);
				eVO.setSdate();
				
				//VO 완성됐으므로 list에 채워준다.
				list.add(eVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
	
		return list;
	}
	
	//2. 부서번호를 입력받아서 부서원들의 정보를 반환해주는 함수
	public ArrayList<EmpVO> getDnoInfo(int dno) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();//이게 없으면 object 타입으로 자동 형변환이 돼 버림..
		
		//커넥션 꺼내고
		con = db.getCON();
		
		//질의명령 꺼내고
		String sql = eSQL.getSQL(eSQL.SEL_DNOINFO);
		
		//명령 전달 도구 준비
		pstmt = db.getPSTMT(con, sql);
		
		
		try {
			pstmt.setInt(1, dno);
			//질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			//데이터 추출해서 반환
			while(rs.next()) {
				//한 명의 데이터를 저장할 VO를 new 시키고..
				EmpVO eVO = new EmpVO();
				
				//데이터 꺼내고
				int eno = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("job");
				Date hdate = rs.getDate("hiredate");
				Time htime = rs.getTime("hiredate");
				int sal = rs.getInt("sal");
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				//VO에 채우고
				eVO.setEno(eno);
				eVO.setEname(name);
				eVO.setJob(job);
				eVO.setHdate(hdate);
				eVO.setHtime(htime);
				eVO.setSdate();
				eVO.setSal(sal);
				eVO.setDno(deptno);
				eVO.setDname(dname);
				eVO.setLoc(loc);
				
				//VO 완성됐으므로 list에 채워준다.
				list.add(eVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	//3. 직급을 입력받아서 해당직급 사원들의 정보를 반환해주는 함수
	public ArrayList<EmpVO> getJobInfo(String job) {
		//반환값 변수
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_JOBINFO);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, job);
			
			//질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			//데이터 추출해서 반환
			while(rs.next()) {
				//한 명의 데이터를 저장할 VO를 new 시키고..
				EmpVO eVO = new EmpVO();
				
				//데이터 꺼내고
				int eno = rs.getInt("empno");
				String name = rs.getString("ename");
				String jb = rs.getString("job");
				Date hdate = rs.getDate("hiredate");
				Time htime = rs.getTime("hiredate");
				int sal = rs.getInt("sal");
				int grade = rs.getInt("grade");
				int comm = rs.getInt("comm");
				String scomm = rs.getString("comm"); 
				
				//VO에 채우고
				eVO.setEno(eno);
				eVO.setEname(name);
				eVO.setJob(jb);
				eVO.setHdate(hdate);
				eVO.setHtime(htime);
				eVO.setSdate();
				eVO.setSal(sal);
				eVO.setGrade(grade);
				eVO.setComm(comm);
				eVO.setScomm(scomm);
				
				//VO 완성됐으므로 list에 채워준다.
				list.add(eVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		
		return list;
	}

}
