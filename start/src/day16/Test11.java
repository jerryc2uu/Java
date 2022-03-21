package day16;
/*
   <제너릭스>
   
   blackpink 멤버들의 이름을 기억하는 Set을 만들어서 출력해보자
   이때 문자열만 입력되도록 처리하세요
 */
import java.util.*;
public class Test11 {

	public Test11() {
		
		HashSet<String> set = new HashSet<String>();
		
		//이 Set은 문자열만 입력받도록 되어 있는 클래스
		//따라서 꺼낸 데이터도 당연히 문자열
		set.add("제니");
		set.add("리사");
		set.add("로제");
		set.add("지수");
		
		//향상된 for 명령으로 꺼내기
		for(String name : set) {
			System.out.println(name);
		}
		System.out.println();
		//제너릭스는 전파되지 않는다. 따라서 다시 해줘야 한다.
		ArrayList<String> blackpink = new ArrayList<String>(set);//노란줄은 Object 타입으로 입력된다고 경고하는 것
		for(int i = 0 ; i < blackpink.size() ; i++) {
			String name = blackpink.get(i);
			System.out.println(name);
		}
		System.out.println();
		Iterator<String> itor = set.iterator();
		while(itor.hasNext()) {
			String name = itor.next();
			System.out.println(name);
		}
		
	}

	public static void main(String[] args) {
		new Test11();
	}

}
