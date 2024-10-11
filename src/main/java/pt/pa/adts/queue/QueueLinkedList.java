package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        init();
    }

    private void init() {
        header = new ListNode(null, null, null);
        trailer = new ListNode(null, header, null);
        header.next = trailer;
        size = 0;
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullNotAllowedException {
            ListNode newListNode = new ListNode(elem, trailer.prev, trailer);
            trailer.prev.next = newListNode;
            trailer.prev = newListNode;
            size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if(isEmpty()) throw new QueueEmptyException();

        ListNode removed = header.next;
        header.next = removed.next;
        header.next.prev = header;
        size--;

        return removed.element;
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException();
        return header.next.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        init();
    }

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
