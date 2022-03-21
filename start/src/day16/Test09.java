package day16;

import java.io.*;
import java.util.*;

public class Test09 {
/*
 	Properties로 Map 데이터 사용하다가 파일에 저장해보기
 */
	public Test09() {
		Properties prop = new Properties();
		prop.put("name", "홍길동");
		prop.put("age", "16");
		prop.put("tel", "010-1111-1111");
		prop.put("addr", "율도국");
		
		// 이렇게 Map처럼 작업을 하다가 
		// 보관해야 할 필요가 생기면 이 데이터를 모두 파일에 기록하면 된다.
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("src/day16/result.txt");
			// fout은 파일에 연결돼 있다. 데이터를 내보내기만 하면 된다.
			prop.store(fout, "적당히 메세지 쓰세요!");
			//이 작업이 문제 없이 완료되면 이미 파일에 저장되어 있는 상태가 된다.
			System.out.println("**** 파일 저장 성공 *****");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fout.close();
			} catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		new Test09();
	}

}
