package day14;

public class Nemo {
	
	private int width, height, area;
	//생성자의 갯수 = 클래스를 객체로 만들 수 있는 방법의 갯수
	public Nemo() {}//1. 아무것도 안 정하고 객체를 만들 수 있는 경우
		//생성자 함수를 하나도 정의하지 않으면 JVM이 이 클래스를 객체로 만들 때
		//기본 생성자를 만들어서 사용하게 된다.
		//만약 생성자를 하나라도 만들면 JVM이 이 작업을 하지 않는다.
		//따라서 생성자를 정의하는 경우 기본 생성자도 정의하는 것이 좋다.
	
	public Nemo(int width, int height) {//2. 가로, 세로 정해져야만 객체로 만들 수 있는 경우	
		this.width = width;
		this.height = height;
		setArea();
	}
	
	//1. 면적 계산 함수
	public void setArea() {
		// 이 함수를 호출하는 순간은 이미 가로와 세로가 결정이 된 후
		// 이미 필요한 데이터가 준비돼 있고 접근이 가능하므로 전달받지 않아도 된다.
		area = width * height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}

	//2. 이 클래스의 내용을 문자열로 반환해주는 함수
	//출력 시 자동호출되는 함수
	@Override
	public String toString() {
		return "사각형 - 가로 : " + width + " , 세로 : " + height + " , 면적 : " + area;
	}

	

 	//3. 면적이 같으면 같은 사각형이 되도록 처리해주는 함수
		//주소 비교하는 함수를 오버라이딩한 것
	
	 
	//Object 클래스의 equals() 를 오버라이딩,  반환값, 함수이름, 매개변수 동일해야함.
	//면적만 같으면 같은 사각형으로 처리
	// 1. 나의 네모와 다른 네모 면적 비교
	// 2. 
	@Override
	public boolean equals(Object o) {//equals()는 Object 클래스 소속 함수이니까 매개변수가 Object 타입임
		//반환값 변수
		boolean bool = false;
		
		//Object 타입으로 입력된 데이터를 원래 형태(Nemo)로 강제 형변환
		//Nemo nam = (Nemo) o;
		Nemo nam = null;// try 블럭 밖에서도 사용해야 하는 변수
		
		try {
			nam = (Nemo) o;
		} catch (Exception e) {
			//만약 입력된 객체가 Nemo 타입으로 강제 형변환할 때 예외가 발생하면 
			//이 작업 이후의 모든 작업들은 실행 자체가 무의미함
			//따라서 이 함수의 실행 결과는 "다르다"가 될 것이고
			//이 함수의 실행을 즉시 멈춰줘야 한다.
			return false;
		}
		
		//남의 것 면적 꺼내오고
		int myunjuk = nam.getArea();//area 변수는 private으로 은닉화, 바로 접근 불가라서 함수로 접근 
		
		//비교해서 결과 만들고
		bool = this.area == myunjuk;
		
		return bool;
	}

	//toString() : 문자열로 출력
}
