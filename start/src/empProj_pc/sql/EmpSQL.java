package empProj_pc.sql;

public class EmpSQL {

	public final int SEL_ALL = 1001;
	public final int SEL_DNOINFO = 1002;
	public final int SEL_JOBINFO = 1003;
	public final int SEL_JOBLIST = 1004;
	public final int SEL_DNOLIST = 1005;
	public final int SEL_DEPTLIST = 1006;
	
	public String getSQL(int code) {
		
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_ALL: // 모든 사원 정보 조회
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate ");
			buff.append("FROM ");
			buff.append("	emp ");
			break;
		case SEL_DNOINFO: // 부서 번호 입력받아서 정보 조회
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate, sal, e.deptno, dname, loc ");
			buff.append("FROM ");
			buff.append("	emp e, dept d ");
			buff.append("WHERE ");
			buff.append("	e.deptno = d.deptno ");
			buff.append("	AND e.deptno = ? ");
			break;
		case SEL_JOBINFO: // 직급 입력 받아서 정보 조회
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate, sal, grade, NVL(TO_CHAR(comm), 'NONE') comm ");
			buff.append("FROM ");
			buff.append("	emp, salgrade ");
			buff.append("WHERE ");
			buff.append("	sal BETWEEN losal AND hisal ");
			buff.append("	AND job = ? ");
			break;
		case SEL_JOBLIST: // 직급 종류 조회
			buff.append("SELECT ");
			buff.append("	DISTINCT job ");
			buff.append("FROM ");
			buff.append("	emp ");
			break;
		case SEL_DNOLIST: // 부서 번호 종류 조회
			buff.append("SELECT ");
			buff.append("		deptno ");
			buff.append("FROM ");
			buff.append("	dept ");
			break;
		case SEL_DEPTLIST: // 부서 번호, 부서 이름 조회
			buff.append("SELECT ");
			buff.append("		deptno, dname ");
			buff.append("FROM ");
			buff.append("	dept ");
			break;
		}
		
		
		return buff.toString();
	}
}
