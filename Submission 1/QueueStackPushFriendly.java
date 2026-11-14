import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

/** A stack made from two queues. Push is fast; pop moves older items. */
public class QueueStackPushFriendly<E> {
    private Queue<E> main = new ArrayDeque<>();
    private Queue<E> helper = new ArrayDeque<>();

    /** Adds an item to the top of the stack. Runs in O(1). */
    public void push(E item) {
        main.offer(item);
    }

    /** Removes and returns the top item. Runs in O(n). */
    public E pop() {
        requireNotEmpty();
        while (main.size() > 1) {
            helper.offer(main.remove());
        }
        E top = main.remove();
        swapQueues();
        return top;
    }

    /** Returns the top item without removing it. Runs in O(n). */
    public E peek() {
        requireNotEmpty();
        while (main.size() > 1) {
            helper.offer(main.remove());
        }
        E top = main.remove();
        helper.offer(top);
        swapQueues();
        return top;
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
