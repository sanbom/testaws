package com.test.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Scanner;

public class InputFromConsole {
	
	private static String readLine(Scanner s){
		String line;
		if(!(line = s.nextLine()).isEmpty()){
			return line;
		}
		
		return null;
		
	}
	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		//System.out.println("IsNumeric:" + str);
		return true;
	}
	private  static void executeAllCases(String nofCases,HashMap<Integer, ArrayList<String>> casesandInputs){
		System.out.println("Final testCases :"+casesandInputs);
			for (int i = 1; i <= Integer.parseInt(nofCases); i++) {
				//int size = casesandInputs.get(i).size();
				//System.out.println("Player "+calculateandPrint(casesandInputs.get(i).toArray(new String[100])));
			}
			
		}
	public static void main(String[] args)throws Exception{
		
		Scanner s = new Scanner(System.in);
		
		String nofCases = readLine(s);
		System.out.println("No of test Cases:" + nofCases);
		HashMap<Integer, ArrayList<String>> casesandInputs = new HashMap<Integer, ArrayList<String>>(100);
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
				if(null == dataInputLine || dataInputLine.isEmpty()){
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

}
