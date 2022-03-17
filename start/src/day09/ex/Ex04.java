package day09.ex;
/*
   문제 04 ]
   		1차원 배열에 정수 10개를 입력한 후 
   		합계와 평균을 구해주는 프로그램을 작성하라
   		
   		배열에 정수를 랜덤하게 채워주는 함수
   		합계를 구해주는 함수
   		평균 계산해주는 함수
   		출력해주는 함수
 */
public class Ex04 {

	
	public Ex04() {
		
		int[] no = getArr();
		
		toPrint(no);
	}

	// 1. 정수 10개를 랜덤하게 입력해주는 함수
	public int[] getArr() {
		
		int[] arr = new int[10];
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
		}
		return arr;
	}
	// 2. 합계 구해주는 함수
	public int addAll(int[] arr) {
		//합계 변수 초기화
		int sum = 0;
		
		//하나씩 꺼내서 더해주고
		for(int i = 0 ; i < arr.length ; i++) {
			sum = sum + arr[i];
		}
		return sum;	
	}
	// 3. 평균 구해주는 함수
	public double setAvg(int[] arr) {
		double avg = addAll(arr) / 10;
		return avg;
	}
	// 4. 출력해주는 함수
	public void toPrint(int[] arr) {
		System.out.print("전체 배열 : ");
		for(int n : arr) {
			System.out.print(n + ", ");
		}
		System.out.println();
		System.out.print("전체 합계 : ");
		System.out.println(addAll(arr));
		System.out.print("전체 평균 : ");
		System.out.println(setAvg(arr));
	}
	
	
	public static void main(String[] args) {
		new Ex04();

	}

}
