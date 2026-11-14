import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

/** A stack made from two queues. Pop is fast; push moves existing items. */
public class QueueStackPopFriendly<E> {
    private Queue<E> main = new ArrayDeque<>();
    private Queue<E> helper = new ArrayDeque<>();

    /** Adds an item to the top of the stack. Runs in O(n). */
    public void push(E item) {
        helper.offer(item);
        while (!main.isEmpty()) {
            helper.offer(main.remove());
        }
        swapQueues();
    }

    /** Removes and returns the top item. Runs in O(1). */
    public E pop() {
        requireNotEmpty();
        return main.remove();
    }

    /** Returns the top item without removing it. Runs in O(1). */
    public E peek() {
        requireNotEmpty();
        return main.element();
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public int size() {
        return main.size();
    }

    private void requireNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    private void swapQueues() {
        Queue<E> oldMain = main;
        main = helper;
        helper = oldMain;
    }
}
