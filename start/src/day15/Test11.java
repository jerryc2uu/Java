package day15;
/*
   5 ~ 25 사이의 랜덤한 정수를 반지름으로 하는 

   원을 기억할 클래스를 만들고
   
   원 10개를 리스트에 채워서 넓이가 넓은 원부터
   내림차순으로 정렬해서 내용을 출력하라
   
   ==> 객체 타입 데이터도 정렬할 수 있다.
 */


import java.util.*;

public class Test11 {

	public Test11() {
		
		ArrayList list = new ArrayList();
		
		//데이터 추가
		for(int i = 0 ; i < 10 ; i++) {
			Won w = new Won((int)(Math.random() * 21 + 5));
			//list에 만들어진 원을 각 방에 매번 채워준다.
			list.add(w); // object 타입으로 매개변수가 정의돼있기 떄문에 won 타입을 넣어도 Object 타입으로 자동 형변환이 돼서 쌓인다.
						 // 컬렉션은 모든 데이터를 담을 수 있어야 하기 때문에 따로 타입을 정해주지 않는 이상 Object 타입.
		}
		System.out.println("1. 내림차순 정렬 전");
		//출력
		for(Object o : list) {
			//이 때 꺼낸 데이터 o는 원래는 Won 객체를 입력한 것  
			//따라서 원래 데이터로 강제 형변환한다.
			Won w = (Won) o;
			System.out.println(w);
		}
		
		System.out.println();
		//정렬하기
		Collections.sort(list, new Comparator() {//무명 내부 클래스 이용

			@Override
			public int compare(Object o1, Object o2) {//Won타입 데이터가 입력될 것
				int result = 0;
				
				//원래 데이터 타입으로 강제 형변환, list에는 Won타입의 데이터가 채워져 있기 때문
				Won w1 = (Won) o1;
				Won w2 = (Won) o2;
				
				double area1 = w1.getArea();
				double area2 = w2.getArea();
				
				//반환값은 크기는 중요하지 않고 부호가 중요하므로
				result = ((area1 - area2) <= 0) ? -1 : 1;//음수이면 위치 그대로, 양수이면 바꾼다. 오름차순으로 먼저 생각
				
				return -result;//내림차순이므로 오름차순에서 부호 반전시켜준다.
			}
			
		});
		System.out.println("2. 내림차순 정렬 후");
		//출력
		for(Object o : list) {
			//이 때 꺼낸 데이터 o는 원래는 Won 객체를 입력한 것
			//따라서 원래 데이터로 강제 형변환한다.
			Won w = (Won) o;
			System.out.println(w);
		}
	}

	public static void main(String[] args) {
		new Test11();
	}

}
