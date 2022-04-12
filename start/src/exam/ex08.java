package exam;

import java.util.*;
public class ex08 {

	public ex08() {
		HashMap map = new HashMap();
		
		map.put("이름", "홍길동");
		map.put("나이", "24");
		map.put("성별", "남자");
		
		System.out.println("이름 - " + map.get("이름"));
		System.out.println("나이 - " + map.get("나이"));
		System.out.println("성별 - " + map.get("성별"));
	}

	public static void main(String[] args) {
		new ex08();
	}

}
