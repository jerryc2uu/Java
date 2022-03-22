package day17;
/*
    doc 폴더 안의 파일의 목록을 알아내보자 
    
 */
import java.io.*;
public class Test05 {

	public Test05() {
		//목록을 알아내고 싶은 폴더를 파일로 만든다
		File dir = new File("doc");
		
		/*
		//1. 목록을 꺼내보자
		String[] flist = dir.list();
		
		//출력
		for(String f : flist) {
			System.out.println(f);
		}
		
		//2. 파일에 대한 정보도 꺼내보자
		File[] infoList = dir.listFiles();
		
		//정보 출력
		for(File f : infoList) {
			String fName = f.getName();//파일 이름 꺼내는 함수
			long len = f.length();//파일 사이즈 추출 함수
			String pold = f.getParent();//상위 폴더 이름 추출 함수
			
			//출력
			System.out.println("상위 폴더 : " + pold + " , 파일 이름 " + fName + " , 사이즈 : " + len + " byte");
		}
		 */
		
		//3. 확장자가 jpg인 파일만 골라서 출력하고 싶다
		String[] flist = dir.list(new FilenameFilter() {//무명 내부 클래스 => list 함수가 실행될 때 File~ 상속 받은 무명 객체 안의 accept 함수가 실행
			@Override
			public boolean accept(File dir, String name) {
				/*
				  이 함수는 자동 호출
				  목록을 구하는 파일을 하나씩 발견할 때마다 이 함수가 호출될 텐데
				  이 함수에서 true를 반환하면 해당 목록을 결과에 포함시키고 
				  			  false를 반환하면 해당 목록을 결과에 포함시키지 않는다.
				  
				  따라서 포함된 파일들을 여기서 정의해주면 된다.
				  
				  매개변수   File dir : 현재 파일의 정보 알려주는 데이터
				  			 String name : 현재 파일의 이름만 알려준다
				 */
				boolean bool = false;
				if(name.endsWith("jpg")) {//파일 이름이 jpg로 끝나는지 묻는 함수
					//이 경우는 결과 목록에 이 파일을 포함시킨다.
					bool = true;
				} /*else {
					bool = false;
					bool 변수는 초기값이 이미 false 이므로 생략해도 무방
				}*/
				return bool;
				
				//return name.endsWidth("jpg"); 로 전체 축약 가능
				//이 경우처럼 상속받아 오버라이딩 해야 하는 함수의 내용이 극도로 짧은 경우는 
				//이 예제처럼 무명 내부 클래스로 처리하는 것이 일반적이다.
			}
		});
		
		for(String f : flist) {
			System.out.println(f);
		}
	}

	public static void main(String[] args) {
		new Test05();
	}

}
