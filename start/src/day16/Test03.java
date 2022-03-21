package day16;
/*
   전화번호부 만들기

 */
import java.util.*;
public class Test03 {

	public Test03() {
		HashMap map = new HashMap();
		
		//데이터 추가
		map.put("제니", "010-1111-1111");
		map.put("리사", "010-2222-2222");
		map.put("로제", "010-3333-3333");
		map.put("지수", "010-4444-4444");
		
		//출력
		System.out.println("로제 : " + map.get("로제"));//반복 안 하고 원하는 데이터를 바로 꺼낼 수 있다는 게 map의 장점
		System.out.println();
		
		//키값이 몇 개인지 모르는 상태라면?
		
		//키값만 모두 추출
		Set keys = map.keySet();
		
		for(Object key : keys) {
			Object value = map.get(key);
			System.out.println(key + " - " + value);
		}
			
	}

	public static void main(String[] args) {
		new Test03();
	}

}
