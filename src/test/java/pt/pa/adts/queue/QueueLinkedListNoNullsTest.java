package pt.pa.adts.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListNoNullsTest extends QueueLinkedListTestBase<Integer> {

    @Override
    protected Queue<Integer> createQueue() {
        return new QueueLinkedListNoNulls<>();
    }

    @Test
    void enqueueThrowsExceptionOnNull() {
        assertThrows(NullNotAllowedException.class, () -> queue.enqueue(null));
    }
}