package com.practise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionProg {
	public static void main(String[] args) {
		String inData = null;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try {

			inData = stdin.readLine();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("You wrote: " + inData);
	}
}
