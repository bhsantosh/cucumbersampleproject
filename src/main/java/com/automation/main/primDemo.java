package com.automation.main;

import java.util.Scanner;

public class primDemo {

	public static void main(String[] args) {
		
		System.out.println("Please enter the number:");
		
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		boolean prime = true; 
		
		
		 for(int x= 2; x<number; x++){
			 if (number%x ==0){
				 prime = false;
				 break;
			 }
		 }
		 
		 if(prime){
			 System.out.println("This it the Prime number: " + number);
		 }else if(!prime){
			 System.out.print("This is not the Prime number: " + number);
		 }
		 
		 
		

	}

}
