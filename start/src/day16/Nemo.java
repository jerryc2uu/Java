package day16;

public class Nemo {
	private int width, height, area;
	
	public Nemo() {
	}
	
	public Nemo(int width, int height) {
		this.width = width;
		this.height = height;
		setArea(width * height);
	}
	
	//가로가 같으면 같은 네모로 처리 되도록 equals() 오버라이딩
	@Override
	public boolean equals(Object o) {//본래는 주소값 같은지 비교, 오버라이딩 뒤 내용 같은지 비교
		boolean bool = false;
		
		Nemo nemo = (Nemo) o;
		
		bool = width == nemo.getWidth();
		
		return bool;
	}
	
	@Override
	//문자열 만들어서 출력해준다
	public String toString() {
		
		return "사각형 - 가로 : " + width + " , 세로 : " + height + " , 면적 : " + area;
		
	}
	
	@Override
	public int hashCode() {
		return 1; // 이 클래스의 객체는 이제부터 모두 해쉬코드값을 1을 갖는다.
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

}
