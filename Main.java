import java.util.Random;
import java.util.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int y_counter = -1;
        boolean GameOn = true;

        int[][] minesweeper = new int[10][10];

        for (int i = 0; i < minesweeper.length; i++) {
            Random rndm = new Random();
            System.out.println();

            for (int j = 0; j < minesweeper[i].length; j++) {

                minesweeper[i][j] = rndm.nextInt(2);
                System.out.print("[" + minesweeper[i][j] + "] ");
            }
        }

            System.out.println("----------------Welcome to Minesweeper---------------------");

            String[][] shownBoard = new String[10][10];

             for(int x = 0; x < shownBoard.length; x++){
                System.out.println();

                 for(int y = 0; y < shownBoard.length; y++) {
                     shownBoard[x][y] = "?";
                     System.out.print("[" + shownBoard[x][y] + "] ");
                     if(y == 9){
                         y_counter++;
                         System.out.print(" | " + y_counter);

                     }

                 }

             }
             System.out.println("\n-------------------------------------------");
             System.out.println("[0] [1] [2] [3] [4] [5] [6] [7] [8] [9]\n");


            y_counter = -1;
            Scanner  xchoice = new Scanner(System.in);
            Scanner ychoice = new Scanner(System.in);

            while(GameOn){
                System.out.println("\nPlease pick a location on the X axis");
                 int x = xchoice.nextInt();



                System.out.println("\nPlease pick a location on the Y axis");
                int y = ychoice.nextInt();

                if(minesweeper[x][y] == 0){

                    System.out.println("Well done you may continue \n");

                    int mineCounter = 0;
                    if(minesweeper[x+1][y+1] == 1){mineCounter++;}
                    if(minesweeper[x-1][y-1] == 1){mineCounter++;}
                    if(minesweeper[x-1][y+1] == 1){mineCounter++;}
                    if(minesweeper[x+1][y-1] == 1){mineCounter++;}
                    if(minesweeper[x][y+1] == 1){mineCounter++;}
                    if(minesweeper[x][y-1] == 1){mineCounter++;}
                    if(minesweeper[x+1][y] == 1){mineCounter++;}
                    if(minesweeper[x-1][y] == 1){mineCounter++;}

                    if(mineCounter == 0){

                    }

                    String MC = Integer.toString(mineCounter);
                    shownBoard[x][y] = MC;


                }

                if(minesweeper[x][y] == 1){
                    System.out.println("KABOOM!!!!! \n You've lost :(");
                    GameOn = false;
                    break;
                }

                System.out.println("----------------Welcome to Minesweeper---------------------");

                for(int t = 0; t < shownBoard.length; t++){
                    System.out.println();

                    for(int l = 0; l < shownBoard[t].length; l++){
                        System.out.print("[" + shownBoard[t][l] + "] ");
                        if(l==9){
                            y_counter++;
                            System.out.print(" | " + y_counter);
                        }
                    }


                }

                System.out.println("\n-------------------------------------------");
                System.out.println("[0] [1] [2] [3] [4] [5] [6] [7] [8] [9]\n");
                y_counter = -1;

                // System.out.println(minesweeper[x][y]);

               // GameOn = false;
            }


    }
}