import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * Created by kadefreeman on 4/22/16.
 */

public class FP {

    public BoardSearch prioritySearch;

    public static void main(String[] args) {
        Board startingBoard = Board.startBoard(); //loads a starting board
        Board finalBoard = Board.finalBoard();    //loads the final board
        int distSoFar = 0;
        BoardSearch startingBoardSearch = new BoardSearch(startingBoard, distSoFar); //creates a BoardSearch, startingBoardSearch

        PriorityQueue<BoardSearch> boardQueue = new PriorityQueue<>();  //creates a new PriorityQueue, boardQueue
        Hashtable<Board, Board> childParent = new Hashtable<>(); //creates the Hashtable childParent
        childParent.put(startingBoard, startingBoard);  //puts the startingBoard in the childParent hashtable

        boardQueue.add(startingBoardSearch); //adds startingBoardSearch to boardQueue

        Board current;
        Board[] neighborsArray = new Board[4];

        while (!boardQueue.isEmpty()) {  //while boardQueue is not empty

            // dequeue a board search
            BoardSearch dequeueSearch = boardQueue.poll();  // create a new board search, dequeue search from boardQueue
            current = dequeueSearch.board;  //create a new board, dequeue, from dequeueSearch

            // check to see if board contained inside is the solution
            if (current == finalBoard) {
                break;
            }

            // get the neighbors of the board in the board search
            neighborsArray = current.getNeighbors();  // gets the neighbors of the dequeue-d board

            // put them in their own boardsearch's with a distSoFar one higher
            //add them to the priority queue

            for (int i = 0; i < neighborsArray.length; i++) {
                BoardSearch boardSearch = new BoardSearch(neighborsArray[i], dequeueSearch.distSoFar+1);
                boardQueue.add(boardSearch);
                childParent.put(neighborsArray[i],current);
                i++;
            }


        }

        //query hashtable for value with a while loop
        //push onto a stack and print out a new stack


    }
}