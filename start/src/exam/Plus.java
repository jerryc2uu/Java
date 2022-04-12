package exam;

public class Plus implements Calc {
	private int a, b;
	private double hap;
	
	public Plus() {
	}
	
	public Plus(int a, int b) {
		this.a = a;
		this.b = b;
		cal();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public double getHap() {
		return hap;
	}

	public void setHap(double hap) {
		this.hap = hap;
	}

	public void setHap(int a, int b) {
		hap = a + b;
	}

	@Override
	public double cal() {
		return hap;
	}

}
