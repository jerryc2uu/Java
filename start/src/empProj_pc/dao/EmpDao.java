package empProj_pc.dao;

import java.sql.*;

import java.util.*;

import empProj_pc.db.*;
import empProj_pc.sql.*;
import empProj_pc.vo.EmpVO;

public class EmpDao {
	
	private ScottJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private EmpSQL eSQL;
	
	public EmpDao() {
		db = new ScottJDBC();
		eSQL = new EmpSQL();
	}
	
	//모든 사원 정보 조회
	public ArrayList<EmpVO> getAll() {
		
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_ALL);
		stmt = db.getSTMT(con);
		
		try {
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				EmpVO eVO = new EmpVO();
				
				eVO.setEmpno(rs.getInt("empno"));
				eVO.setEname(rs.getString("ename"));
				eVO.setJob(rs.getString("job"));
				eVO.setHdate(rs.getDate("hiredate"));
				eVO.setHtime(rs.getTime("hiredate"));
				
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
	
	//부서번호 리스트 조회
	public ArrayList<Integer> getDnoList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_DNOINFO);
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
	
	//부서 리스트 조회
	public ArrayList<EmpVO> getDeptList() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_DEPTLIST);
		stmt = db.getSTMT(con);
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				EmpVO eVO = new EmpVO();
				eVO.setDeptno(rs.getInt("deptno"));
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
	
	//부서 번호 입력 받아서 부서원들 정보 조회
	public ArrayList<EmpVO> getDnoInfo(int deptno) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_DNOINFO);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setInt(1,  deptno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO eVO = new EmpVO();
				
				eVO.setEmpno(rs.getInt("empno"));
				eVO.setEname(rs.getString("ename"));
				eVO.setJob(rs.getString("job"));
				eVO.setHdate(rs.getDate("hiredate"));
				eVO.setHtime(rs.getTime("hiredate"));
				eVO.setSdate();
				eVO.setSal(rs.getInt("sal"));
				eVO.setDeptno(rs.getInt("deptno"));
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
	
	//직급 입력 받아서 사원들 정보 조회
	public ArrayList<EmpVO> getJobInfo(String job){
		// 반환값 변수
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		// Connection
		con = db.getCON();
		// sql
		String sql = eSQL.getSQL(eSQL.SEL_JOBINFO);
		
		// pstmt
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setString(1, job);
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// VO 만들고
				EmpVO evo = new EmpVO();
				
				// 데이터채우고
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				evo.setJob(rs.getString("job"));
				evo.setHdate(rs.getDate("hiredate"));
				evo.setHtime(rs.getTime("hiredate"));
				evo.setSdate();
				evo.setSal(rs.getInt("sal"));
				evo.setGrade(rs.getInt("grade"));
				evo.setScomm(rs.getString("comm"));
				
				// 리스트에 채우고
				list.add(evo);
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
	
	//모든 직급 조회
	public ArrayList<String> getAllJob(){
		ArrayList<String> list = new ArrayList<String>();
		
		// Connection
		con = db.getCON();
		// sql
		String sql = eSQL.getSQL(eSQL.SEL_JOBLIST);
		// stmt
		stmt = db.getSTMT(con);
		try {
			// 명령전달하고 결과받고
			rs = stmt.executeQuery(sql);
			// 꺼내서 리스트에 담고
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
	
	//사원번호 입력 받아서 사원 정보 조회
	public ArrayList<EmpVO> getEnoInfo(int empno) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		con = db.getCON();
		String sql = eSQL.getSQL(eSQL.SEL_ENOINFO);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO eVO = new EmpVO();
				
				eVO.setEmpno(rs.getInt("empno"));
				eVO.setEname(rs.getString("ename"));
				eVO.setJob(rs.getString("job"));
				eVO.setSal(rs.getInt("sal"));
				eVO.setHdate(rs.getDate("hiredate"));
				eVO.setHtime(rs.getTime("hiredate"));
				eVO.setSdate();
				
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
}
