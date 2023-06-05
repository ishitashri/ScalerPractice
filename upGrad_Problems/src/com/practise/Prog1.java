package com.practise;

import java.util.ArrayList;

public class Prog1 {
	public static void main(String[] args) {
		ArrayList<Float> random = new ArrayList<>();
		random.add((float) 2);
		random.add((float) 4);
		random.add((float) 5);
		random.add((float) 10);
		random.add((float) 99.9);

		printArray(random);
	}

	public static void printArray(ArrayList<Float> random) {
		for (Float float1 : random) {
			System.out.println(float1);
		}
	}

}