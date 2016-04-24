import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Created by kadefreeman on 4/10/16.
 *
 */


public class Board {

    private final int[][] array;
    private final int emptyRowPos, emptyColPos;

    public Board(int[][] newArray) {
        this.array = newArray;
        int findEmptyX = -1, findEmptyY = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] == 0) {
                    findEmptyX   = i;
                    findEmptyY = j;
                }
            }
        }
        emptyRowPos = findEmptyX;
        emptyColPos = findEmptyY;
    }

    public static Board startBoard() {

        //Allows user to enter a shuffled fifteen puzzle

        int a[][] = new int[4][4];
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your current configuration of the board and I will solve it.");
        System.out.println("Use 0 to denote the empty space.");

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.println("Enter value: " + row + " " + col);
                a[row][col] = input.nextInt();
            }
        }

        System.out.println("Here is your starting board:");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" | " + a[i][j] + " | ");
            }
            System.out.println();
        }

        return new Board(a);
    }

    public static Board finalBoard() {
        int[][] b = new int[3][3];

        b[0][0] = 1;
        b[0][1] = 2;
        b[0][2] = 3;
        b[0][3] = 4;
        b[1][0] = 5;
        b[1][1] = 6;
        b[1][2] = 7;
        b[1][3] = 8;
        b[2][0] = 9;
        b[2][1] = 10;
        b[2][2] = 11;
        b[2][3] = 12;
        b[3][0] = 13;
        b[3][1] = 14;
        b[3][2] = 15;
        b[3][3] = 0;

        return new Board(b);
    }

    public int hammingDist() {
        int ham = 0;

        Board correctBoard = Board.finalBoard();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] != correctBoard.array[i][j]) {
                    ham++;
                }
            }
        }
        return ham;
    }

    public boolean isGoal() {
        return this.hammingDist() == 0;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Board)) return false;

        Board other = (Board) obj;

        // test to see if the arrays contain the same things
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.array[i][j] != other.array[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                hash *= 31;
                hash += this.array[i][j];
            }
        }
        return hash;
    }

    public Board[] getNeighbors() {

        //TODO: Implement this

        ArrayList<Board> neighbors = new ArrayList<>();

        if(emptyRowPos > 0) {

            int[][] copyArray = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    copyArray[i][j] = array[i][j];
                }
            }

            copyArray[emptyRowPos][emptyColPos] = array[emptyRowPos-1][emptyColPos];
            copyArray[emptyRowPos-1][emptyColPos] = 0;

            Board newNeighbor = new Board(copyArray);
            neighbors.add(newNeighbor);
        }

        if (emptyColPos > 0) {

            int[][] copyArray = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    copyArray[i][j] = array[i][j];
                }

                copyArray[emptyRowPos][emptyColPos] = array[emptyRowPos][emptyColPos-1];
                copyArray[emptyRowPos][emptyColPos-1] = 0;

                Board newNeighbor = new Board(copyArray);
                neighbors.add(newNeighbor);
            }
        }

        if(emptyRowPos >= 0) {

            int[][] copyArray = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    copyArray[i][j] = array[i][j];
                }
            }

            copyArray[emptyRowPos][emptyColPos] = array[emptyRowPos+1][emptyColPos];
            copyArray[emptyRowPos+1][emptyColPos] = 0;

            Board newNeighbor = new Board(copyArray);
            neighbors.add(newNeighbor);
        }

        if(emptyRowPos <= 0) {

            int[][] copyArray = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    copyArray[i][j] = array[i][j];
                }
            }

            copyArray[emptyRowPos][emptyColPos] = array[emptyRowPos][emptyColPos+1];
            copyArray[emptyRowPos][emptyColPos+1] = 0;

            Board newNeighbor = new Board(copyArray);
            neighbors.add(newNeighbor);
        }

        Board[] neighborsArray = new Board[neighbors.size()];
        neighbors.toArray(neighborsArray);
        return neighborsArray;

    }

}
