package exam;

public class Semo extends Figure {
	
	private int width, height;
	private float area;
	
	public Semo() {}

	public Semo(int width, int height) {
		this.width = width;
		this.height = height;
		setArea();
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


	public void setArea(float area) {
		this.area = area;
	}

	public void setArea() {
		area = width * height / 2;
	}

	@Override
	public float area() {
		return area;
	}

}
