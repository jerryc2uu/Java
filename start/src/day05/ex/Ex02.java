
package day05.ex;

/*
  Ex 02 ]
     'A'부터 문자를 10개를 만들어서 출력하세요.
      
 */
public class Ex02 {

	public static void main(String[] args) {
		
		for(int i = 0 ; i < 10 ; i++) {
			char ch = (char)(Math.random() * ('Z' - 'A' + 1) + 'A');
			
			System.out.println(ch + " ");
		}
		System.out.println();
		
		int i = 0;
		for( i = 0 ; i < 10 ; i++) {
			char ch = 'A';
			System.out.println((char)(ch + i) + " ");//문자와 정수의 연산 결과는 정수가 나온다. 따라서 강제형변환 필요
		}
		System.out.println();
        System.out.println("### i : " + i);
		
        for( i = 0 ; i < 10 ; i++) {
        	System.out.println((char)('A' + i) + " ");
        }
			
	}

}