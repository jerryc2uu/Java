package day14.ex;

public class Student {
	private String name;
	private int ban, kor, eng, math, total;
	private double avg;
	
	public Student() {}
	
	public Student(String name, int ban, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		setTotal();
		setAvg();
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public void setAvg() {
		avg = total / 3;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotal() {
		total = kor + eng + math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + " , 반 : " + ban + " , 국어 : " + kor + " , 수학 : " + math + " , 영어 : " + eng + " , 총점 : " + total + " , 평균 : " + avg;
	}
	
	@Override
	public boolean equals(Object o) {
		//반환값 변수
		boolean bool = false;
		
		//입력된 데이터를 원래 형태로 강제 형변환
		Student nam = (Student) o;
		
		//남의 것 이름과 반 꺼내오고
		String namname = nam.getName();
		int namban = nam.getBan();
		
		//비교해서 결과 만들고
		if (name == namname && ban == namban) {
			bool = true;
		} else {
			bool = false;
		}
			
		return bool;
	}
	
}
