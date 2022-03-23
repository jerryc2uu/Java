package day18;
import java.io.*;
/*
	이 클래스가 직렬화(클래스 전체를 넘겨줌) 되기 위해서는 
	직렬화 가능한 클래스가 되어야 한다.
	
		방법 : implements Serializable(구현)
		
	이 때 전달되는 데이터는 멤버 중 함수 제외한 변수의 내용뿐이다.
	따라서 데이터 사용하려면 받는 쪽에서도 똑같은 클래스를 가지고 있어야 한다.(게터 세터 함수로 은닉화된 변수를 써야하므로)
 */
public class Friend implements Serializable {//소속 함수가 없어서 오버라이딩은 필요 없고 구현만 하면 된다.
	private String name, tel, mail, addr, blood;
	private int age;
	private float height;
	private char gen;
	private boolean rh; // + : true, - : false
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public char getGen() {
		return gen;
	}
	public void setGen(char gen) {
		this.gen = gen;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public boolean isRh() {
		return rh;
	}
	public void setRh(boolean rh) {
		this.rh = rh;
	}
	
	@Override
	public String toString() {
		return "Friend [name=" + name + ", tel=" + tel + ", mail=" + mail + ", addr=" + addr + ", blood=" + blood
				+ ", age=" + age + ", height=" + height + ", gen=" + gen + ", rh=" + rh + "]";
	}


}
