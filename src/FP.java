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
        childParent.put(startingBoard, null);  //puts the startingBoard in the childParent hashtable

        boardQueue.add(startingBoardSearch); //adds startingBoardSearch to boardQueue

        while (!boardQueue.isEmpty()) {  //while boardQueue is not empty

            // dequeue a board search
            BoardSearch dequeueSearch = boardQueue.peek();  // create a new board search, dequeue search from boardQueue
            Board dequeue = dequeueSearch.board;  //create a new board, dequeue, from dequeueSearch

            // check to see if board contained inside is the solution
            if (dequeue == finalBoard) {
                break;
            }

            // get the neighbors of the board in the board search
            Board[] neighborsArray = dequeue.getNeighbors();  // gets the neighbors of the dequeue-d board

            // put them in their own boardsearch's with a distSoFar one higher
            //add them to the priority queue
            if (neighborsArray.length == 4) {
                BoardSearch neighborsSearch1 = new BoardSearch(neighborsArray[0], +1);
                BoardSearch neighborsSearch2 = new BoardSearch(neighborsArray[1], +1);
                BoardSearch neighborsSearch3 = new BoardSearch(neighborsArray[2], +1);
                BoardSearch neighborsSearch4 = new BoardSearch(neighborsArray[3], +1);
                boardQueue.add(neighborsSearch1);
                boardQueue.add(neighborsSearch2);
                boardQueue.add(neighborsSearch3);
                boardQueue.add(neighborsSearch4);
            }

            if (neighborsArray.length == 3) {
                BoardSearch neighborsSearch1 = new BoardSearch(neighborsArray[0], +1);
                BoardSearch neighborsSearch2 = new BoardSearch(neighborsArray[1], +1);
                BoardSearch neighborsSearch3 = new BoardSearch(neighborsArray[2], +1);
                boardQueue.add(neighborsSearch1);
                boardQueue.add(neighborsSearch2);
                boardQueue.add(neighborsSearch3);
            }

            if (neighborsArray.length == 2) {
                BoardSearch neighborsSearch1 = new BoardSearch(neighborsArray[0], +1);
                BoardSearch neighborsSearch2 = new BoardSearch(neighborsArray[1], +1);
                boardQueue.add(neighborsSearch1);
                boardQueue.add(neighborsSearch2);
            }

            if (neighborsArray.length == 1) {
                BoardSearch neighborsSearch1 = new BoardSearch(neighborsArray[0], +1);
                boardQueue.add(neighborsSearch1);
            }

            if (neighborsArray.length == 0) {
                return;
            }

        }


//read in a string, scanner.nextint 15 times, gets you a new element in the array
        //use a 2dimensional array
//use hashtable in the A* search

        //add starting position to queue
        //enqueue all the possible different borads from there

        //use java's priority queue

        //use builtin hashtables and priority queues from java.

    }
}