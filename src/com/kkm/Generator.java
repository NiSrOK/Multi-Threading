package com.kkm;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Generator {

	public static ArrayList<Integer> Gen(int type) throws IOException, InterruptedException {

		ArrayList<Integer> Array = new ArrayList<>();
		int z = (int)( Math.random() * 8 + 3);
		System.out.println("Wait " + z + " seconds" +"(Int)");
		java.util.concurrent.TimeUnit.SECONDS.sleep(z);
		z = (int) (1 + Math.random()*40);
		for (int i=0;i<z;i++){
			Array.add((int) (1 + Math.random()*40));
		}
		try(FileWriter writer = new FileWriter("Int.txt", false)){
			for (int i=0;i<Array.size();i++){
				writer.write(Integer.toString(Array.get(i))+ " ");
			}
			writer.flush();
		}
		return Array;
	}

	public static String[][]Gen(String type) throws IOException, InterruptedException {
		String[] Pull = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

		int m = (int)( Math.random() * 15 + 5);
		int n = (int)( Math.random() * 15 + 5);

		String[][] Array = new String[m][n];
		int z = (int)( Math.random() * 8 + 3);
		System.out.println("Wait " + z + " seconds" +"(Str)");
		java.util.concurrent.TimeUnit.SECONDS.sleep(z);
		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				z = (int)( Math.random() * 2);
				if (z==0){
					z = (int)( Math.random() * 5 + 2);
					String word = "";
					for(int k = 0;k<z;k++){
						int p = (int)( Math.random() * 26);
						word = word + Pull[p];
					}
					Array[i][j]=word;
				}
				else{
					Array[i][j]=" ";
				}
			}
		}

		try(FileWriter writer = new FileWriter("Str.txt", false)){
			for (int i = 0; i < Array.length; i++) {
				for (int j = 0; j < Array[i].length; j++) {
					writer.write(Array[i][j]);
					writer.write(" ");
				}
				writer.write('\n');
			}
			writer.flush();
		}

		return Array;
	}


}