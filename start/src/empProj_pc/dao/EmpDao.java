package empProj_pc.dao;


import java.sql.*;
import java.sql.Date;
import java.util.*;

import empProj_pc.db.ScottJDBC;
import empProj_pc.sql.EmpSQL;
import empProj_pc.vo.EmpVO;

public class EmpDao {

	private ScottJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private EmpSQL eSQL;
	
	public EmpDao() {
		//드라이버 자동 로딩
		db = new ScottJDBC();
		eSQL = new EmpSQL();
	}
	
	//1. 모든 사원 정보 조회
	public ArrayList<EmpVO> getAll() {
		//반환값 변수
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		//커넥션
		con = db.getCON();
		//질의명령
		String sql = eSQL.getSQL(eSQL.SEL_ALL);
		//명령 전달 도구
		stmt = db.getSTMT(con);
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				EmpVO eVO = new EmpVO();
				
				int eno = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("job");
				Date hdate = rs.getDate("hiredate");
				Time htime = rs.getTime("hiredate");
				
				eVO.setEno(eno);
				eVO.setEname(name);
				eVO.setJob(job);
				eVO.setHdate(hdate);
				eVO.setHtime(htime);
				eVO.setSdate();
				
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
	
	//2. 부서 번호 리스트 조회
	public ArrayList<Integer> getDnoList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_DNOLIST);
		stmt = db.getSTMT(con);
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getInt("deptno"));
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
	
	//3. 부서 이름 리스트 조회
	public ArrayList<EmpVO> getDeptList() {
		//반환값 변수
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_DEPTLIST);
		stmt = db.getSTMT(con);
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				EmpVO eVO = new EmpVO();
				eVO.setDno(rs.getInt("deptno"));
				eVO.setDname(rs.getString("dname"));
				
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
	
	//4. 부서 번호 입력 받아서 부서원들 정보 조회
	public ArrayList<EmpVO> getDnoInfo(int dno) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_DNOINFO);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			
			pstmt.setInt(1, dno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				EmpVO eVO = new EmpVO();
				
				eVO.setEno(rs.getInt("empno"));
				eVO.setEname(rs.getString("ename"));
				eVO.setJob(rs.getString("job"));
				eVO.setHdate(rs.getDate("hiredate"));
				eVO.setHtime(rs.getTime("hiredate"));
				eVO.setSdate();
				eVO.setSal(rs.getInt("sal"));
				eVO.setDno(rs.getInt("deptno"));
				eVO.setDname(rs.getString("dname"));
				eVO.setLoc(rs.getString("loc"));
				
				list.add(eVO);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	
	//5. 직급 입력 받아서 사원들의 정보 조회
	public ArrayList<EmpVO> getJobInfo(String job) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_JOBINFO);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			
			while(rs.next()) {
				EmpVO eVO = new EmpVO();
				
				eVO.setEno(rs.getInt("empno"));
				eVO.setEname(rs.getString("ename"));
				eVO.setJob(rs.getString("job"));
				eVO.setHdate(rs.getDate("hiredate"));
				eVO.setHtime(rs.getTime("hiredate"));
				eVO.setSdate();
				eVO.setSal(rs.getInt("sal"));
				eVO.setGrade(rs.getInt("grade"));
				eVO.setComm(rs.getInt("comm"));
				
				list.add(eVO);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	
	//6. 모든 직급 리스트 조회
	public ArrayList<String> getAllJob() {
		ArrayList<String> list = new ArrayList<String>();
		
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_JOBLIST);
		stmt = db.getSTMT(con);
		
		try {
			while(rs.next()) {
				list.add(rs.getString("job"));
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
