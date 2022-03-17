package day10.sub;

import day10.*;

public class Sample01 {
	private int num1, num2, num3, num4; // 은닉화
	
	//day10.Test01의 멤버변수를 읽어서 위 변수에 셋팅해주는 함수
	public void setNum() {
		// heap에 객체 만들고
		Test01 t1 = new Test01();//new는 heap에 뭔가 만들겠습니다, 주소는 제가 알려드릴게요.. 주소를 t1에 기억시켜놓은 것
		
		//num1 = t1.no1; // no1의 접근지정자가 private이기 때문에 불가능
		//num2 = t1.no2; // no2는 같은 패키지 안의 클래스까지만 접근가능하도록 접근지정자가 생략되었으므로 불가능
		//num3 = t1.no3; // no3는 Test01을 상속받은 클래스거나 같은 패키지 내의 클래스에서만 사용가능하므로 불가능
		num4 = t1.no4; // no4는 모든 곳에서 사용 가능하므로 접근 가능
		
		
	}
}

