# Submission 1 — Stacks and Queues

This folder contains the four Java implementations listed for Submission 1. A stack follows **Last In, First Out (LIFO)**: the newest item comes out first. A queue follows **First In, First Out (FIFO)**: the oldest item comes out first.

## Assignment files

- [QueueStackPushFriendly.java](QueueStackPushFriendly.java) — Stack implemented with two queues. `push` is quick; `pop` and `peek` move items to find the top.
- [QueueStackPopFriendly.java](QueueStackPopFriendly.java) — Stack implemented with two queues. `pop` and `peek` are quick; `push` moves existing items.
- [UnboundedArrayStack.java](UnboundedArrayStack.java) — Array-backed stack that grows when full and shrinks as items are removed.
- [StackQueueEnqueueFriendly.java](StackQueueEnqueueFriendly.java) — FIFO queue implemented with two stacks. `enqueue` is quick; `dequeue` and `peek` move items to find the oldest value.

## Small usage example

Put these statements inside a Java `main` method to try the classes:

```java
QueueStackPushFriendly<Integer> stack = new QueueStackPushFriendly<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // 20: last in, first out

StackQueueEnqueueFriendly<String> queue = new StackQueueEnqueueFriendly<>();
queue.enqueue("first");
queue.enqueue("second");
System.out.println(queue.dequeue()); // first: first in, first out

UnboundedArrayStack<Integer> resizable = new UnboundedArrayStack<>();
resizable.push(5);
System.out.println(resizable.peek()); // 5
```

The classes use Java generics, so they can hold different object types. Empty `pop`, `dequeue`, and `peek` calls throw `NoSuchElementException`.

To try the code locally, create `Main.java` in this folder, paste the example into its `main` method, then run `javac *.java` followed by `java Main`. The assignment files are the four implementation files listed above.
