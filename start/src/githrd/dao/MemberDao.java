package githrd.dao;

import java.sql.*;
import java.util.*;

import githrd.db.*;
import githrd.sql.*;
import githrd.vo.*;

public class MemberDao {
	
	private JenyJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new JenyJDBC();
		mSQL = new MemberSQL();
		
		/*con = db.getCon();
		System.out.println("######## 커넥션 꺼내오기 성공 ###########");
		db.close(con);
		*/
	}
	
	//1. 회원번호와 id 조회해주는 함수
	public ArrayList<MemberVO> getMnoid() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MNOID);
		stmt = db.getStmt(con);
		
		//MemberVO mVO = new MemberVO();
		try {
			
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				MemberVO mVO = new MemberVO();
				int mno = rs.getInt("mno");
				String id = rs.getString("id");
				
				mVO.setMno(mno);
				mVO.setId(id);
				
				list.add(mVO);
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
	
	//2. 회원번호 입력하면 해당 회원의 정보 조회해주는 함수
	public MemberVO getMinfo(int mno) {
		
		MemberVO mVO = new MemberVO();

		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MINFO);
		pstmt = db.getPstmt(con, sql);
		
		try {
			
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			
			mVO.setMno(rs.getInt("mno"));
			mVO.setName(rs.getString("name"));
			mVO.setId(rs.getString("id"));
			mVO.setPw(rs.getString("pw"));
			mVO.setMail(rs.getString("mail"));
			mVO.setTel(rs.getString("tel"));
			mVO.setAno(rs.getInt("avt"));
			mVO.setGen(rs.getString("gen"));
			mVO.setJdate(rs.getDate("joindate"));
			mVO.setJtime(rs.getTime("joindate"));
			mVO.setSdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return mVO;
	}
	//3. 아이디 입력하면 해당 회원의 전화번호 수정(0101-1212-1212)해주는 함수
	public int upTEL(String id) {
		int cnt = 0;
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.UP_TEL);
		pstmt = db.getPstmt(con, sql);
		
		try {

			pstmt.setString(1, id);
			
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		
		return cnt;
	}
		
	//4. Scanner로 회원 정보 입력받아서 회원 가입 처리해주는 함수
	public int inJOIN(MemberVO mVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.INS_JOIN);
		pstmt = db.getPstmt(con, sql);
		
		try {
			
			String name = mVO.getName();
			String id = mVO.getId();
			String pw = mVO.getPw();
			String mail = mVO.getMail();
			String tel = mVO.getTel();
			int ano = mVO.getAno();
			//String gen = mVO.getGen();
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, mail);
			pstmt.setString(5, tel);
			pstmt.setInt(6, ano);
			//pstmt.setString(7, gen);
			
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
		
	}
}
