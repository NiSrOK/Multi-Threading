
package com.kkm;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
interface  Operation{
	int Sum (ArrayList<Integer> list);
	int Min (ArrayList<Integer> list);
	int Max (ArrayList<Integer> list);
	int Mean (int sum, ArrayList<Integer> list);
	void getIntResultFirst (ArrayList<Integer> list);
	void getIntResultSecond (ArrayList<Integer> list, int q) throws IOException;
	ArrayList<Integer> HandIntFirst (ArrayList<Integer> list);
	ArrayList<Integer> HandIntSecond (ArrayList<Integer> list, int q);
	ArrayList<String> HandStrFirst (String[][] list);
	ArrayList<Integer> HandStrSecond (String[][] list);
	void getStrResultFirst (String[][] list);
	void getStrResultSecond (String[][] list);
}


public class Handler implements  Operation{
	
	public static int s, min, max, mean;
	@Override
	public int Sum (ArrayList<Integer> list){
		int s = 0;
		for(int i = 0; i<list.size(); i++){
			s += list.get(i);
		}
		return s;
	}
	@Override
	public int Min (ArrayList<Integer> list){
		int min = list.get(0);
		for(int i = 0; i<list.size(); i++){
			if (min>list.get(i)){
				min = list.get(i);
			}
		}
		return min;
	}
	@Override
	public int Max (ArrayList<Integer> list){
		int max = list.get(0);
		for(int i = 0; i<list.size(); i++){
			if (max<list.get(i)){
				max = list.get(i);
			}
		}
		return max;
	}
	@Override
	public int Mean (int sum, ArrayList<Integer> list){
		int s = sum;
		mean = s/(list.size()+1);
		return mean;
	}
	@Override
	public void getIntResultFirst(ArrayList<Integer> list){
		ArrayList<Integer> res = HandIntFirst(list); 
		
		System.out.println("Sum of array elements: " + res.get(0));
		System.out.println("Minimum array element: " + res.get(1));
		System.out.println("Maximum array element: " + res.get(2));
		System.out.println("Average value of array elements: " + res.get(3));
	}
	@Override
	public void getIntResultSecond (ArrayList<Integer> list, int q) throws IOException{
		ArrayList<Integer> res = HandIntSecond(list, q); 
		
		try(FileWriter writer = new FileWriter("Int2.txt", false)){
			for (int i=0;i<res.size();i++){
				writer.write(Integer.toString(res.get(i))+ " ");
			}
	        writer.flush();
		}
		System.out.println("Array written to file");
		
	}
	@Override
	public ArrayList<Integer> HandIntFirst (ArrayList<Integer> list){
		ArrayList<Integer> Result = new ArrayList<>();
		Result.add(Sum(list));
		Result.add(Min(list));
		Result.add(Max(list));
		Result.add(Mean(Sum(list),list));
				
		return Result;
	}
	@Override
	public ArrayList<Integer> HandIntSecond (ArrayList<Integer> list, int q){
		ArrayList<Integer> res = new ArrayList<>(); 
		if (q==2){
			for (int i =0; i<list.size();i++){
				if (list.get(i) % 2==0){
					res.add(list.get(i));
					//System.out.println(res.get(i));
				}
			}
			System.out.println("Odd elements has been wiped");

		}
		else{
			for (int i =0; i<list.size();i++){
				if (list.get(i)%2!=0){
					res.add(list.get(i));
				}
			}
		}
				
		return res;
	}
	@Override
	public ArrayList<String> HandStrFirst (String[][] list){
		ArrayList<String> Result = new ArrayList<>();
		
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] != " "){
					Result.add(list[i][j]);
				}
			}
		}
	
		return Result;
	}
	@Override
	public void getStrResultFirst (String[][] list){
		ArrayList<String> res = HandStrFirst(list);

		try(FileWriter writer = new FileWriter("GluedStr.txt", false)){
			for (int i=0;i<res.size();i++){
					writer.write(res.get(i));
				}
			writer.flush();
			System.out.println("Glued string written to file");
		}
		catch(IOException ex){

			System.out.println(ex.getMessage());
		}
	}
	@Override
	public ArrayList<Integer> HandStrSecond (String[][] list){
		ArrayList<Integer> Result = new ArrayList<>();
		int amt = 0;
		int length = 0;
		
		Result.add(list.length);
		
		for (int i = 0; i < list.length; i++) {
			amt = 0;
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] != (" ")){
					amt+=1;
					length += list[i][j].length();
				}
			}
			Result.add(amt);			
		}
		Result.add(length);
	
		return Result;
	}
	@Override
	public void getStrResultSecond (String[][] list){
		ArrayList<Integer> res = HandStrSecond(list); 
		
		int line = res.get(0);
		int S = 0;
		res.remove(0);
		System.out.println("Number of lines: "+ line);
		
		for (int i=0;i<line;i++){
			System.out.println("Word Count in " + (i) + " line: " + res.get(i));
			S+=res.get(i);
		}
		System.out.println("Number of words in total: " + S);
		System.out.println("Number of characters in total: " + res.get(res.size()-1));
		
	}

}
