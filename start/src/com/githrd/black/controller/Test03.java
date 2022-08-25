package com.githrd.black.controller;

/*
0 			*		< 5 + 0	  *		<= 3 == < 4  : ' '
1 		   ***		< 5 + 1   *		<= 2 == < 3
2		  *****		< 5 + 2					< 2
3 		 *******							< 1
4 		*********							
 	j < no - 1 + i + 1
 	j < no  + i
 */
import java.util.*;
public class Test03 {

	public Test03() {
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("숫자 입력 : ");
		
			String sno = sc.nextLine();
			
			if(sno.equals("q")) break;
			
			int no = 0;
			
			try {
				
				no = Integer.parseInt(sno);
				
				for(int i = 0 ; i < no ; i++) {
					for(int j = 0 ; j < no + i ; j++) {
						char ch = '*';
						
						if(j < no - 1 - i) {
							ch = ' ';
						}
						System.out.print(ch);
					}
					System.out.println();
				}
			} catch(Exception e) {
				continue;
			}
		}
		
		Math.abs(-10); //절댓값 반환 함수
	}

	public static void main(String[] args) {
		new Test03();
	}

}
