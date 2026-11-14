import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/** A FIFO queue made from two stacks. Enqueue is fast; dequeue moves items. */
public class StackQueueEnqueueFriendly<E> {
    private final Deque<E> main = new ArrayDeque<>();
    private final Deque<E> helper = new ArrayDeque<>();

    /** Adds an item at the back of the queue. Runs in O(1). */
    public void enqueue(E item) {
        main.push(item);
    }

    /** Removes and returns the oldest item. Runs in O(n). */
    public E dequeue() {
        requireNotEmpty();
        moveNewestItemsToHelper();
        E oldest = main.pop();
        restoreItems();
        return oldest;
    }

    /** Returns the oldest item without removing it. Runs in O(n). */
    public E peek() {
        requireNotEmpty();
        moveNewestItemsToHelper();
        E oldest = main.pop();
        helper.push(oldest);
        restoreItems();
        return oldest;
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public int size() {
        return main.size();
    }

    private void moveNewestItemsToHelper() {
        while (main.size() > 1) {
            helper.push(main.pop());
        }
    }

    private void restoreItems() {
        while (!helper.isEmpty()) {
            main.push(helper.pop());
        }
    }

    private void requireNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
    }
}
