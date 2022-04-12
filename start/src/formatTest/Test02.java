package formatTest;
/*
 	학생 점수를 입력 받아서 학점 출력하는 프로그램 작성
 		
 		100			A
	 	90 - 99		A
	 	80 - 89		B
	 	70 - 79		C
	 	60 - 69		D
	 	0 - 59		F
	 	
	 	switch(score) {
	 	case 10:
	 		A
	 		break;
	 	case 9:
	 		A
	 		break;
	 	case 8:
	 		B
	 		break;
	 	case 7:
	 		C
	 		break;
	 	case 6:
	 		D
	 		break;
	 	default:
	 	}
 */
import java.text.*;
public class Test02 {

	public Test02() {
			double[] limits = {0, 60, 70, 80, 90};
			/*
			 	<limits를 만들 때 주의사항>
			 		반드시 오름차순 정렬해서 만든다..
			 		의미 : 0 ~ 59 사이는 하나의 문자로 바꾸고
			 			   60 - 69
			 			   ....
			 			   90 - 	하나의 문자로 바꿔라	
			 */
			String[] formats = {"F", "D", "C", "B", "A"};
			/*
			 	<formats 만들 때 주의사항>
			 		limits 갯수와 동일하게 만든다
			 */
			ChoiceFormat form = new ChoiceFormat(limits, formats);
			
			//랜덤하게 정수 발생 시켜서 그 점수의 학점 출력
			int score = (int)(Math.random() * 101);
			
			//학점 추출
			String grade = form.format(score);
			
			//출력
			System.out.println("점수 : " + score);
			System.out.println("학점 : " + grade);
			
	}
	
	public static void main(String[] args) {
		new Test02();
	}

}
