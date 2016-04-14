/**
 * Created by kadefreeman on 4/10/16.
 */

public class BoardSearch implements Comparable<BoardSearch> {
    final Board board; // a board, which we are encapsulating
    int distSoFar;
    final int estDist; //estimate of the number of moves required to solve board

    public BoardSearch(Board b, int eD) {
        this.board = b;
        this.estDist = eD;
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof BoardSearch)) return false;
        BoardSearch other = (BoardSearch) obj;
        return this.board.equals(other.board);
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }

    public int compareTo(BoardSearch other) {
        if(this.estDist < other.estDist)
            return -1;
        else if(this.estDist > other.estDist)
            return 1;
        else return 0;
    }

}
