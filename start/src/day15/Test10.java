package day15;
/* 
 정렬 방식 변경해보기 (여기선내림차순으로)


정렬 방식을 변경하기 위해서는 Comparator 인터페이스를 상속받은 클래스를 만들어야 한다.

 이 클래스는 Object 클래스를 상속받아 만들어졌기 때문에 이 클래스 내부에
 equals()가 이미 존재한다.
 
정렬할 때는 Comparator에게 물려받은 compare() 를 오버라이딩해서 
 정렬방식을 직접 정해서 적용시킬 수 있게 된다.
 
 이때 이 함수의 반환값은 정수 타입인데 값의 크기는 중요하지 않고 부호가 중요하다.
	
	이때 부호가 - 이면 두 개의 위치를 바꾸지 않고 + 이면 두 개의 위치를 바꾼다. 

*/

import java.util.*;

public class Test10 {

	public Test10() {
		//ArrayList 타입의 변수 list에 1 ~ 25 사이의 정수 10개 랜덤하게 만들어서 채워주세요
		
		//1.변수 list 만들기
		ArrayList list = new ArrayList(10);
		
		//2.데이터 입력
		for(int i = 0 ; i < 10 ; i++) {
			int no = (int)(Math.random()*(25-1+1)+1);
			list.add(no);
		}
		//3. 출력
		System.out.println("1. 정렬 전 ");
		for(int i = 0 ; i < list.size() ; i++) {
		System.out.print((int)(list.get(i)) + " ");
		}
		System.out.println();
		
		//내림차순 정렬
		Collections.sort(list, new DownSort());
		System.out.println("2. 내림차순 정렬 후 ");
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print((int)(list.get(i)) + " ");
		}
		System.out.println();
}

	public static void main(String[] args) {
		new Test10();
	}

}

class DownSort implements Comparator {
/*
 * 정렬 방식을 변경하기 위해서는 Comparator 인터페이스를 상속받은 클래스를 만들어야 한다.
 *  이 클래스는 Object 클래스를 상속받아 만들어졌기 때문에 이 클래스 내부에
 *  equals()가 이미 존재한다.
 *  
 *  정렬할 때는 Comparator에게 물려받은 compare() 를 오버라이딩해서 
 *  정렬방식을 직접 정해서 적용시킬 수 있게 된다.
 *  
 *  이때 이 함수의 반환값은 정수 타입인데 값의 크기는 중요하지 않고 부호가 중요하다.
 	
 	이때 부호가 - 이면 두 개의 위치를 바꾸지 않고 + 이면 두 개의 위치를 바꾼다. 
 */
	
	@Override
	public int compare(Object o1, Object o2) {
		int result = 0;
		
		//입력된 데이터를 원래 형태로 강제 형변환한다.
		int no1 = (int) o1;
		int no2 = (int) o2;
		
		result = no1 - no2;//오름차순 정렬
		
		return -result;// 내림차순이니까 부호 바꿔준다.
	}
}