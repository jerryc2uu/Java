package day07;

/*
  
   1 ~ 10 까지의 정수를 순서대로 배열해 기억시키고
   이 숫자를 랜덤하게 섞어서 출력되도록 하세요.
   
   방법 ]
       배열의 특정 위치 두 개를 꺼내서 데이터를 바꾼다.
       이 과정을 많이 하면 할수록 데이터가 섞이게 된다.
       
   
 */
public class Test06 {

	public static void main(String[] args) {
		
		// 1. 배열 만들기 ( 1 ~ 10 기억하는)
		int [] num = new int[10];
		for(int i = 0 ; i < 10 ; i++) {
			num[i] = i + 1;
		}//배열 준비 완료
		
		//출력
				for(int no : num) {
					System.out.print(no + " ");
				}
					
				System.out.println();
		
		// 2. 임의의 숫자 두 개를 위치를 랜덤하게 만들어서 두 위치의 데이터를 서로 바꿔준다.
		//==> swapping
		
		for (int i = 0 ; i < 1000 ; i++) {
			int idx1 = (int)(Math.random() * (9 - 0 + 1) + 0);
			int idx2 = (int)(Math.random() * (9 - 0 + 1) + 0);
			
			if(idx1 == idx2) {
				i--;
				continue;
			}
			
			//원래 위치의 데이터를 변수에 기억시키고  
			int tmp = num[idx1];
			
			//두번째 위치의 데이터를 첫번째 위치에 기억시킨다.
			num[idx1] = num[idx2];
			num[idx2] = tmp;
			
		}
		
		//출력
		for(int no : num) {
			System.out.print(no + " ");
		}
			
		System.out.println();

	}

}
