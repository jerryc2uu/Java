package com.githrd.black.controller;

public class Test05 {

	public Test05() {
		
		int year = 0;
		if(year % 400 == 0) {
			System.out.println("윤년");
		} else if(year % 100 == 0) {
			System.out.println("평년");
		} else if(year % 4 == 0) {
			System.out.println("윤년");
		}
	}

	public static void main(String[] args) {
		new Test05();
	}

}
