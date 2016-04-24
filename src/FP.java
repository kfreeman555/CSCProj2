import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * Created by kadefreeman on 4/22/16.
 */
public class FP {

    public static void main(String[] args) {
        Board startingBoard = Board.startBoard();
        BoardSearch startingBoardSearch = new BoardSearch(startingBoard,0);


        PriorityQueue<BoardSearch> boardQueue = new PriorityQueue<>();
        Hashtable<Board,Board> childParent = new Hashtable<>();
        childParent.put(startingBoard,null);
        
        boardQueue.add(startingBoardSearch);

        while(!boardQueue.isEmpty()) {

            // dequeue a board search

            // check to see if board contained inside is the solution

            // get the neighbors of the board in the board search

            // put them in their own boardsearch's with a distSoFar one higher

            // add them to the Prioritry queue

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
