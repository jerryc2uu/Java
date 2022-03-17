package day08;

/*
    랜덤하게 다섯명의 학생의 점수를 만들어서 배열에 기억 시키고
    각 학생의 석차도 기억할 배열을 만들어서 결과를 출력하라
    
 */
public class Test02 {

	public static void main(String[] args) {
		//1. 다섯 명의 점수 기억할 배열 만들기
		//int[] score = new int[]; {1, 1, 1, 1, 1}
		int[] score = new int[5];
		
		//2. 석차 기억할 배열 만들기
		int[] stud = new int[5];
		//초기값 셋팅하고
		for(int i = 0 ; i < stud.length ; i++) {
			stud[i] = 1;
		}
		
		// 점수 랜덤하게 만들어서 입력
		for(int i = 0 ; i < score.length; i++) {
			int no = (int)(Math.random() * 41 + 60);
			
			score[i] = no; 
		}
		//3. 석차 계산
		for (int i = 0 ; i < score.length ; i++) {
			//내 점수를 뽑아내는 반복문
			for (int j = 0 ; j < score.length ; j++) {
				//다른 학생 점수 뽑아내는 반복문
				if(score[j] > score[i]) {
					stud[i] = stud[i] + 1;
					
			    }
			}
		
		}
		
		//4. 출력
		/*
		  출력 형식 ]\
		 	 
		 	 A 학생 90점 2등
		 	 
		 */

		for (int i = 0 ; i < stud.length; i++) {
			//학생
			String man = (char)('A' + i) + " ";
			//점수
			int num = score[i];
			//등수
			int rank = stud[i];
			//출력
			System.out.println(man + " 학생 : " + num + "점 - " + rank + "등 입니다.");
		}
	}

}
