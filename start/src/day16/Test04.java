package day16;
/*
   4명의 학생들의 점수를 map에 담아서 관리하자

 */
import java.util.*;
public class Test04 {

	public Test04() {
		
		ArrayList names = new ArrayList();
		names.add("제니");
		names.add("로제");
		names.add("리사");
		names.add("지수");
		
		HashMap map = new HashMap();
		
		for(int i = 0 ; i < 4 ; i++) {
			//키값 뽑아내기
			Object key = names.get(i);
			Student std = new Student((String) key, 
						(int)(Math.random()*41+60),
						(int)(Math.random()*41+60),
						(int)(Math.random()*41+60),
						(int)(Math.random()*41+60)
						);
				//map에 데이터 입력
				map.put(key, std);
			}
			
			//출력
			//키값 모두 뽑아낸다.
			Set keys = map.keySet();
			//set 계열을 출력 함수가 없으니 list로 변환
			ArrayList list = new ArrayList(keys);
			
			for(Object key : list) {
				//키값으로 데이터 추출
				Object value = map.get(key);
				System.out.println("*** " + key + " ***\n" + value);
				System.out.println();
			}
	}

	public static void main(String[] args) {
		new Test04();
	}

}
