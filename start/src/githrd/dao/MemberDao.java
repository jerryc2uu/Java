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
	
	//회원번호와 id 조회해서 출력해주는 함수
	public ArrayList<MemberVO> getMnoid() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		MemberVO mVO = new MemberVO();
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MNOID);
		stmt = db.getStmt(con);
		
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
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
	
	//회원번호 입력하면 해당 회원의 정보 출력해주는 함수
	public MemberVO getMinfo(int mno) {
		MemberVO mVO = new MemberVO();
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MINFO);
		pstmt = db.getPstmt(con, sql);
		
		try {
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			
			rs.next();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return mVO;
	}
		
		//아이디 입력하면 해당 회원의 전화번호 수정(0101-1212-1212)해주는 함수
		
		//(어려워여~)Scanner로 회원 정보 입력받아서 회원 가입 처리해주는 함수
}
