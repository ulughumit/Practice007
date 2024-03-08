package api.test;

import java.util.Scanner;

public class oddEven {

    public static void main (String [] args) {

        Scanner input = new Scanner (System.in);

        System.out.println ("Please enter your number");

        int number = input.nextInt();

        if( number % 2 == 0){

            System.out.println (number + " is even number");
        }else{

            System.out.println (number + " is odd number");

        }

        input.close();

    }
}