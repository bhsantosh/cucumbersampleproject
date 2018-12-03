package com.automation.main;

import java.util.Scanner;

public class OddEven {
	
	public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Enter a number :: ");
        Scanner scan = new Scanner(System.in);
//        String s = scan.next();
        int i = scan.nextInt();
        
        if(i%2 == 0){
        	System.out.println("Its a prime number");
        }else{
        	System.out.println("Its a odd number");
        }
        scan.close();
    }

}
