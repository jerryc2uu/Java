package day15;
// 다양한 타입의 데이터를 담을 수 있는 컬렉션
import java.util.*;

public class Test05 {

	public Test05() {
		Vector vec = new Vector(10, 5);
		int cap = vec.capacity();//capacity()는 현재 확보해놓은 빈 공간 알려주는 함수 <-> size()는 실제 데이터가 차지하는 공간
		System.out.println("처음 공간 : " + cap);
		
		for(int i = 0 ; i < 16 ; i++) {
			//데이터 채우기
			vec.add(i + 1);
		}
		
		cap = vec.capacity();
		System.out.println("확보한 공간 : " + cap);
		
		System.out.println("----------------------------");
		
		Vector v2 = new Vector();
		int cap1 = v2.capacity();
		System.out.println("1. v2.capacity : " + cap1);
		
		//데이터 채우기
		for(int i = 0 ; i < 21 ; i++) {
			v2.add(i+1);
		}
		
		cap1 = v2.capacity();
		System.out.println("1. v2.capacity : " + cap1);
		System.out.println();
	}

	public static void main(String[] args) {
		new Test05();
	}

}
