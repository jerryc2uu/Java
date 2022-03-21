package day16;

public class Sagak {
	private int width, height, area; 
	
	public Sagak() {
	}
	
	public Sagak(int width, int height) {
		this.width = width;
		this.height = height;
		setArea(width * height);
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
	
	/*
	    이 클래스를 누군가 출력할 경우를 대비해서 정보를 알려주고 싶다면?
	     toString()을 오버라이딩하여 기능을 수정하면 된다.
	     만일 오타가 나면 오버라이딩이 아니라 새로운 함수를 더 만든 것으로 인정한다.
	 */
	     
	    
	
	@Override
	public String toString() {
		return "이 클래스는 면적이 " + area + " 인 사각형 ";
	}

}
