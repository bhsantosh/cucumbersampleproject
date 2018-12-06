package com.automation.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class duplicate {
	
	public static void main(String[] args) {
//		int names[] = new int[10]; 
		
//		names = new int[] { 1,2,4,4,5,2,3,8,9,7 };
		
		ArrayList<Integer> names = new ArrayList<Integer>();
		
		names.add(1);
		names.add(2);
		names.add(4);
		names.add(4);
		names.add(5);
		names.add(2);
		names.add(6);
		names.add(8);
		names.add(7);
		names.add(9);
		
		System.out.println("ArrayList :: " + names);
		
		Set set = new HashSet();
		
		for (int name : names) {
		     if (set.add(name) == false) {
		        System.out.println("Duplicate :: " + name);
		     }
		}
		
		System.out.println("Set :: " + set);
    }
}
