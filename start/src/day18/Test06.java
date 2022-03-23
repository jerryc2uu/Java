package day18;
/*
   <객체의 직렬화>
   
   제니의 정보를 Friend 클래스를 이용해서 파일에 저장해보자

   보조 스트림 ObjectOutputStream 이용해서 클래스 통째로 저장한다는 뜻
   
 */
import java.io.*;
public class Test06 {

	public Test06() {
		//기본 스트림 => 보조스트림이 바이트 기반이므로
		FileOutputStream fout = null;
		//보조 스트림(직렬화는 바이트 기반)
		ObjectOutputStream oout = null;
		
		//데이터 만들고
		Friend jn = new Friend();
		jn.setName("제니");//변수의 접근 지정자가 private이므로 함수로 접근한다.
		jn.setTel("010-1111-1111");
		jn.setMail("jennie@githrd.com");
		jn.setAddr("YGM");
		jn.setBlood("AB");
		jn.setAge(27);
		jn.setHeight(165.5f);//리터럴 형변환 필요
		jn.setGen('F');
		jn.setRh(true);
		
		try {
			// 스트림 연결
			fout = new FileOutputStream("src/day18/result/jennie.txt");
			oout = new ObjectOutputStream(fout);
			
			//준비된 데이터를 쓰고 파일에 쓴다
			oout.writeObject(jn);//이처럼 클래스 전체를 입출력하는 행위를 직렬화라고 한다.
			
			System.out.println("*** 저장 성공 ***");
			//저장은 되지만 파일이 깨진다.
			//ObjectOutputStream으로 저장한 건 ObjectInputStream으로 읽어야 하기 때문
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
				fout.close();
			} catch(Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {
		new Test06();
	}

}
