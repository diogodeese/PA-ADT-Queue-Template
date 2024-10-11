package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.*;

abstract class QueueLinkedListTestBase<T> {
    protected Queue<T> queue;

    @BeforeEach
    void setUp() {
        queue = createQueue();
    }

    protected abstract Queue<T> createQueue();

    @Test
    void FIFO() {
        queue.enqueue((T) valueOf(1));
        queue.enqueue((T) valueOf(2));
        queue.enqueue((T) valueOf(3));

        assertEquals((T) valueOf(1), queue.front());
        assertEquals((T) valueOf(1), queue.dequeue());
        assertEquals((T) valueOf(2), queue.front());
        assertEquals((T) valueOf(2), queue.dequeue());
        assertEquals((T) valueOf(3), queue.front());
        assertEquals((T) valueOf(3), queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void dequeueThrowsExceptionOnEmptyQueue() {
        assertThrows(QueueEmptyException.class, () -> queue.dequeue());
    }

    @Test
    void frontThrowsExceptionOnEmptyQueue() {
        assertThrows(QueueEmptyException.class, () -> queue.front());
    }

    @Test
    void size() {
        assertEquals(0, queue.size());

        for (int i = 1; i < 5; i++) {
            queue.enqueue((T) valueOf(i));
            assertEquals(i, queue.size());
        }

        for (int i = 1; i < 5; i++) {
            assertEquals(5 - i, queue.size());
            queue.dequeue();
        }
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue((T) valueOf(10));
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void clear() {
        queue.enqueue((T) valueOf(1));
        queue.enqueue((T) valueOf(2));
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void clearOnEmptyQueue() {
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }
}