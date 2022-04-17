package githrd.vo;

import java.sql.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {

	private int mno, ano;
	private String name, id, pw, mail, tel, sdate, gen, isshow;
	private Date jdate;
	private Time jtime;
	
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
		sdate = form1.format(jdate) + form2.format(jtime);
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String string) {
		this.gen = string;
	}
	public Date getjdate() {
		return jdate;
	}
	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}
	public Time getJtime() {
		return jtime;
	}
	public void setJtime(Time jtime) {
		this.jtime = jtime;
	}
	
	public Date getJdate() {
		return jdate;
	}
	
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", ano=" + ano + ", name=" + name + ", id=" + id + ", pw=" + pw + ", mail="
				+ mail + ", tel=" + tel + ", sdate=" + sdate + ", gen=" + gen + ", isshow=" + isshow + ", jdate="
				+ jdate + ", jtime=" + jtime + "]";
	}
	
	
}
