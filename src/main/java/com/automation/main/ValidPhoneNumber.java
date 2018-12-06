package com.automation.main;

import java.util.Scanner;

public class ValidPhoneNumber {

	public static void main(String[] args) {
		
		System.out.println("Please enter the phone no");
		
		Scanner scan = new Scanner(System.in);
		String no = scan.nextLine();
		
		String newno = no.replaceAll("\\(|\\)|\\-| ", "");
		if(newno.length()==10){
			try{
				long a = Long.parseLong(newno);
				System.out.println("This is the valid phone number  :: "+ no );
			}catch(NumberFormatException e){
				System.out.println("This is not the valid phone number  :: "+ no );
			}
		}else{
			System.out.println("This is not the valid phone number  :: "+ no );
		}
		scan.close();
	}

}
