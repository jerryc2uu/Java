package day15;
/*
   다양한 형태의 데이터를 벡터에 넣고 출력해보자

 */
import java.util.*;

public class Test06 {

	public Test06() {
		Vector vec = new Vector();
	
		//데이터 입력 (add 함수에서는 Object 타입의 데이터가 입력되어야 한다.)
		vec.add("제니");
		vec.add('F'); // 여기부터는 기본 데이터 타입. 자동 Boxxing -> Object 타입으로 자동 형변환
		vec.add(27); // char 입력 --> character 자동 Boxxing --> Object 자동형변환
		vec.add(168.5);
		vec.add(false);
		
		//벡터 안의 데이터를 꺼내자
		String name = (String) vec.get(0);
		char gen = (Character) vec.get(1); // 자동 UnBoxxing
		int age = (Integer) vec.get(2);
		double height = (Double) vec.get(3);
		boolean bool = (Boolean) vec.get(4);
		
		//출력
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gen);
		System.out.println("나이 : " + age);
		System.out.println("신장 : " + height);
		System.out.println("학원 : " + bool);
		
		System.out.println();
		for(Object o : vec) {
			System.out.println(o + " "); // 각 타입별로 오버라이딩된 toString 함수가 호출돼서 주소 아닌 내용 출력되는 것
		}
	}

	public static void main(String[] args) {
		new Test06();
	}

}
