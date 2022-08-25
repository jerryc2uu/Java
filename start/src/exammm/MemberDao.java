package exammm;

import java.sql.*;

public class MemberDao {
	
	private GitJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new GitJDBC();
		mSQL = new MemberSQL();
	}

	// 회원 번호 입력해서 아이디, 이름, 메일 조회
	public MemberVO getMnoInfo(int mno) {
		
		MemberVO mvo = new MemberVO();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MEMBER_INFO);
		pstmt = db.getPstmt(con, sql);
		
		try {
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			mvo.setId(rs.getString("id"));
			mvo.setName(rs.getString("name"));
			mvo.setMail(rs.getString("mail"));
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return mvo;
	}
}
