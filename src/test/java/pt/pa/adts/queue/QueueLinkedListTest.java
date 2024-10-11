package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class QueueLinkedListTest {
    QueueLinkedList<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new QueueLinkedList<>();
    }

//    @Test
//    void FIFO() {
//
//    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        for (int i = 1; i < 5; i++) {
            queue.enqueue(i);
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
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}