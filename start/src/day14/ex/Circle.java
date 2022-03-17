package day14.ex;

public class Circle {
	
	private int rad;
	private double arround, area;
	
	public Circle() {}
	
	public Circle(int rad) {
		this.rad = rad;
		setArround();
		setArea();
	}

	public void setArround() {
		arround = 2 * rad * Math.PI;
	}

	public void setArea() {
		area = rad * rad * Math.PI;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public double getArround() {
		return arround;
	}

	public void setArround(double arround) {
		this.arround = arround;
	}


	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "원 - 반지름 : " + rad + " , 둘레 : " + arround + " , 넓이 : " + area;
	}
	
	@Override
	public boolean equals(Object o) {
		//반환값 변수
		boolean bool = false;
		
		//입력된 데이터를 원래 형태로 강제 형변환
		Circle won = (Circle) o;
		
		//남의 것 면적 꺼내오고
		double namarea = won.getArea();
		
		//비교해서 결과 만들고
		bool = area == namarea;
		
		return bool;
	}
	
}
