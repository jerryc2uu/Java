package day18;
/*
   char 단위로 파일에 데이터를 저장하는 프로그램을 작성하라
   => 2byte씩 한 번에 처리한다는 것 말고는 바이트 기반과 차이가 없다.
 */
   
import java.io.*;
public class Test01 {

	public Test01() {
		//기본(타겟) 스트림 준비
		FileWriter fw = null;
		
		try {
			//어떤 코드를 쓴다는 건 new 시켜서 메모리에 올려야 한다는 것
			//new 시키는 법은 생성자 함수를 보면 알 수 있다. 생성자 함수의 갯수가 new 시킬 수 있는 갯수 의미
			//자바의 패키지 = 일반 시스템 폴더
			fw = new FileWriter("src/day18/result/휘파람.txt");//없으면 만들어줄 거라서 상관 없다.
			
			/*
			//1. 한 글자(2byte)만 출력
			char ch = '휘';
			fw.write(ch);
			System.out.println("***휘파람 저장 성공***");
			 */
			
			//2. 여러 글자 출력
			String str = "\t\t\t휘파람\r\n\t\t\t\t\t블랙핑크";
			//1byte씩 처리 예정이므로 어제는 byte[] 준비
			
			//2-1. (byte 기반처럼) char[]에 담아서 처리해보기
			//여기선 문자 단위로 처리 해야 하므로 문자배열을 준비한다.
			//문자열을 문자배열로 변환시켜주는 함수 : toCharArray()
			//char[] buff = str.toCharArray();//이미 함수에서 객체를 만들어서 내보내주기 때문에 new 시켜줄 필요 없다. buff가 기억만 하고 있으면 된다. 
			//fw.write(buff);
			
			//2-2.문자열 그대로 처리해보기
			fw.write(str);//이것도 가능하다. 문자 기반 스트림이기 때문에 문자 뿐 아니라 문자열 처리하는 함수도 따로 있다.
			
			/*
			  char 단위는 텍스트 데이터만 처리할 수 있기 때문에 
			  기본 함수에 문자 처리 기능이 추가되어 있다. 
			  fw.write(str); ==> (o)
			  
			  
			  FileReader/FileWriter는 따로 메소드가 없다. 상위 클래스의 함수를 그대로 쓰겠다는 것.
			  
			  문자열에서 문자 하나 추출하는 함수 :charAt()
			  특정 문자 인덱스 추출하는 함수 : IndexOf()
			  
			  문자를 문자열로 바꾸는 함수는 따로 없다. 
    		  String tmp = 'A' + ""; //문자를 문자열로 바꾸는 방법(항상 byte가 큰 쪽을 따르기 때문에)
			  이유? char는 기본 데이터 타입이고 객체가 아니며 따라서 변수나 함수가 없다. 
			  		따라서 wrapper 클래스(Character)가 생겼다. 여기서 자동으로 Boxxing, UnBoxxing이 일어난다.
			
			  ArrayList<int> list = ArrayList<int> (); ==> (x) 객체가 아니기에 불가능
			  ArrayList<Integer> list = ArrayList<Integer> (); ==> (o)
			 */
			
			  
			  
			System.out.println("*** 저장 성공 ***");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		new Test01();
	}

}
