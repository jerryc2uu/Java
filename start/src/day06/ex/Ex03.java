package day06.ex;

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
   
 */
public class Ex03 {

	public static void main(String[] args) {
		
		//1.
		for(int i = 0; i < 5; i++) {
			for(int j = 0 ; j < 5; j++) {	
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		
		//2.
		for(int i = 0 ; i < 1 ; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println((i+1) + " " + (i+2) + " " + (i+3) + " " + (i+4) + " " + (i+5) + " ");
			}
		}
		System.out.println("=============================================");		
		
		
		//3.
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 1; j++) {
				System.out.println((i+1) + " " + (i+2) + " " + (i+3) + " " + (i+4) + " " + (i+5) + " ");
			}
		}
		System.out.println("=============================================");		
		
	
		//4.
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {	
					if(j <= i)
					System.out.print((j + 1) + " ");
					continue;
				}
			System.out.println();
			}
		System.out.println("=============================================");	
		
		//5.
		int k = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {				
				if(j <= i) {
					System.out.print(++k + " ");
					continue;
				}
			}
			System.out.println();
		}
	}

}
