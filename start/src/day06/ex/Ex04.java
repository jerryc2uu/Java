package day06.ex;

/*
 	문제 4 ]
 		
 		다음 형태로 출력하세요.
*****
*****
*****
*****
***** 	

	
*****
****
***
**
* 		
 		
    *
   **
  ***	
 ****	
*****


  *
 ***
*****

*****
 ***
  *	

 */

public class Ex04 {

	public static void main(String[] args) {
		
		//1.
		for(int i = 0 ; i < 5; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		
		//2.
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if( i <= j) {					
				System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("=============================================");
		
		//3.
		for(int i = 5 ; 0 <= i  ; i--) {
			for(int j = 0 ; j < 5 ; j++) {
				if(i <= j) {					
				System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("============================================="); 
		
		//4.
		for(int i = 0 ; i < 3  ; i++) {
			System.out.println();
			for(int j = 0 ; j < 2 - i ; j++) {
				System.out.print(" ");
			}
			
			for(int j = 0 ; j < 2 * i + 1 ; j++) {
				System.out.print("*");
			}
		}
		System.out.println();
		System.out.println("============================================="); 
		
		
		//5. 
		
		
	}

}
