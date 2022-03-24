package day19;
import java.util.*;
import java.util.Date;
import java.sql.*;
public class Member {
	private String name, id, pw, addr, tel, mail, gen, birth, jdate;
	private Date bdate, joinDate; // db와 자바의 Date 타입이 달라서 문제가 됨
	private Time btime, joinTime; // 2개는 누락되는 변수들임 -> JVM이 준 기본 생성자에서 set() 써서 넘기면 됨
								  // VO클래스에서는 따로 생성자 만드는 일이 드물다
								  // toString();은 단순 데이터 내용 확인 용도
	
	
	
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public Time getBtime() {
		return btime;
	}
	public void setBtime(Time btime) {
		this.btime = btime;
	}
	
	
}
