package empProj_pc.sql;

public class EmpSQL {
	
	public final int SEL_ALL = 1001;
	public final int SEL_DNOINFO = 1002;
	public final int SEL_JOBINFO = 1003;
	public final int SEL_JOBLIST = 1004;
	public final int SEL_DNOLIST = 1005;
	public final int SEL_DEPTLIST = 1006;
	public final int SEL_ENOINFO = 1007;
	

	public String getSQL(int code) {
		
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_ALL:
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate ");
			buff.append("FROM ");
			buff.append("	emp ");
			break;
		case SEL_DNOINFO:
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate, sal, e.deptno, dname, loc ");
			buff.append("FROM ");
			buff.append("	emp e, dept d ");
			buff.append("WHERE ");
			buff.append("	e.deptno = d.deptno ");
			buff.append("	AND e.deptno = ? ");
			break;
		case SEL_JOBINFO:
			buff.append("SELECT ");
			buff.append("	empno, ename, job, hiredate, sal, grade, NVL(TO_CHAR(comm), 'NONE') comm ");
			buff.append("FROM ");
			buff.append("	emp, salgrade ");
			buff.append("WHERE ");
			buff.append("	sal BETWEEN losal AND hisal ");
			buff.append("	AND job = ? ");
			break;
		case SEL_JOBLIST:
			buff.append("SELECT ");
			buff.append("	DISTINCT job ");
			buff.append("FROM ");
			buff.append("	emp ");
			break;
		case SEL_DNOLIST:
			buff.append("SELECT ");
			buff.append("	deptno ");
			buff.append("FROM ");
			buff.append("	dept ");
			break;
		case SEL_DEPTLIST:
			buff.append("SELECT ");
			buff.append("	deptno, dname ");
			buff.append("FROM ");
			buff.append("	dept ");
			break;
		case SEL_ENOINFO:
			buff.append("SELECT ");
			buff.append("	empno, ename, job, sal, hiredate ");
			buff.append("FROM ");
			buff.append("	empno = ? ");
			break;
		}
		
		return buff.toString();
	}

}
