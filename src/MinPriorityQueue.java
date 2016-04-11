
/**
 * Created by kadefreeman on 4/10/16.
 */

public interface MinPriorityQueue<Item extends Comparable<Item>> {

    /**
     * Construct an empty MinPriorityQueue
     */
    //MinPriorityQueue();

    /**
     * @returns true if the MinPriorityQueue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * inserts an item into the MinPriorityQueue
     * @param item the item to insert
     */
    void enqueue(Item item);

    /**
     * removes and returns the lowest priority element of the queue
     * @returns the lowest priority item
     */
    Item dequeue();
}
