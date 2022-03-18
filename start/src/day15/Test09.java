package day15;

import java.util.*;

public class Test09 {

	public Test09() {
		//ArrayList 타입의 변수 list에 1 ~ 25 사이의 정수 10개 랜덤하게 만들어서 채워주세요
		
		//1.변수 list 만들기
		ArrayList list = new ArrayList(10);
		
		//2.데이터 입력
		for(int i = 0 ; i < 10 ; i++) {
			int no = (int)(Math.random()*(25-1+1)+1);
			list.add(no);
		}
		
		//3. 출력
		System.out.println("1. 오름차순 정렬 전 ");
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print((int)(list.get(i)) + " ");
		}
		System.out.println();

		//6. 내림차순 정렬
		Collections.reverse(list);//reverse가 내림차순 정렬 해주는 게 아님. 오름차순 후 뒤집어주는 것
		System.out.println("1-1. 역순 정렬 후 ");
		//5. 출력
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print((int)(list.get(i)) + " ");
		}
		System.out.println();
		
		//4. 오름차순 정렬
		Collections.sort(list);
		System.out.println("2. 오름차순 정렬 후 ");
		//5. 출력
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print((int)(list.get(i)) + " ");
		}
		System.out.println();
		
		//6. 내림차순 정렬
		Collections.reverse(list);//reverse가 내림차순 정렬 해주는 게 아님. 오름차순 후 뒤집어주는 것
		System.out.println("3. 내림차순 정렬 후 ");
		//5. 출력
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print((int)(list.get(i)) + " ");
		}
		System.out.println();
		
	
		

		
		
			
		
		
	}

	public static void main(String[] args) {
		new Test09();
	}

}
