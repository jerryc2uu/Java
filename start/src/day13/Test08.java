package day13;

//finally

public class Test08 {

	public Test08() {
		System.out.println("1. abc() 호출...!");
		abc();
		System.out.println("2. abc() 종료 직후...!");
		
	}
	
	public void abc() {
		int no1 = 25;
		int no2 = 0;
		int result = 0;
		
		try {
			result = no1 / no2;
		
		} catch(Exception e) {
			System.out.println("예외 발생...!");
			return; // 이 경우는 finally 블럭 실행한 후 즉시 함수 종료
		
		} finally {//예외 발생 여부 관계 없이 무조건 실행하는 부분
			System.out.println("### 여기는 finally 블럭...!");
		}
	}

	public static void main(String[] args) {
		new Test08();

	}

}
