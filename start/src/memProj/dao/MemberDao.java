package memProj.dao;

import java.sql.*;
import java.util.*;

import memProj.db.JennieJDBC;
import memProj.sql.MemberSQL;
import memProj.vo.MemberVO;

public class MemberDao {

	private JennieJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new JennieJDBC();
		mSQL = new MemberSQL();
	}
	
	//1. 모든 회원 번호 조회
	public ArrayList<Integer> getMnoList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_ALLMNO);
		stmt = db.getStmt(con);
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getInt("mno"));
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
	
	//2. 모든 아이디 조회
	public ArrayList<String> getIdList() {
		ArrayList<String> list = new ArrayList<String>();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_ALLID);
		stmt = db.getStmt(con);
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getString("id"));
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
	
	//3. 모든 아바타 조회
	public ArrayList<Integer> getAnoList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_ALLANO);
		stmt = db.getStmt(con);
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getInt("avt"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		System.out.println("list size : " + list.size());
		return list;
	}
	//4. 회원 번호 입력해서 정보 조회
	public MemberVO getMnoInfo(int mno) {
		MemberVO mvo = new MemberVO();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MNOINFO);
		pstmt = db.getPstmt(con, sql);
		
		try {
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			mvo.setMno(rs.getInt("mno"));
			mvo.setName(rs.getString("name"));
			mvo.setId(rs.getString("id"));
			mvo.setPw(rs.getString("pw"));
			mvo.setMail(rs.getString("mail"));
			mvo.setTel(rs.getString("tel"));
			mvo.setAno(rs.getInt("avt"));
			mvo.setGen(rs.getString("gen"));
			mvo.setJdate(rs.getDate("joindate"));
			mvo.setJtime(rs.getTime("joindate"));
			mvo.setSdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return mvo;
	}
	//5. 아이디 입력해서 정보 조회
	public MemberVO getIdInfo(String id) {
		MemberVO mvo = new MemberVO();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_IDINFO);
		pstmt = db.getPstmt(con, sql);
		
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			mvo.setMno(rs.getInt("mno"));
			mvo.setName(rs.getString("name"));
			mvo.setId(rs.getString("id"));
			mvo.setPw(rs.getString("pw"));
			mvo.setMail(rs.getString("mail"));
			mvo.setTel(rs.getString("tel"));
			mvo.setAno(rs.getInt("avt"));
			mvo.setGen(rs.getString("gen"));
			mvo.setJdate(rs.getDate("joindate"));
			mvo.setJtime(rs.getTime("joindate"));
			mvo.setSdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return mvo;
	}
	
	//6. 아바타 입력해서 정보 조회
	public ArrayList<MemberVO> getAnoInfo(int ano){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_ANOINFO);
		pstmt = db.getPstmt(con, sql);
		
		try {
			pstmt.setInt(1, ano);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setMno(rs.getInt("mno"));
				mvo.setName(rs.getString("name"));
				mvo.setId(rs.getString("id"));
				mvo.setPw(rs.getString("pw"));
				mvo.setMail(rs.getString("mail"));
				mvo.setTel(rs.getString("tel"));
				mvo.setAno(rs.getInt("avt"));
				mvo.setGen(rs.getString("gen"));
				mvo.setJdate(rs.getDate("joindate"));
				mvo.setJtime(rs.getTime("joindate"));
				mvo.setSdate();
				
				list.add(mvo);
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
