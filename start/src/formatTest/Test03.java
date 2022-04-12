package formatTest;

import java.text.*;
public class Test03 {

	public Test03() {
		/*
		 	ChoiceFormat 만들 때 limits와 format을 하나로 만들 수도 있다.
		 	
		 	[형식]
		 		60#D : <= 60
		 		70<C : < 70
		 		
		 		이것을 |로 연결해서 사용
		 		
		 */
		
		String pattern = "0#F|60#D|70#C|80#B|90<A";
		
		//0#F : 0 <= 의미..
		
		ChoiceFormat form = new ChoiceFormat(pattern);
		int score = 90;
		String grade = form.format(score);
		
		//출력
		System.out.println("점수 : " + score);
		System.out.println("학점 : " + grade);
	
	}

	public static void main(String[] args) {
		new Test03();
	}

}
