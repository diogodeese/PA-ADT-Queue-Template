package pt.pa.adts.queue;

public class QueueLinkedListNoNulls<T> extends QueueLinkedList<T> {

    @Override
    public void enqueue(T elem) throws QueueFullException, NullNotAllowedException {
        if (elem == null) {
            throw new NullNotAllowedException("Cannot enqueue a null element.");
        }

        super.enqueue(elem);
    }
}