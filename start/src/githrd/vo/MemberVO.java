package githrd.vo;

import java.sql.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {

	private int mno, ano;
	private String name, id, pw, mail, tel, sdate;
	private char gen;
	private Date hdate;
	private Time htime;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일 ");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss");
		sdate = form1.format(hdate) + form2.format(htime);
	}
	public char getGen() {
		return gen;
	}
	public void setGen(char gen) {
		this.gen = gen;
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
		return "MemberVO [mno=" + mno + ", ano=" + ano + ", name=" + name + ", id=" + id + ", pw=" + pw + ", mail="
				+ mail + ", tel=" + tel + ", sdate=" + sdate + ", gen=" + gen + ", hdate=" + hdate + ", htime=" + htime
				+ "]";
	}
	
}
