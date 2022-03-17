package day14;

/*
	Hey boy
	Make 'em whistle like a missile, bomb, bomb
	Every time I show up, blow up, uh
	Make 'em whistle like a missile, bomb, bomb
	Every time I show up, blow up, uh
   
    위 문자열을 행 단위로 결합해서 처리해보자.
    
 */

public class Test03 {

	public Test03() {
		//문자열 변화가 심한 경우 StringBuffer로 결합 작업을 해주는 게 좋다.
		
		//1. 객체 만들고
			StringBuffer buff = new StringBuffer();
			
		//2. 반복해서 결합 작업
		buff.append("Hey boy\n");
		buff.append("Make 'em whistle like a missile, bomb, bomb\n");
		buff.append("Every time I show up, blow up, uh\n");
		buff.append("Make 'em whistle like a missile, bomb, bomb\n");
		buff.append("Every time I show up, blow up, uh\n");

		//3. 문자열로 변환
		String song = buff.toString();
			
		//4. 출력
		System.out.println(song);
		
		/*
		   이 클래스는 데이터베이스에서 작업할 때 
		   질의명령을 만들 때 많이 사용
			
			질의명령 : DB에 요청하는 문장
			 
			 	ex) SELECT
			 			mno, id, name, email, tel, gen
			 		FROM
			 			member
			 		WHERE
			 			isshow = 'Y'
			 			
			 		StringBuffer buff = new StringBuffer();
			 	
			 		buff.append("SELECT");
			 		buff.append("mno, id, name, email, tel, gen");
			 		buff.append("FROM");
			 		buff.append("member");
			 		buff.append("WHERE");
			 		buff.append("isshow = 'Y'");
			 				
			 		buff.toString()를 호출해서 필요한 순간에 문자열로 변환
			 			
		 */
			 				
			 					
			 				
			 					
	 
		
		
		
}

	public static void main(String[] args) {
		new Test03();
	}

}
