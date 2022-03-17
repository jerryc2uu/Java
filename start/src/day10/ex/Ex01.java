package day10.ex;
/*
   문제 1 ]
   		다음 변수를 가지는 Student 클래스를 제작하라
   		
   		String name;
   		int ban, no, kor, eng, math;
   		
   		
   		클래스 만들고
   		
   		이 클래스에서
   			한 명의 데이터를 입력해서 출력
   			
   			5 명의 데이터를 배열로 만들어서 데이터 입력하고 출력
   			
   		1. 한 개의 함수 내에서 처리하기
   		2. 기능별로 분리해서 함수 만들어서 처리
   			
   		보너스 ]
   			int rank, total;
   			double avg;
   		    
   		
 */
public class Ex01 {
	
	String[] names;
	int[] bans, nos, kors, engs, maths;
	Student[] stud;
	
	public Ex01() {
		//1. 데이터 셋팅
		setData();
		
		//2. 배열 완성
		setStud();
		
		//3. 출력
		toPrint();
		
	
		
	}
	
	 
	//1. 각 데이터 초기화해주는 함수
		public void setData() {
			names = new String[] {"엄마", "아빠", "소연", "동생", "제리"};
			bans = new int[] {1, 2, 3, 4, 5};
			nos = new int[] {21, 22, 23, 24, 25};
			kors = new int[] {50, 70, 100, 80, 95};
			engs = new int[] {100, 50, 79, 46, 28};
			maths = new int[] {60, 70, 40, 98, 55};
		}
		
	//2. 위 데이터를 Student[] 타입의 데이터로 바꿔주는 함수
		public void setStud() {
			stud = new Student[5];
			
			for(int i = 0 ; i < stud.length ; i++) {
				stud[i] = new Student();
			}
			
			for(int i = 0 ; i < stud.length ; i++) {
				Student s = stud[i];
				
				s.setName(names[i]);
				s.setBan(bans[i]);
				s.setNo(nos[i]);
				s.setKor(kors[i]);
				s.setEng(engs[i]);
				s.setMath(maths[i]);
			}
		}
		
		//3. Student 배열 내용 출력해주는 함수
		public void toPrint() {
			for (int i = 0 ; i < stud.length ; i++) {
				
				String name = stud[i].getName();
				int ban = stud[i].getBan();
				int no = stud[i].getNo();
				int kor = stud[i].getKor();
				int eng = stud[i].getEng();
				int math = stud[i].getMath();
				
				System.out.println("이름 : " + name);
				System.out.println("반 : " + ban);
				System.out.println("번호 : " + no);
				System.out.println("국어 : " + kor);
				System.out.println("영어 : " + eng);
				System.out.println("수학 : " + math);
				System.out.println();
			}
		}
			
			
			
	
	public static void main(String[] args) {
		new Ex01();

	}
}
