package com.kkm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class App extends Task_class{
	public static ArrayList<Integer> listInt;
	public static String[][] listStr;

	public static void main(String[] args) throws IOException, InterruptedException {
           Worker worker = new Worker(listInt, listStr);
           worker.work();
	}
}
