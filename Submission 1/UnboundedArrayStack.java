import java.util.NoSuchElementException;

/** An array-backed stack that grows when full and shrinks when half empty. */
public class UnboundedArrayStack<E> {
    private static final int MIN_CAPACITY = 2;
    private Object[] items = new Object[MIN_CAPACITY];
    private int size;

    /** Adds an item. The array doubles when there is no free slot. */
    public void push(E item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[size++] = item;
    }

    /** Removes and returns the top item. */
    @SuppressWarnings("unchecked")
    public E pop() {
        requireNotEmpty();
        int topIndex = --size;
        E item = (E) items[topIndex];
        items[topIndex] = null; // Release the reference so it can be garbage-collected.

        if (items.length > MIN_CAPACITY && size <= items.length / 2) {
            resize(Math.max(MIN_CAPACITY, items.length / 2));
        }
        return item;
    }

    /** Returns the top item without removing it. */
    @SuppressWarnings("unchecked")
    public E peek() {
        requireNotEmpty();
        return (E) items[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /** Current storage capacity, included to make resizing easy to observe. */
    public int capacity() {
        return items.length;
    }

    private void requireNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    private void resize(int newCapacity) {
        Object[] biggerOrSmaller = new Object[newCapacity];
        System.arraycopy(items, 0, biggerOrSmaller, 0, size);
        items = biggerOrSmaller;
    }
}
