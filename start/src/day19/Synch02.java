package day19;
/*
   ArrayList 하나를 준비해서 
   이 곳에 데이터를 넣고 빼보자
   즉, 1번 스레드는 이 곳에 데이터를 입력할 예정이고
   	   2번 스레드는 이 곳에서 데이터를 가지고 갈 예정이다.
   	   
   규칙
   		5개의 데이터가 입력되면 더 이상 입력하면 안 된다.
 */
import java.util.*;
public class Synch02 {
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public Synch02() {
		
		DataThread01 t1 = new DataThread01(this);
		DataThread02 t2 = new DataThread02(this);
		
		t1.start();
		t2.start();
	
	}
	
	//1. list에 데이터 채워주는 함수
	synchronized void makeData(int num) {
		if(list.size() == 5) {
			//데이터가 5개 채워져 있으므로 작업을 하면 안 된다.
			try {
				System.out.println("### 채우는 작업 완료 ###");
				wait();//동기화 함수 안에서만 사용 가능
				//이 순간 wait()를 사용하는 스레드는 스스로가 Block 상태로 전위된다.
			} catch(Exception e) {}
		}
		
		//list에 숫자 하나를 채운다.
		list.add(num);
		System.out.println(num + " 를 채웠습니다.");
		System.out.println("<> 채운 후 데이터의 갯수는 " + list.size() + " 개가 있습니다.");
		
		//이렇게 숫자를 채우면 숫자를 사용할 수 있는 상태가 된다.
		//하나라도 채워졌으면 다른 스레드를 깨워서 숫자를 꺼내게 한다.
		notify();//가장 먼저 Block 상태로 들어간 스레드가 일을 하게 된다.
			
	}
	
	//2. list에서 데이터 꺼내주는 함수
	synchronized void useData() {
		if(list.size() == 0) {
			//채워진 데이터가 없으므로 이 스레드는 데이터를 꺼내서 사용할 수 없다.
			//따라서 스스로 Block 상태로 전위되어야 한다.
			try {
				System.out.println("\t\t데이터 꺼내는 작업 잠시 멈춤...");
				wait();
			} catch(Exception e) {}
		} 
		
		int no = list.get(0);//첫번째 방의 데이터 꺼낸다.
		//꺼낸 데이터는 list에서 제거한다.
		list.remove(0); // 꺼낸 데이터를 제거했으므로 입력할 수 있는 공간이 하나 더 생겨난 것
		System.out.println("\t\t" + no + " 를 꺼냈습니다.");
		System.out.println("\t\t남아있는 데이터의 갯수는" + list.size() + " 개 남았습니다.");
		//데이터를 추가할 수 있는 공간이 추가되었으니 다시 데이터를 채우는 작업을 깨운다
		notify();
	}

	public static void main(String[] args) {
		new Synch02();
	}

}

class DataThread01 extends Thread {
	Synch02 main; // 주소 기억할 준비
	
	public DataThread01() {}

	public DataThread01(Synch02 main) {
		this.main = main;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < 50 ; i++) {
			int no = (int)(Math.random()*99+1);
			main.makeData(no);
			
			int sec = (int)(Math.random()*1501 + 500);
			
			try {
				Thread.sleep(sec);
			} catch(Exception e) {}
		}
	}
	
}

class DataThread02 extends Thread {
	Synch02 main; // 주소 기억할 준비
	
	public DataThread02() {}

	public DataThread02(Synch02 main) {
		this.main = main;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < 50 ; i++) {
			main.useData();
			
			int sec = (int)(Math.random()*1501 + 500);
			
			try {
				Thread.sleep(sec);
			} catch(Exception e) {}
		}
	}
	
}


