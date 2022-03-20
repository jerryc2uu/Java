package day15;
//List 인터페이스 중 LinkedList 사용
import java.util.*;

public class Test08 {

	public Test08() {
		
		LinkedList member = new LinkedList();
		
		member.add("제니");
		member.add("리사");
		member.add("로제");
		member.add("지수");
		
		// 이렇게 한 가지 형태의 데이터만 입력하면 
		// 꺼내서 사용할 때 한 가지 방식으로 처리할 수 있기 때문에 편해짐
		
		int len = member.size(); // 컬렉션에 추가된 데이터의 갯수 알려주는 함수
		
		for(int i = 0 ; i < len ; i++) {
			String name = (String) member.get(i);
			System.out.println(name);
		}
		System.out.println(member);//실제 데이터를 하나씩 꺼낸 게 아니라 내용 확인만 한 것
	}

	public static void main(String[] args) {
		new Test08();
	}

}
