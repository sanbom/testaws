package com.test.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.NoSuchElementException;
class TestClass {
    public static String readLine(Scanner s){
		try{
			return s.nextLine();
		}
		catch(NoSuchElementException e){
			//System.out.println("No Such Element Exception:"+e);
		}
		return null;
		
	}
	public static void main(String args[]) throws Exception {/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); //
		 * Writing output to STDOUT
		 * 
		 * //Scanner Scanner s = new Scanner(System.in); String name =
		 * s.nextLine(); // Reading input from STDIN System.out.println("Hi, " +
		 * name + "."); // Writing output to STDOUT
		 */

		// Write your code here
		// 10 23ptestSampleInput();
		 //testSampleInput();
		 //System.exit(1);
		Scanner s = new Scanner(System.in);
		
		String nofCases = readLine(s);
		//System.out.println("No of test Cases:" + nofCases);
		HashMap<Integer, ArrayList<String>> casesandInputs = new HashMap<Integer, ArrayList<String>>(
				100);
		ArrayList<String> inputs = null;
		
		String dataInputLine = null;
		
		
		dataInputLine = readLine(s);
		
		for (int i = 1; i <= Integer.parseInt(nofCases); i++) {
			inputs = new ArrayList<String>();
			
			System.out.println("Input line :" + dataInputLine);
			System.out.println("frst pass adding to inputs :"+ dataInputLine);
			inputs.add(dataInputLine);
			
			while(true){
				dataInputLine = readLine(s);
			//	System.out.println("Input line in while:" + dataInputLine);
				if(null == dataInputLine | dataInputLine.isEmpty()){
					casesandInputs.put(new Integer(i), inputs);
					executeAllCases(nofCases,casesandInputs);
					return;
					
				}
				else if(!isNumeric(dataInputLine.split("\\s")[0])){
					//System.out.println("id not numeric:" + dataInputLine);
					inputs.add(dataInputLine);
				}
				else{
					//System.out.println("iteraion endining:"+inputs);
					casesandInputs.put(new Integer(i), inputs);
					break;
				}
			}
			
			
			
			
		}// end for
		//System.out.println("final Test Cases Map :" + casesandInputs);
	
}
private  static void executeAllCases(String nofCases,HashMap<Integer, ArrayList<String>> casesandInputs){
	System.out.println("Final testCases :"+casesandInputs);
		for (int i = 1; i <= Integer.parseInt(nofCases); i++) {
			//int size = casesandInputs.get(i).size();
			System.out.println("Player "+calculateandPrint(casesandInputs.get(i).toArray(
					new String[100])));
		}
		
	}
	private static boolean isNextTestCaseStarting(String value){
		if(isNumeric(value.split("\\s")[0])){
			return true;
		}
		return false;
	}
	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		//System.out.println("IsNumeric:" + str);
		return true;
	}

	private static void testSampleInput() {

		String line2 = "10 23";
		String line3 = "P 86";
		String line4 = "P 63";
		String line5 = "P 60";
		String line6 = "B";
		String line7 = "P 47";
		String line8 = "B";
		String line9 = "P 99";
		String line10 = "P 9";
		String line11 = "B";
		String line12 = "B";

		String[] sampleInput = { line2, line3, line4, line5, line6, line7,
				line8, line9, line10, line11, line12 };
		System.out.println(calculateandPrint(sampleInput));
	}

	private static String calculateandPrint(String[] input) {
		// HashMap<Integer,String> passNoPlayerMapping = new
		// HashMap<Integer,String>();
		int noOfPassesInput = Integer.parseInt(input[0].split("\\s")[0]);
		int currentPass = 0;
		String currentPlayer = input[0].split("\\s")[1];
		String previosPlayer = input[0].split("\\s")[1];
		if (noOfPassesInput == 1) {
			return currentPlayer;
		}

		for (int i = 0; i < input.length; i++) {
			String tmpForBack = "";
			
			System.out.println("Current pass:" + i);
			String[] passDetails = input[i].split("\\s");
			System.out.println("inpt split:" + passDetails.toString());
			String kindOfPass = passDetails[0];
			if (kindOfPass.equalsIgnoreCase("P")) {
				System.out.println("Type of  pass:" + kindOfPass);
				System.out.println("Previuos Player:" + previosPlayer);
				System.out.println("Current  Player:" + currentPlayer);
				previosPlayer = currentPlayer;
				currentPlayer = passDetails[1];
			} else if (kindOfPass.equalsIgnoreCase("B")) {
				System.out.println("Type of  pass:" + kindOfPass);
				System.out.println("Previuos Player:" + previosPlayer);
				System.out.println("Current  Player:" + currentPlayer);
				tmpForBack = String.copyValueOf(previosPlayer.toCharArray());
				previosPlayer = currentPlayer;

				currentPlayer = tmpForBack;

			}
			System.out.println("Previuos Player after pass:" + previosPlayer);
			System.out.println("Current  Player after pass:" + currentPlayer);
			
			if (i == noOfPassesInput) {
				System.out.println("Current  pass = noOfPassesRequired:"+ noOfPassesInput);
				return currentPlayer;
			}
		}
		return currentPlayer;
	}


    		
}
    	
    	
    	
    	
    
    
    
   
    




