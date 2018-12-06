package com.automation.main;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String[] args){
		
		System.out.println("Enter a String");
		
		Scanner scan = new Scanner(System.in);
		
		String b = scan.nextLine();
		String reverse = "";
		
		for( int i = b.length()-1; i>=0; i--){
			
//			System.out.println("------------->" + b.charAt(i));
			reverse = reverse + b.charAt(i);
		}
		
		System.out.println("Reverse String is : " + reverse);
		
	}

}
