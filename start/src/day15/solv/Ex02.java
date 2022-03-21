package day15.solv;

import java.util.*;

/*
1 ~ 99 사이의 정수를 랜덤하게 발생시켜서 
10개를 TreeSet에 입력한 후
내림차순으로 정렬해서 출력하세요.
*/
public class Ex02 {
	//이 경우는 기존 가지고 있는 정렬 기준을 바꾸는 작업이 되기 때문에
	//Comparator를 트리셋을 만들 때 적용시켜서 만들면 된다.

	public Ex02() {
		
		TreeSet set = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				int result = 0;
				
				int no1 = (int) o1;
				int no2 = (int) o2;
				
				result = no1 - no2;
						
				return -result;
			}
			
			
		});
		
		while(true) {
			set.add((int)(Math.random()*(99-1+1)+1));
			if(set.size() == 10) {
				break;
			}
		}
		
		for(Object o : set) {//향상된 for 명령 쓰면 set 계열도 꺼내기 가능, 되도록이면 쓰지 않기
			System.out.println(o);
		}
		/*
		Iterator itor = set.iterator();
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
		*/
	}

	public static void main(String[] args) {
		new Ex02();
	}

}
