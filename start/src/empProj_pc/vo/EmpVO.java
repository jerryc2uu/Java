package empProj_pc.vo;

import java.sql.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpVO {

	private int empno, mgr, sal, deptno, grade, comm;
	private String ename, job, sname, dname, loc, sdate, scomm;
	private Date hdate;
	private Time htime;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일 ");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss ");
		sdate = form1.format(hdate) + form2.format(htime);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getScomm() {
		return scomm;
	}
	public void setScomm(String scomm) {
		this.scomm = scomm;
	}
	public Date getHdate() {
		return hdate;
	}
	public void setHdate(Date hdate) {
		this.hdate = hdate;
	}
	public Time getHtime() {
		return htime;
	}
	public void setHtime(Time htime) {
		this.htime = htime;
	}
	
	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", mgr=" + mgr + ", sal=" + sal + ", deptno=" + deptno + ", grade=" + grade
				+ ", comm=" + comm + ", ename=" + ename + ", job=" + job + ", sname=" + sname + ", dname=" + dname
				+ ", loc=" + loc + ", sdate=" + sdate + ", scomm=" + scomm + ", hdate=" + hdate + ", htime=" + htime
				+ "]";
	}
	
	
	
}
