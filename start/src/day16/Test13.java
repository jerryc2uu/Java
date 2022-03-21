package day16;
//특수한 제너릭스
import java.util.*;
public class Test13 {

	public Test13() {
		ArrayList<Grand> list1 = new ArrayList<Grand>();
		ArrayList<Father> list2 = new ArrayList<Father>();
		ArrayList<Son> list3 = new ArrayList<Son>();
		ArrayList<GrandSon> list4 = new ArrayList<GrandSon>();
		
		abc(list1);
		abc(list2);
		abc(list3);
		//abc(list4); ==> Son의 하위클래스이니까 불가능
		
		//xyz(list1); ==> Son의 상위클래스이니까 불가능
		//xyz(list2);
		xyz(list3);
		xyz(list4);
		
	}
	
	public void qwe(ArrayList<?> list) {
	// ?는 모든 것을 의미한다. Object를 제너릭스로 선언한 것이다. 제너릭스 선언 안 한 것과 같음
		
		
	}
	
	public void abc(ArrayList<? super Son> list) {
	//Son 포함, 그 상위 클래스들 넣을 수 있는 함수
	// 이 함수의 매개변수는 Son, Father, Grand, Object 타입의 데이터를 입력해서 만든 리스트
		
	}
	
	public void xyz(ArrayList<? extends Son> list) {
	//이 함수 호출 시 Son이나 그 하위 클래스 객체를 입력한 리스트를 입력해야 한다. 
	}
	
	public static void main(String[] args) {
		new Test13();
	}

}

class Grand {
	
}

class Father extends Grand {
	
}

class Son extends Father {
	
}

class GrandSon extends Son {
	
}