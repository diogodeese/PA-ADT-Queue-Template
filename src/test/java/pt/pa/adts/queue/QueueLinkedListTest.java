package pt.pa.adts.queue;

class QueueLinkedListTest extends QueueLinkedListTestBase<Integer> {

    @Override
    protected Queue<Integer> createQueue() {
        return new QueueLinkedList<>();
    }
}