package com.automation.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	
	public static void main(String[] args) {
        System.out.println("Enter a number :: ");
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        
        if(matcher.matches()) {
        	System.out.println("Valid Email Address");
        } else {
        	System.out.println("Invalid Email Address");
        }
        
        scan.close();
    }

}
