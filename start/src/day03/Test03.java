package day03;

import javax.swing.*;

public class Test03 {
	public static void main(String[] args) {
		System.out.println('J' + 3.14); // 결과는 int형
		
		// 'J' 이후의 열번째 문자는 무엇인지 출력하세요.
		System.out.println("'J' 이후의 열번째 문자 : " + (char)('J' + 10));//int를 char로 형변환해준다.
		String msg = "'J' 이후의 열번째 문자 : " + (char)('J' + 10);
		JOptionPane.showMessageDialog(null, msg);
	}
}
