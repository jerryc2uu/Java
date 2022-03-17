package day08;

import java.util.Arrays;

/*
   얕은 복사의 특징
   	 : heap 영역에 있는 데이터는 프로그램이 종료할 때까지 살아남는다. (블럭이 닫혀도 사용 가능)
   	
 */
public abstract class Test03 {
	int[] no; // 스택에만 변수 만들어놓은 상태 (변수 선언만 한 상태), no에 배열이 채워지는 순간부터 변수 사용 가능
	
	public void setNo() {
		no = new int[5];
		for(int i = 0 ; i < no.length ; i++) {
			no[i] = (int)(Math.random() * 99 + 1);//블럭이 끝나면 이건 모두 못쓰게 되지만 no에 기억시켜 놨기 때문에 클래스 전체에서 사용 가능
			}
	}
	
	
	public static void main(String[] args) {
		
		int[] a; //배열의 주소를 기억할 변수만 만들어 놓은 것, 주소를 기억할 준비만 함.
		
		{//이것이 블럭, 영역을 나타낸다. 자바에서 중가로는 어떤 변수를 초기화해준다.
			
			int []	b;  // b변수는 블럭 안에서 만들어진 변수이므로 블럭을 벗어나면 사라지는 변수이다. 배열은 heap에 만들어진다. 
			            // 변수는 스택에 쌓임. 블럭이 사라지는 순간 스택의 변수는 사라짐. 배열에 접근할 방법은 사라진다. 이를 해결해주는 것이 얕은 복사.
			
			b = new int[5]; // new 라는 명령으로 heap에 배열을 만들고 변수에 기억시켰지만
			                // 블럭이 닫히는 순간 이 변수는 사라지게되므로 더이상 이 배열을 사용할 수 없게 된다.
			
			b[2] = 500;
			
			System.out.println("b[2] : " + b[2]);
			
			//얕은 복사를 한다.
		    a = b; // b가 기억하고 있는 주소를 a가 기억하도록. 
		    
		    a[2] = 1000;
		    System.out.println("b[2] : " + b[2]);
		    
		}
           System.out.println(Arrays.toString(a));//블럭 밖에서도 b 배열을 쓸 수 있어야 한다.			
           //System.out.println(Arrays.toString(b));// b는 접근 불가이기 때문에 a에 복사해서 a를 대신 쓴다.		
		}

	}


