package day14.ex;

public class Sagak {

	private int width, height, area;
	
	public Sagak() {}
	
	public Sagak(int width, int height) {
		this.width = width;
		this.height = height;
		setArea();
	}

	public void setArea() {
		area = width * height;
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

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "사각형 - 가로 : " + width + " , 세로 : " + height + " , 면적 : " + area;
	}
	
	@Override
	public boolean equals(Object o) {
		//반환값 변수
		boolean bool = false;
		
		//입력된 데이터를 원래 형태로 강제 형변환
		Sagak nam = (Sagak) o;
		
		//남의 것 면적 꺼내오고
		int garo = nam.getWidth();
		int sero = nam.getHeight();
		
		//비교해서 결과 만들고
		if (garo == width && sero == height) {
			bool = true;
		}	else {
			bool = false;
		}
			
		return bool;
		
	}
}
