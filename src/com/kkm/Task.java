package com.kkm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



class Worker extends Thread {
    public static ArrayList<Integer> listInt;
    public static String[][] listStr;

    Worker(ArrayList<Integer> listInt, String[][] listStr) throws IOException, InterruptedException {
        this.listInt = listInt;
        this.listStr = listStr;
    }

    public static void work() throws IOException, InterruptedException {
        App task = new App();
        new intThread().start();
        new strThread().start();
    }
    static class intThread extends Thread{
        @Override
        public  void run(){
            Handler int_hand = new Handler();
            try {
                listInt = Generator.Gen(0);
                int_hand.getIntResultFirst(listInt);
                //2 -четные
                int_hand.getIntResultSecond(listInt, 2);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    static class strThread extends Thread{
        @Override
        public  void run(){
            Handler str_hand = new Handler();
            try {
                listStr = Generator.Gen(" ");
                str_hand.getStrResultFirst(listStr);
                str_hand.getStrResultSecond(listStr);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
