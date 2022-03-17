package day12;

import java.util.Arrays;

public class Test00 {
	// 일반명령은 못옴, 변수(객체의 속성)와 함수(객체의 기능)가 올 수 있음
	// 인스턴스의 주소를 기억하는 것이 레퍼런스
	public Test00() {
		int no = 10;
		int[] arr = {1, 2, 3, 4, 5};
		
		//arr = new int[] {1,2,3,4,5}; ==> 새로운 주소 생성
		
		no = addNo(no); // addNo(10);
		setArr(arr);
		
		System.out.println("no : " + no);
		System.out.println("arr : " + Arrays.toString(arr));
	}
	
	// no에 10을 더해서 결과를 no에 기억시키는 기능
	public int addNo(int no) {
		int sum = no + 10;
		return sum;
	}
	
	// arr 배열의 첫 번째 방의 데이터에 10을 더해주는 기능
	public void setArr(int[] arr) {
		arr[0] = arr[0] + 10;
	}
		
	public static void main(String[] args) {
		new Test00();

	}

}
