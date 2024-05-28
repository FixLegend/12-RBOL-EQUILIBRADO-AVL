package proje;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLink<E> {
    private Queue<E> queue;

    public QueueLink() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(E item) {
        queue.add(item);
    }

    public E dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
