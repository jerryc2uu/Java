package day16;
//<map 계열>

//HashTable에 친구의 정보를 기억시켜보자.
import java.util.*;
public class Test02 {

	public Test02() {
		
		Hashtable table = new Hashtable();
		
		//데이터 추가
		table.put("이름", "제니"); //상위 클래스가 다르기 때문에 데이터 입력하는 함수도 다른 것
		//이처럼 Map 계열은 데이터를 입력할 때 키값과 데이터를 한쌍으로 만들어서 입력해야 한다.
		table.put("나이", "27");
		table.put("전화", "010-1111-1111");
		
		//데이터 꺼내서 출력
		System.out.println("이름 : " + table.get("이름"));
		System.out.println("나이 : " + table.get("나이"));
		System.out.println("전화 : " + table.get("전화"));
		
		//데이터 수정
		table.put("전화", "010-1234-5678");
		
		/*
		  같은 키값으로 데이터가 입력되면 앞선 데이터를 삭제한 후
		  새로운 데이터로 교체한다.
		  즉, 같은 키값은 한 개의 데이터만 기억할 수 있다.
		  ==> 데이터는 중복될 수 있지만 키값은 중복될 수 없다는 뜻
		 */
		
		table.put("name", "제니");
		//데이터 꺼내서 출력
		System.out.println();
		System.out.println("이름 : " + table.get("이름"));//키값은 중복 불가, 교체됨
		System.out.println("나이 : " + table.get("나이"));
		System.out.println("전화 : " + table.get("전화"));
		System.out.println("name : " + table.get("name"));//데이터 중복 가능
		
		System.out.println();
		int len = table.size(); //저장된 데이터의 갯수 반환해주는 함수
		
		
		//데이터만 추출
		Collection col = table.values();
		Iterator itor = col.iterator();
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
		System.out.println();
		
		
		//키값만 추출==> map 전달 받았는데 어떤 키값이 있는지 모를 때 사용
		Enumeration en = table.keys();
		while(en.hasMoreElements()) {
			Object o = en.nextElement();
			System.out.println(o);//키값만 출력
			System.out.println("\t : " +table.get(o));//위의 키값 이용해서 데이터 출력
		}
		System.out.println();
		
		//키값만 추출 2번 
		Set set = table.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Object o = it.next();//키값 꺼냄
			Object data = table.get(o);//키값으로 데이터 꺼냄
			//출력
			System.out.println(o + " - " + data);
		}
		
		System.out.println();
		
		//정 이해 안 가면 스킵...
		//entrySet()  map에는 데이터가 여러 개 채워질 수 있다. 이걸로 map.entry를 만들어서 Set에 넣은 것
		Set entry = table.entrySet();//Set 1개 = Map.entry 타입 데이터 여러 개//Map.entry 객체 한 개 = key와 value가 한 쌍인 vo클래스
		Iterator it3 = entry.iterator();
		while(it3.hasNext()) {
			Map.Entry en1 = (Map.Entry) it3.next();//Object로 꺼내진 걸 원래 형태로 강제 형변환
			Object key = en1.getKey();
			Object value = en1.getValue();
			System.out.println(key + " : " + value);
		}
			
		
	}

	public static void main(String[] args) {
		new Test02();
	}

}
