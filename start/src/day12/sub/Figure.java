package day12.sub;

public interface Figure {
//	int area = 10; // 변수 선언만 하면 자동으로 static final 변수가 됨, 초기화도 필요
	
	void setArea();
	/*
	   인터페이스 소속 함수는 자동적으로 public abstract로 만들어짐
	   어디서든지 오버라이딩할 수 있는 추상함수여야하기 때문
	 
	*/
	
	void toPrint();
}
