package day12;

public class Nemo extends Figure {
	
	// 전역 변수 추가
	private int garo, sero;//area
	private double area;
	
	// 생성자
	public Nemo() {
		
	}
	
	public Nemo(int garo, int sero) {
		this.garo = garo;
		this.sero = sero;
		setArea();
	}
	
	@Override
	public void setArea() {
		// 사각형 면적 셋팅 함수
		area = garo * sero;
	}

	@Override
	public void toPrint() {
		// 사각형 내용 출력 함수
		System.out.printf("이 사각형은 가로가 %3d 이고, 세로가 %3d 이고, 면적이 %6d 입니다.", garo, sero, area);
		System.out.println();
	}

	public int getGaro() {
		return garo;
	}

	public void setGaro(int garo) {
		this.garo = garo;
	}

	public int getSero() {
		return sero;
	}

	public void setSero(int sero) {
		this.sero = sero;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

}
