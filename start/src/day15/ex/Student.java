package day15.ex;

public class Student implements Comparable {
	private String name;
	private int ban, num, java, db, web, spr, total; 
	private double avg;
	
	public Student() {
		
	}
	
	public Student(String name) {
		this.name = name;
		setStudent();
	}
	
	//랜덤 입력 통합 함수
	public void setStudent() {
		ban = (int)(Math.random() * (10 - 1 + 1) + 1);
		num = (int)(Math.random() * (10 - 1 + 1) + 1);
		java = (int)(Math.random() * (100 - 60 + 1) + 60);
		db = (int)(Math.random() * (100 - 60 + 1) + 60);
		web = (int)(Math.random() * (100 - 60 + 1) + 60);
		spr = (int)(Math.random() * (100 - 60 + 1) + 60);
		total = java + db + web + spr;
		avg = total / 4;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + " 반 : " + ban + " 번호 : " + num + " 자바 : " + java 
				+ " 데이터베이스 : " + db + " 웹 : " + web + " 스프링 : " + spr 
				+ " 총점 : " + total + " 평균 : " + avg;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getWeb() {
		return web;
	}

	public void setWeb(int web) {
		this.web = web;
	}

	public int getSpr() {
		return spr;
	}

	public void setSpr(int spr) {
		this.spr = spr;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override//반 순서대로 정렬, 반이 같으면 번호 순으로 오름차순 정렬
	public int compareTo(Object o) {
		
		Student s = (Student) o;
		
		//반과 번호 비교
		int result = ban - s.getBan();
		
		if(result == 0) {
			result = num - s.getNum();
		}
		
		return result;
		
	}

}
