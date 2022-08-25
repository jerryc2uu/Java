package sub0419;

public class Test01 {
	public Test01() {
		arrProc();
	}
	
	public void strPrint() {
		String str = "black pink";
		
		int idx = str.indexOf(' ');
	}
	//배열 만들고 출력하는 함수
	public void arrProc() {
		String[] city = {"서울", "부산", "청주", "대구"};
		
		for(String dosi : city) {
			System.out.println(dosi);
		}
	}
	
	public void printStar() {
		
	}
	public static void main(String[] args) {
		new Test01();
	}

}
