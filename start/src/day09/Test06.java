package day09;
/*
 
 */
public class Test06 {
	int num;//랜덤한 숫자, 기억하고 있는 숫자가 다름
	
	public Test06() {
		setNum();
	}
	public static void main(String[] args) {
		new Test06();//heap 영역에 클래스 내용을 올려놓기만 한 것, 주소를 할당받지 않은 상태
		Test06 t6 = new Test06();// t6이 기억하고 있는 건 이것 뿐
		t6.num = 100;//100, 기억하고 있는 숫자가 다름
		
		//new -> heap에 뭔가 만들겠다, 
	}

	public void setNum() {
		int no = (int)(Math.random() * 10 + 1);
		num = no;
		
		//return no;
	}
}
