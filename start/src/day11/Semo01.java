package day11;

public class Semo01 extends Moyang {
	private int width, height;
	private double area;
	
	public Semo01() {
		
	}
	
	public Semo01(int width, int height) {
		this.width = width;
		this.height = height;
		setArea();
	}
	
	/*
	   Overridng 규칙
	    	0. 상속해준 클래스에 고쳐쓸 클래스가 존재해야 한다.
	    	1. 함수의 원형(반환값타입, 함수이름, 매개변수 리스트) 유지
	    	2. 접근지정자는 같거나 넓은 방향
	    	3. 예외처리는 같거나 좁은 방향
	 */
	
	@Override
	public void toPrint() {
		System.out.printf("밑변이 %3d 이고, 높이가 %3d 이고, 넓이가 %6.2f 인 삼각형", width, height, area);
	}
		

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	public void setArea() { // 오버로딩
		area = width * height / 2.;
	}
}
	
