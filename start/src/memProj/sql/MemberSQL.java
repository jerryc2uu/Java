package memProj.sql;

public class MemberSQL {
	public final int SEL_ALLMNO = 1001;
	public final int SEL_ALLID = 1002;
	public final int SEL_ALLANO = 1003;
	public final int SEL_MNOINFO = 1004;
	public final int SEL_IDINFO = 1005;
	public final int SEL_ANOINFO = 1006;
	
	public String getSQL(int code) {
		
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_ALLMNO:
			buff.append("SELECT ");
			buff.append("	mno ");
			buff.append("FROM ");
			buff.append("	member ");
			break;
		case SEL_ALLID:
			buff.append("SELECT ");
			buff.append("	id ");
			buff.append("FROM ");
			buff.append("	member ");
			break;
		case SEL_ALLANO:
			buff.append("SELECT DISTINCT ");
			buff.append("	avt ");
			buff.append("FROM ");
			buff.append("	member ");
			break;
		case SEL_MNOINFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, pw, mail, tel, avt, gen, joindate ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	mno = ? ");
			break;
		case SEL_IDINFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, pw, mail, tel, avt, gen, joindate ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case SEL_ANOINFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, pw, mail, tel, avt, gen, joindate ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	avt = ? ");			
			break;
		}
		return buff.toString();
	}
}

