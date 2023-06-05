package com.practise;

import java.util.ArrayList;

public class Prog3 {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("Sujit", 1));
		studentList.add(new Student("Siddharth", 2));
		studentList.add(new Student("Karanpreet", 3));
		studentList.add(new Student("Hari", 5));
		studentList.add(new Student("Tricha", 4));

		studentList.remove(3);

		for (int i = 0; i < studentList.size(); i++) {
			System.out.print(studentList.get(i).name + " ");
		}
	}
}

class Student {
	public String name;
	public int rollNumber;

	public Student(String name, int rollNumber) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
	}
}
