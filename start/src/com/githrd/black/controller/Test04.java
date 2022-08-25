package com.githrd.black.controller;

/*
 	0  1  2   3   4
0	1  6  11  16  21   i + 1 + j * 5
1 	2  7  12  17  22
2	3  8  13  18  23
3 	4  9  14  19  24
4 	5  10 15  20  25
 */
public class Test04 {

	public Test04() {
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				int no = i + 1 + j * 5;
				System.out.printf("%3d", no);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Test04();
	}

}
