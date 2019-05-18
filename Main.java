package com.company;
import java.util.Scanner;

public class Main {

    public static void Game() {
        /*
        this is the program of wheel of fortune. this program will allow the user enter a letter and then if the user guessed the
        letter right then the player can guess the whole phrase
         */
        Scanner in = new Scanner(System.in);
        String namPlayer1 = "";
        String namPlayer2 = "";
        String expression = "";
        String guessSentence = "";
        String userGuess = "";

        int numChance = 0;

        //Get Challenger  enter an expression
        expression = in.nextLine();
        StringBuffer scr = new StringBuffer(expression);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        //convert expression to hidden form by using asterisks
        for (int i = 0; i < scr.length(); i++) {
            if (scr.charAt(i) != ' ' && scr.charAt(i) != ('\'')) {
                scr.setCharAt(i, '*');
            }
        }
        System.out.println(scr);


        //give player one instruction to begin
        System.out.println(namPlayer1 + " please begin.");
        boolean flip;
        //we begin to check each character with the letter in the string buffer
        int e = 0;
        while (!expression.equals(scr.toString()) && e <= 26) {

            System.out.println("Guess the letter");
            userGuess = in.next();
            char userGuess1 = userGuess.charAt(0);
            flip = false;


            for (int j = 0; j < expression.length(); j++)
            {
                if (userGuess1 == (expression.charAt(j)))
                {
                    scr.setCharAt(j, userGuess1);
                    flip = true;
                }
            }

            System.out.print("the sentence now is: " + scr);

            if (flip)
            {
                in.skip("[\n\r+]");
                System.out.println(". You are right and guess the sentence.");
                guessSentence=in.nextLine();

                if(guessSentence.equals(expression))
                {
                    System.out.print("Congratulations,you guess the right sentence.");
                    //abreak;
                    //scr=new StringBuffer(expression);
                    //System.out.print("*****"+scr);
                    System.out.print(guessSentence);
                    break;
                }
                else{
                    System.out.print("you guessed the wrong sentence.");
                }

            } else {
                System.out.println("you are wrong and try again.");
            }
            ++e;
            System.out.println(scr);
        }

        System.out.println(scr);
        System.out.println("Congratulations!");
    }
    //this is the beginning of the program.
    public static void main(String[] args) {
        // write your code here
        //Get names from the players
        String namPlayer1 = "";
        String namPlayer2 = "";

        char secretLetter = 'a';
        String Challenger = "b";
        String Contestant = "a";


        Scanner in = new Scanner(System.in);
        System.out.print("Hi,player one.Please enter yor name:\n");
        namPlayer1 = in.nextLine();
        System.out.print("Hi,player two.Please enter yor name:\n");
        namPlayer2 = in.nextLine();

        for (int h = 1; h <= 2; h++) {
            if (h == 1) {
                Challenger = namPlayer2;
                Contestant = namPlayer1;
                System.out.print(Contestant + " turn away,please\n");
                System.out.println(Challenger + " ,please enter a sentence(remember the sentence should not be more than 20 letters or less than 50 letters): ");
                Game();

            } else if (h == 2) {
                Challenger = namPlayer1;
                Contestant = namPlayer2;
                System.out.print(Contestant + " turn away,please\n");
                System.out.println(Challenger + " ,please enter a sentence(remember the sentence should not be more than 20 letters or less than 50 letters): ");
                Game();

            }
        }
    }
}
