package day16;
/*
   재귀(호출)함수 : 함수 내부에서 자기자신을 다시 호출
   주로 반환값 반환 부분에서 주로 다시 호출하는 형식을 띈다.
   
   주의) 반드시 호출 종료지점을 지정해줘야 한다. 무한루프에 빠지지 않도록
 */
   
   
public class Test07 {

	public Test07() {
		System.out.println("1 ~ 50까지의 합 : " + getSum(50));
	}
	
	// 1 ~ n까지의 합을 구해서 반환해주는 함수
	public int getSum(int n) {//언제까지 더할지 알려준다.
		//재귀 호출함수는 반드시 호출 종료지점을 기술해야 한다!!
		if(n < 1) {
			return 0;
		}
		return n + getSum(n-1);//함수 안에서 자신을 다시 호출하고 있음
	}
	
	public static void main(String[] args) {
		new Test07();
	}

}
