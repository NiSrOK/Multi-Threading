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
    static class intThread extends Thread {
        @Override
        public void run() {
            Handler int_hand = new Handler();
            try {
                System.out.println(String.format("START Execute thread (IntThread): %s",
                        this.getName()));
                listInt = Generator.Gen(0);
                new subIntThread(int_hand).start();
                new subIntThread2(int_hand).start();
                System.out.println(String.format("Execute thread (IntThread): %s",
                        this.getName())+ " END WORK");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
    static class subIntThread extends Thread{
        Handler int_hand;
        public subIntThread(Handler int_hand) {
            this.int_hand = int_hand;
        }

        @Override
        public  void run(){
            try {

                System.out.println(String.format("Execute thread (subIntThread): %s",
                        this.getName()));
                int_hand.getIntResultFirst(listInt);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static class subIntThread2 extends Thread{
        Handler int_hand;
        public subIntThread2(Handler int_hand) {
            this.int_hand = int_hand;
        }
        @Override
        public  void run(){
            try {
                System.out.println(String.format("Execute thread (subIntThread2): %s",
                        this.getName()));
                //2 -четные
                int_hand.getIntResultSecond(listInt, 2);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class strThread extends Thread{
        @Override
        public  void run(){
            Handler str_hand = new Handler();
            try {
                System.out.println(String.format("START Execute thread (strThread): %s",
                        this.getName()));
                listStr = Generator.Gen(" ");
                new subStrThread(str_hand).start();
                new subStrThread2(str_hand).start();
                System.out.println(String.format("Execute thread (strThread): %s",
                        this.getName())+ " END WORK");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class subStrThread extends Thread {
        Handler str_hand;
        public subStrThread(Handler str_hand) {
            this.str_hand = str_hand;
        }
        @Override
        public void run() {
            try {
                System.out.println(String.format("Execute thread (subStrThread): %s",
                        this.getName()));
                str_hand.getStrResultFirst(listStr);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static class subStrThread2 extends Thread{
        Handler str_hand;
        public subStrThread2(Handler str_hand) {
            this.str_hand = str_hand;
        }
        @Override
        public  void run(){
            try {
                System.out.println(String.format("Execute thread (subStrThread2): %s",
                        this.getName()));
                str_hand.getStrResultSecond(listStr);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
