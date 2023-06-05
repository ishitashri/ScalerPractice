package com.practise;

import java.util.ArrayList;
import java.util.Scanner;

public class Prog2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int n = s.nextInt();
		for (int i = 0; i < n; i++)
			list.add(s.nextInt());
		reverseArrayList(list);
		s.close();
	}

	// Method to reverse the ArrayList
	static void reverseArrayList(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i)+ " ");
		}
	}
}
