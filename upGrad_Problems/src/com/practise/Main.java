package com.practise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {

        File inputfile = new File("C:\\Users\\ishita.shrivastava\\Desktop\\Numbers.txt"); // Specify the path of the file

        Scanner scan = new Scanner(inputfile);
        int numb = 1;
        int sum = 0;
        int totalNum = 1;

        while (scan.hasNext()) {  // read the numbers and add them to the value of the sum
            int number = scan.nextInt();
            sum = sum + number;
            totalNum = numb++;
        }
        System.out.println(sum +" : "+totalNum);
        System.out.println("Mean is : " + (sum/totalNum));
        scan.close();
    }
}
