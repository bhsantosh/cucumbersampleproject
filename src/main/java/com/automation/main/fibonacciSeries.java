package com.automation.main;

import java.util.Scanner;

public class fibonacciSeries {

	public static void main(String[] args) {

		System.out.println("Please enter the no that you want the series for:");

		Scanner scan = new Scanner(System.in);

		int i = scan.nextInt();
		int n1 = 1;
		int n2 = 0;
		int n3;

		for (int x = 1; x <= i; x++) {

			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;

			System.out.print(n3 + ",");

		}
		scan.close();

	}

}
