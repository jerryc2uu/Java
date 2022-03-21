package day16;
//맵은 데이터가 아니라 키값 기준이다
import java.util.*;
public class Test05 {

	public Test05() {
		TreeMap map = new TreeMap();
		//맵에 이름은 키값으로 하고 나이를 데이터로 입력해보자
		map.put("제니", "27");// a < ab, aA > a 문자는 정렬이 가능하다.
		map.put("리사", "28");
		map.put("로제", "26");
		map.put("지수", "27");
		
		//출력
		Set keys = map.keySet();
		for(Object key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		
		System.out.println("====================================");
		
		//이름(키값) 기준 내림차순 정렬해서 맵에 넣어보자
		TreeMap map1 = new TreeMap(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				String name1 = (String) o1;
				String name2 = (String) o2;
				
				//문자열로 숫자를 어떻게 만들까?
				int result = name1.compareTo(name2);
				
				return -result;
				
			}
			
		});
		
		//맵에 이름은 키값으로 하고 나이를 데이터로 입력해보자
		map1.put("제니", "27");// a < ab, aA > a 문자는 정렬이 가능하다.
		map1.put("리사", "28");
		map1.put("로제", "26");
		map1.put("지수", "27");
		
		//출력
		Set keys1 = map1.keySet();
		for(Object key : keys1) {
			System.out.println(key + " : " + map.get(key));
		}
		
		
	}

	public static void main(String[] args) {
		new Test05();
	}

}
