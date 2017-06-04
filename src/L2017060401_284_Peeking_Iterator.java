import java.util.Iterator;

/**
 */
public class L2017060401_284_Peeking_Iterator {

    class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer next;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            if (iterator.hasNext()) {
                next = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer result = next;
            next = iterator.hasNext() ? iterator.next() : null;
            return result;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }

    class PeekingIterator_mine implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer peek;

        public PeekingIterator_mine(Iterator<Integer> iterator) {
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (peek == null) {
                peek = iterator.next();
            }
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peek != null) {
                Integer result = peek;
                peek = null;
                return result;
            }

            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            if (peek != null) {
                return true;
            }

            return iterator.hasNext();
        }
    }
}