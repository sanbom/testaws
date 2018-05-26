package com.test.hackerearth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArraySort {
	
	static class SortbyAbs implements Comparator<Integer>
	{
	    

		public int compare(Integer arg0, Integer arg1) {
			System.out.println("args ro compare:"+arg0+","+arg1);
			if(arg0==arg1)  
				return 0;  
				else if(Math.abs(arg0)>Math.abs(arg1))  
				return 1;  
				else  
				return -1;  
			
		}
	}

	public static void main(String[] args) {
		// 10
		//9 -10 -11 20 1 2 -3 4 -5 6
		Scanner s = new Scanner(System.in);
		int size = Integer.parseInt(s.nextLine());
		System.out.println("size:"+size);
		String line = s.nextLine(); 
		System.out.println("line:"+line);
		Scanner s1 = new Scanner(line);
		int num = 0;
		Integer [] arrayInput = new Integer[10];
		int counter = 0;
		while (s1.hasNextInt()){
			num = s1.nextInt();
			System.out.println("num:"+num);
			arrayInput[counter] = num;
			counter++;
		}
		Arrays.sort(arrayInput,new ArraySort.SortbyAbs());
		System.out.println("sorted array:"+arrayInput);
		for (Integer elem:arrayInput){
			System.out.print(elem+" ");
		}

	}

}
