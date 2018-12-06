package com.automation.main;

public class FindMiddleIndex  {
	
	public static int findMiddleIndex(int[] numbers) throws Exception {
		 
        int endIndex = numbers.length - 1;
        int startIndex = 0;
        int sumLeft = 0;
        int sumRight = 0;
        while (true) {
            if (sumLeft > sumRight) {
                sumRight += numbers[endIndex--];
                System.out.println(endIndex + " <------ end right-------> "+sumRight);
            } else {
                sumLeft += numbers[startIndex++];
                System.out.println(startIndex + " <-------start left------> "+sumLeft);
            }
            if (startIndex > endIndex) {
                if (sumLeft == sumRight) {
                    break;
                } else {
                    throw new Exception(
                            "Please pass proper array to match the requirement");
                }
            }
        }
        return endIndex;
    }
	
	public static void main(String[] args) {
		int[] num = { 2, 4, 4, 5, 4, 1 };
        try {
            System.out.println("Starting from index 0, adding numbers till index "
                            + findMiddleIndex(num) + " and");
            System.out.println("adding rest of the numbers can be equal");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}