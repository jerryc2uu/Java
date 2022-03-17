package day09.ex;
/*
    문제 05 ]
    	10 학생의 국어, 영어, 수학 점수를 랜덤하게 입력받아서 
    	총점과 석차를 구하는 프로그램을 작성하세요
    	
    	각 학생의 점수입력, 총점 계산, 석차계산, 출력 함수 처리
 */
public class Ex05 {
	
	
	public Ex05() {
		// 배열 셋팅
		int[][] stud = new int[10][5];
		//점수 만들고
		setArr(stud);
		//총점 구하고
		for(int i = 0 ; i < stud.length ; i++) {
			int[] no = stud[i];
			setTotal(no);
		}
		//석차 구하고
		for(int i = 0 ; i < stud.length ; i++ ) {
			int[] no = stud[i];
			setRank(no);
		}
	}
	
	//1. 10 학생의 3 과목 관리하는 배열 함수
	public void setArr(int[][] score) {
		for(int i = 0 ; i < score.length ; i++) {
			for(int j = 0 ; j < score[i].length ; j++) {
				score[i][j] = (int)(Math.random() * 41 + 60);
			}
		}
	}
	
	//2. 한 학생의 점수 배열 입력하면 총점 계산하는 함수
	public void setTotal(int[] score) {
		int sum = 0;
		//입력된 점수 누적해서 더해주고
		for(int i = 0 ; i < score.length - 2; i++) {
			sum = sum + score[i];
		}
			score[score.length -2] = sum;
	}
	
	//3. 석차 계산하는 함수
	public void setRank(int[][] score) {
		
		//한 학생 점수 꺼내주고
	
			
	}	
	//4. 출력하는 함수
	public void toPirnt() {
		
	}
	
	public static void main(String[] args) {
		new Ex05();
	}

}
