package day14.ex;
/*
   문제 3 ]
   	
   		학생 한 명의 성적을 관리하는 클래스 student를 제작하라
   		기억할 내용은 반, 이름, 국어, 영어, 수학, 총점
   		함수는 필요한 만큼 추가하라
   		단, 학생의 반과 이름이 같으면 같은 학생으로 처리되도록 하라
   		학생 변수를 출력하면 모든 내용이 출력되도록 함수를 오버라이딩하라
 */
public class Ex03 {

	public Ex03() {
		//학생 객체 만들고
		Student stud1 = new Student("이제리", 9, 95, 100, 80);
		Student stud2 = new Student("이제리", 5, 88, 30, 65);
		
		//결과값 변수
		boolean bool = stud1.equals(stud2);
		String result = (bool == true) ? "같은" : "다른"; 
		
		//출력
		System.out.println("stud1 학생과 stud2 학생은 " + result + " 학생입니다.");
		System.out.println();
		System.out.println("stud1 : \n\t " + stud1);
		System.out.println("stud2 : \n\t " + stud2);
		System.out.println();
		
	}

	public static void main(String[] args) {
		new Ex03();
	}

}
