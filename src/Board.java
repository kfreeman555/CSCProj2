import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kadefreeman on 4/10/16.
 */
public class Board {

    // declares an array of integers

    public static void main(String[] args) {
        new Board();
    }

    Board() {
        getStartBoard();
    }

    public String[][] getStartBoard() {
        String a[][]=new String[4][4];
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your current configuration of the board and I will solve it.");
        System.out.println("Use '*' to denote an empty space.");

        for(int row=0;row<4;row++){
            for(int col=0;col<4;col++){
                System.out.println("Enter value: " + row + " " + col);
                a[row][col]=input.next();
            }
        }

        System.out.println("Here is your starting board:");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" | " + a[i][j] + " | ");
            }
            System.out.println();
        }

        return a;
    }


    public int hammingDist(int[][] board, int [][] correct) {
        int ham = 0;

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] != correct[i][j]) {
                    ham++;
                }
            }
        }
        return ham;
    }

    public boolean isGoal(int[][] a,int[][] b) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        // test to see if the arrays contain the same things
        return false;
    }

    @Override
    public int hashCode() {
        return 0; //make a number out of the array;
    }

    public Board(Board[] getNeighbors) {

        //TODO: Implement this

    }

//read in a string, scanner.nextint 15 times, gets you a new element in the array
    //use a 2dimensional array
//use hashtable in the A* search

    //add starting position to queue
    //enqueue all the possible different borads from there

    //use java's priority queue

    //use builtin hashtables and priority queues from java.
}
