package api.test;

import java.util.Scanner;

public class max {


    public static void main (String [] args ){

        Scanner input = new Scanner (System.in);

        int max = -2147483647 ;

        for (int i=0 ; i < 3 ; i++){

            System.out.println ( " Enter your number ");

            int num = input.nextInt();

            if(max < num) {
                max = num;

            }


        }

        System.out.println("Max number is " + max);

        input.close();

    }





}
