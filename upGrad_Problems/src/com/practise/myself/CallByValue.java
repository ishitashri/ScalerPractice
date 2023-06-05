package com.practise.myself;

public class CallByValue {

	public static void main(String[] args) {
		int a = 3;
		passByValue(a);
		System.out.println("value of a "+a);
	}
	
	public static void passByValue(int a) {
		a = 13;
	}
}
