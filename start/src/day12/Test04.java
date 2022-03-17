package day12;

import java.util.*;
public class Test04 {
	
	public Test04() {
		//Calendar cal = new Calendar(); => 추상 클래스라서 new로 객체 생성 불가
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
	}
	
	public static void main(String[] args) {
		new Test04();
	}
}
