package day18;
/*
   이미지 파일을 문자 단위 스트림으로 복사해보자
    result / Juyeon.jpg ==> Juyeon_copy.jpg
   원칙은 문자 기반 스트림으로 주고받으면 안 된다.
   바이트코드가 역순이 될 수 있기 때문에
   
   이미지는 문자 단위가 아니라 바이트 코드(2진수)다. 
   따라서 복사된 이미지 파일이 보이지 않는 게 정상
 */
import java.io.*;
public class Test03 {
	public Test03() {
		//복사는 읽어서 쓰는 것이니 기본 스트림 2개 필요
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("src/day18/result/Juyeon.jpg");
			fw = new FileWriter("src/day18/result/Juyeon_copy.jpg");
			
			char[] buff = new char[1024];
			
			//몇 번 반복해야 하는지 알 수 없으므로
			while(true) {
				//char[] buff = new char[1024];//new 시킨다는 건 heap에 뭔가 만든다는 것, 매번 배열을 반복 생성한다는 것이기에 비효율적
				//한 쪽에서 읽어서 읽은 갯수 만큼 배열에 채워주고
				int len = fr.read(buff);
				
				//읽은 데이터가 없는 경우 즉시 종료
				if(len == -1) {
					break;
				}
				
				//읽은 데이터가 있는 경우 다른 쪽에 내용을 쓴다.
				fw.write(buff, 0, len);
			}
			
			//결과 출력
			System.out.println("*** 주연 사진 복사 성공 ***");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//종속적인 관계가 아니기 때문에 순서 상관 없음
				fw.close();
				fr.close();
				
			} catch(Exception e) {
				
			} 
		}
	}
				

	public static void main(String[] args) {
		new Test03();
	}

}
