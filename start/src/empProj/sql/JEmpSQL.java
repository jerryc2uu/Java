package empProj.sql;

/*
 	JEMP 테이블에 관련된 질의명령을 기억하고 있다가 
 	누군가 특정 질의명령을 호출하면 해당 질의명령을 반환해주는 클래스
 * @author 박소연
 * @since  2022.04.13
 * @version v.1.0
 */
public class JEmpSQL {
	
	//SELECT 1000, INSERT 2천, DELETE 3000
	//public : new만 시키면 어디서든지 사용 가능
	public final int SEL_TNAME = 1001;
	public final int SEL_LAST = 1002;
	
	public final int INSERT_JEMP = 3001;
	public final int INSERT_JEMP_D30 = 3002;
	
	public final int DEL_JEMP_D30 = 4001; 
			
	public final int ADD_TABLE	= 5001;
	
	
	//코드 입력받으면서 호출되면 그 코드에 맞는 질의명령을 반환해주는 함수
	public String getSQL(int code) {
		//반환값 변수
		//문자열 계속 누적시켜서 결합해야 하기 때문에 StringBuffer를 사용한다...
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_TNAME:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	tab ");// tab은 테이블 이름만 모아놓는 테이블
			buff.append("WHERE ");
			buff.append("	tname = 'JEMP' ");
			break;
		case ADD_TABLE:
			buff.append("CREATE TABLE jemp ");
			buff.append("AS ");
			buff.append("	SELECT ");
			buff.append("		* ");
			buff.append("	FROM ");
			buff.append("		emp ");
			buff.append("	WHERE ");
			buff.append("		1 = 2 ");
			break;
		case INSERT_JEMP:
			buff.append("INSERT INTO ");
			buff.append("	jemp(empno, ename, job, hiredate, deptno) ");
			buff.append("VALUES( ");
			buff.append("			(SELECT NVL(MAX(empno) + 1, 1001) FROM jemp), ");
			buff.append("			?, ?, sysdate, ? ");
			buff.append("		) ");
			break;
		case SEL_LAST:
			buff.append("SELECT ");
			buff.append("	empno eno, ename name, job, hiredate hdate, deptno dno ");
			buff.append("FROM ");
			buff.append("	jemp ");
			buff.append("WHERE ");
			buff.append("	hiredate = ");
			buff.append("		(SELECT ");
			buff.append("				MAX(hiredate) ");
			buff.append("		 FROM ");
			buff.append("				jemp) ");
			break;
		case INSERT_JEMP_D30:
			buff.append("INSERT INTO jbackup ");
			buff.append("SELECT ");
			buff.append("    e.*, sysdate ");
			buff.append("FROM ");
			buff.append("    jemp e ");
			buff.append("WHERE ");
			buff.append("    deptno = 30 ");	
			break;
		case DEL_JEMP_D30:
			buff.append("DELETE FROM ");
			buff.append("    jemp ");
			buff.append("WHERE ");
			buff.append("    deptno = 30 ");
			break;
		}
		//buff를 문자열로 변환해서 반환
		return buff.toString();
	}
}
