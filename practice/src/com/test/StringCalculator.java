/**
 * 
 */
package com.test;

import java.util.Scanner;

/**
 * @author sandeep
 *
 */
public class StringCalculator {
	
	public static int add(final String numbers) {
	    int returnValue = 0;
	    String[] numbersArray = numbers.split(",");
	    if (numbersArray.length > 2) {
	        throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
	    }
	    for (String number : numbersArray) {
	        if (!number.trim().isEmpty()) { // After refactoring
	            returnValue += Integer.parseInt(number);
	        }
	    }
	    return returnValue;
	}
	
	private static void testCorrectLogic(){
		String line1 = "5";
		String line2 = "1 2 3 4 5";
		if(calculateAndprint(line1,line2) == 4){
			System.out.println("pass");
		}
	}
	
	private static void testNumberInRange(){
		int[] testInput = {-1,0,2400,4,1,1000};
		if(!isNumberInRange(testInput[0])){
			System.out.println("Pass");
		}
		if(!isNumberInRange(testInput[1])){
			System.out.println("Pass");
		}
		if(!isNumberInRange(testInput[2])){
			System.out.println("Pass");
		}
		if(isNumberInRange(testInput[3])){
			System.out.println("Pass");
		}
		if(isNumberInRange(testInput[4])){
			System.out.println("Pass");
		}
		if(isNumberInRange(testInput[5])){
			System.out.println("Pass");
		}
		
	}
	
	private static boolean isNumberInRange(int number){
		if(number < 1 | number > 1000){
			return false;
		}
		return true;
	}
	
	    public static void main(String args[] ) throws Exception {
	       
	        // Write your code here
	        Scanner s = new Scanner(System.in);
	        //String name = s.nextLine();                 // Reading input from STDIN
	        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
	        
	        testNumberInRange();
	        testCorrectLogic();
	         
	        
	         
	        
	            String line1 = s.nextLine(); 
	            System.out.println("Line1 : "+ line1 );
	           // noofElements = Integer.parseInt(line1);
	            String line2 = s.nextLine();
	            
	            calculateAndprint(line1,line2);
	            
	            
	        
	    }
	    
	    private static int calculateAndprint(String line1,String line2){
	    	int noofElements = Integer.parseInt(line1);
	    	String[] array= line2.split("\\s");
	    	int sum=0;
	    	int newSum =0;
	    	int averageValue = 0;
            for(String arr:array){
            	sum = sum + Integer.parseInt(arr);
            }
            System.out.println("original sum : "+ line2 );
            averageValue = Math.floorDiv(sum,noofElements)+1;
            System.out.println("Average value  : "+ averageValue );
            while(newSum > sum){
            	newSum = noofElements*averageValue;
            	System.out.println("new  sum : "+ newSum );
            	averageValue++;
            	
            }
            System.out.println(averageValue);
            return averageValue;
            
	    	
	    }
	

}
