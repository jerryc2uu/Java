package day06.solv;

/*
   문제 3 ]
   		
   1 1 1 1 1 
   2 2 2 2 2 
   3 3 3 3 3 
   4 4 4 4 4 
   5 5 5 5 5 
   
   중첩된 for 명령으로 처리하세요.
   
   1 2 3 4 5
   1 2 3 4 5
   1 2 3 4 5
   1 2 3 4 5
   1 2 3 4 5
 
   1 2 3 4 5
   2 3 4 5 6
   3 4 5 6 7
   4 5 6 7 8
   5 6 7 8 9

   1  2  3  4  5
   6  7  8  9  10
   11 12 13 14 15
   16 17 18 19 20
   21 22 23 24 25
   
   1
   1 2
   1 2 3
   1 2 3 4
   1 2 3 4 5
   
   1
   2 3
   4 5 6
   7 8 9 10
   11 12 13 14 15
   
   0	  ==> 0	
   1 2    ==> i = 1
   3 4 5  ==> 0 + 1 + 2	
   6 7 8 9 
   
   
 */
public class Ex03 {
	
	public Ex03() {
		
		System.out.println("1번");
		
		System.out.println("6번=============================");
		
		int no = 1;
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				System.out.print(no++ + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		new Ex03(); // 생성자 함수 호출
	}

}
