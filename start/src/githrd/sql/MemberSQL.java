package githrd.sql;

public class MemberSQL {
	//생성자 함수 없으면 JVM이 매개변수 없는 기본 생성자 자동 생성...
	
	public final int SEL_MNOID = 1001;
	public final int SEL_ALLMNO = 1002;
	public final int SEL_ALLID = 1003;
	public final int SEL_MINFO = 1004;
	public final int SEL_NEWMEM = 1005;
	public final int UP_TEL = 2001;
	public final int INS_JOIN = 2002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		//1. 회원번호와 id 조회해서 출력
		case SEL_MNOID:
			buff.append("SELECT ");
			buff.append("    mno, id ");
			buff.append("FROM ");
			buff.append("    member ");
			break;
		// 회원 번호 리스트 조회
		case SEL_ALLMNO:
			buff.append("SELECT ");
			buff.append("	mno ");
			buff.append("FROM ");
			buff.append("	member ");
			break;
		// 회원 아이디 리스트 조회
		case SEL_ALLID:
			buff.append("SELECT ");
			buff.append("	id ");
			buff.append("FROM ");
			buff.append("	member ");
			break;
		//2. 회원번호 입력하면 해당 회원의 정보 출력
		case SEL_MINFO:	
			buff.append("SELECT ");
			buff.append("	mno, name, id, pw, mail, tel, avt, gen, joindate ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	mno = ? ");
			break;
		//3. 아이디 입력하면 해당 회원의 전화번호 수정(0101-1212-1212)
		case UP_TEL:
			buff.append("UPDATE ");
			buff.append("    member ");
			buff.append("SET ");
			buff.append("    tel = '010-1212-1212' ");
			buff.append("WHERE ");
			buff.append("    id = ? ");
    		break;
		//4. Scanner로 회원 정보 입력받아서 회원 가입 처리
		case INS_JOIN:
			buff.append("INSERT INTO ");
			buff.append("    member(mno, name, id, pw, mail, tel, avt, gen, joindate, isshow) ");
			buff.append("VALUES( ");
			buff.append("        (SELECT ");
			buff.append("            NVL(MAX(mno) + 1, 1001) ");
			buff.append("         FROM ");
			buff.append("            member), ");
			buff.append("        ?, ?, ?, ?, ?, ?, ?, sysdate, 'Y' ");
			buff.append(") ");
			break;
		case SEL_NEWMEM:
			buff.append("SELECT ");
			buff.append("    mno, name, id, pw, mail, tel, avt, gen, joindate, isshow ");
			buff.append("FROM ");
			buff.append("    MEMBER ");
			buff.append("WHERE ");
			buff.append("    mno =  (SELECT ");
			buff.append("                MAX(mno) ");
			buff.append("            FROM ");
			buff.append("                MEMBER ");
			buff.append("            ) ");
			break;
		}
		//5. 신규 회원의 정보 조회
		
		return buff.toString();
	}
}
