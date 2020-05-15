package com.kkm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class Task_class {


    public int Question(int type_) {

        if (type_ == 1) {
            Scanner in = new Scanner(System.in);
            System.out.println("Array Type:" + "\n" + "1.Int" + "\n" + "2.String");
            int num = in.nextInt();
            return num;

        }
        if (type_ == 2) {

            Scanner in = new Scanner(System.in);
            System.out.println("Select a handler:" + "\n" + "1. The first handler returns the sum, the average value, the minimum and maximum element"
                    + "\n" + "2. The second handler removes even or odd elements from the list, depending on the setting" + "\n" + "3. Apply both handlers");
            int num = in.nextInt();
            return num;
        }
        if (type_ == 3) {

            Scanner in = new Scanner(System.in);
            System.out.println("Delete: " + "\n" + "1.Even" + "\n" + "2.Odd");
            int num = in.nextInt();
            in.close();
            return num;

        }
        if (type_ == 4) {

            Scanner in = new Scanner(System.in);
            System.out.println("Select a handler:" + "\n" + "1. The first handler - returns the glued string"
                    + "\n" + "2. The second handler counts the number of words in each line, the total number of words and characters across all lines of the list" + "\n" + "3. Apply both handlers");
            int num = in.nextInt();
            in.close();
            return num;
        } else {
            return 0;
        }
    }
}

class Worker extends Task_class{
    public static ArrayList<Integer> listInt;
    public static String[][] listStr;

    Worker(ArrayList<Integer> listInt, String[][] listStr) throws IOException, InterruptedException {
        this.listInt = listInt;
        this.listStr = listStr;
    }

    public static void work() throws IOException, InterruptedException{

        //Create to hands ( int and string) to help with task
        Handler int_hand = new Handler();
        Handler str_hand = new Handler();

        App task = new App();

        listInt = Generator.Gen(0);
        listStr = Generator.Gen(" ");
////////////////////////////////////////////////

        int_hand.getIntResultFirst(listInt);
        //2 -четные
        int_hand.getIntResultSecond(listInt, 2);

///////////////////////////////////////////////

        str_hand.getStrResultFirst(listStr);

        str_hand.getStrResultSecond(listStr);


        }
}
