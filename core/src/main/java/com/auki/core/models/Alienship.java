package com.auki.core.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.regex.*;


public class Alienship {

    int input;
    int[] newarray = new int[3];
    static boolean shipkilled = false;
    int pos;
    int guess = 0;
    int invalidguess = 0;
    boolean flag = true , check=true;
    static int testpass=0;



    static ArrayList<Integer> shipposition = new ArrayList<Integer>();
    ArrayList<Integer> ship1 = new ArrayList<Integer>();
    ArrayList<Integer> ship2 = new ArrayList<Integer>();
    ArrayList<Integer> ship3 = new ArrayList<Integer>();


///////////////
    //Alpha to digits converter
/////////////
    public int convertRegexToNumber(String value) {

            if (Pattern.matches("[a-h|A-H][0-7]", value)) {

                String[] firststring = value.split("(?!^)");
                String ch = firststring[0];

                int stringvalue = ch.charAt(0) - 97;

                int numbervalue = Integer.parseInt(String.valueOf(firststring[1]));

                input = (stringvalue * 8) + numbervalue;

//            System.out.println(input);
            } else {
                System.out.println("Enter input in specified format!!!!!!");

            }

        return input;

    }
//////////
    // checks the value is a hit or miss///
///////////////////

    public void checkhitmiss( int input) {

        if (shipposition.contains(input)) {

            pos = shipposition.indexOf(input);
            if (pos < 3) {
                if (ship1.contains(input)) {
                    System.out.println("You already entered " + input + ".");
                    invalidguess++;
                } else {
                    ship1.add(input);
                    System.out.println("## Hit ##");
                    testpass=1;
                    guess++;
                }
                if (ship1.size() == 3) {
                    System.out.println("!!!Ship-1 sunk!!!");
                }
            } else if (pos >= 3 && pos < 6) {
                if (ship2.contains(input)) {
                    System.out.println("You already entered " + input + ".");
                    invalidguess++;
                } else {
                    ship2.add(input);
                    System.out.println("## Hit ##");
                    testpass=1;
                    guess++;
                }
                if (ship2.size() == 3) {
                    System.out.println("!!!Ship-2 sunk!!!");
                }
            } else if (pos >= 6 && pos < 9) {
                if (ship3.contains(input)) {
                    System.out.println("You already entered " + input + ".");
                    invalidguess++;
                } else {
                    ship3.add(input);
                    System.out.println("## Hit ##");
                    testpass=1;
                    guess++;
                }
                if (ship3.size() == 3) {
                    System.out.println("!!!Ship-3 sunk!!!");
                }
            }
            if ((ship1.size() == 3) && (ship2.size() == 3) && (ship3.size() == 3)) {
                shipkilled = true;
                System.out.println("You WON the GAME!!!!!");
                System.out.println("The total valid guesses are : " + (guess));
                System.out.println("The total guesses with multiple entry are : " + (guess + invalidguess));
            }
        } else {
            System.out.println("## Miss ##");
            testpass=0;
            guess++;
        }
    }
////////////
    /////check-condition function is called.......
///////////

    public int[] checkCondition(int randomship , int randomdir) {


        int[] temparray = new int[3];
        if (randomdir == 0) {
            if ((randomship % 8) == 0) {
                temparray[0] = randomship;
                temparray[1] = randomship + 1;
                temparray[2] = randomship + 2;

            } else if (((randomship + 1) % 8) == 0) {

                temparray[0] = randomship - 2;
                temparray[1] = randomship - 1;
                temparray[2] = randomship;

            } else {
                temparray[0] = randomship - 1;
                temparray[1] = randomship;
                temparray[2] = randomship + 1;

            }
        } else {
            if (randomship < 8) {
                temparray[0] = randomship;
                temparray[1] = randomship + 8;
                temparray[2] = randomship + 16;

            } else if (randomship > 55) {
                temparray[0] = randomship - 16;
                temparray[1] = randomship - 8;
                temparray[2] = randomship;

            } else {
                temparray[0] = randomship - 8;
                temparray[1] = randomship;
                temparray[2] = randomship + 8;
            }
        }
        return temparray;
    }
///////
    // Ship positioning function
///////

    public void shipSetPosition() {

        int randomship = 0;
        int randomdir =0;

        for (int i = 0; i < 3; i++) {

            boolean flag = true;
            randomship = (int) (Math.random() * 64) + 0;
            randomdir= (int) (Math.random() * 2) + 0;


            ////////////////
//                System.out.println("direc= "+ randomdir);
//                System.out.println("numer: " + randomship);

            ////////////////

            newarray = checkCondition(randomship,randomdir);

            // Insert the the random values into array list
            while (flag) {
                if (shipposition.contains(newarray[0]) == false && shipposition.contains(newarray[1]) == false
                        && shipposition.contains(newarray[2]) == false && shipposition.contains(randomship) == false) {

                    shipposition.add(newarray[0]);
                    shipposition.add(newarray[1]);
                    shipposition.add(newarray[2]);
                    flag = false;
                }
                else {
                    randomship = (int) (Math.random() * 64) + 0;
                ////////////////
//                        System.out.println("2-numer: " + randomship);
                //////////////////
                    newarray = checkCondition(randomship,randomdir);


                }
            }
        }
        //////////////////
//            for (int l = 0; l < shipposition.size(); l++) {
//                System.out.println(shipposition.get(l));
//            }
        //////////////////

    }
}


