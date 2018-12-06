package com.automation.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MaxNumberInArrayList {

	public static void main(String[] args) {

		ArrayList<Integer> num = new ArrayList<Integer>();

		num.add(1);
		num.add(12);
		num.add(5);
		num.add(16);
		num.add(10);

		int temp = 0;

		System.out.println("given list of numbers::" + num);

		for (int i : num) {

			if (i > temp) {

				temp = i;
			}

		}

		System.out.println("Max number provied is ::" + temp);

	}

}
