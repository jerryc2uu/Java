package day17;
/*
   1. result 패키지에 폴더를 강제로 만들어보자.
   2. 계층화된 폴더를 강제로 만들어보자.
   3. 만들어진 파일 중 하나를 삭제한다.(폴더도 파일로 간주되므로 삭제 가능하다.)
   4. 만들어진 파일 중 하나를 다른 이름으로 변경시켜보자.
 */

import java.io.*;
public class Test04 {

	public Test04() {
		// 만들고 싶은 폴더(폴더가 위치에 없어도 상관없다.)를 파일로 만든다.
		/*
		// 1. 폴더 1개 생성
		
		File file = new File("src/day17/result/abc");//파일 객체를 만든 것
		String msg = file.mkdir() ? "폴더 생성 성공" : "폴더 생성 실패"; //파일 안에 있는 함수를 호출
		
		//2. 계층화된 폴더 생성
		File file = new File("src/day17/result/a/b/c/d");
		String msg = file.mkdirs() ? "폴더 생성 성공" : "폴더 생성 실패";
		
		//3. 2에서 만든 d 폴더를 삭제해보자
		File file = new File("src/day17/result/a/b/c/d");
		String msg = file.delete() ? "삭제 성공" : "삭제 실패";
		 */
		
		//4. 변경 작업
		// 4-1 현재 파일과 바꿀 이름의 파일을 둘 다 File 객체로 만든다.
		File oldF = new File("src/day17/result/a/b/c");
		File newF = new File("src/day17/result/a/b/renameTest");
		
		//4-2 바꾸면 된다. renameTo() 호출
		String msg = oldF.renameTo(newF) ? "변경 성공" : "변경 실패";
		System.out.println("*** 결과 : " + msg);
		
	}

	public static void main(String[] args) {
		new Test04();
	}

}
