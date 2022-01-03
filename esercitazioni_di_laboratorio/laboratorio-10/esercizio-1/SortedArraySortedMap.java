public class SortedArraySortedMap implements SortedMap {

    private Pair[] pair;
    private int size;

    public SortedArraySortedMap() {
        this.pair = new Pair[20];
    }

    @Override
    public Object put(Object key, Object value) {
        // think how to insert the item in the array
        // i must find the correct insert position
        // while key compareto keytoinsert < 0 go next
        // when found start shifting
        // if i go from last position and shift it's better
        if (key == null || value == null)
            throw new IllegalArgumentException();
        int pos = binSearch(key);
        if (pos >= 0) {
            Object oldObject = pair[pos].getValue();
            pair[pos] = new Pair((Comparable) key, value);
            return oldObject;
        }
        if (size == pair.length)
            pair = resize(pair, 2 * pair.length);
        int index = size - 1;
        while (index >= 0 && ((Comparable) key).compareTo(pair[index].getKey()) < 0) {
            pair[index + 1] = pair[index];
            index--;
        }
        pair[index + 1] = new Pair((Comparable) key, value);
        size++;
        return null;
    }

    @Override
    public Object get(Object key) {
        int keyPosition = binSearch(key);
        if (keyPosition == -1)
            return null;
        return pair[keyPosition];
    }

    @Override
    public Object remove(Object key) {
        int keyPosition = binSearch(key);
        if (keyPosition == -1)
            return null;
        Object removed = pair[keyPosition].getValue();
        for (int i = keyPosition; i < size - 1; i++) {
            pair[i] = pair[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public Object[] keys() {
        return sortedKeys();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void makeEmpty() {
        size = 0;
    }

    @Override
    public Comparable[] sortedKeys() {
        Comparable[] keys = new Comparable[size];
        for (int i = 0; i < size; i++) {
            keys[i] = pair[i].getKey();
        }
        return keys;
    }

    public int getSize() {
        return size;
    }

    private int binSearch(Object key) {
        if (!(key instanceof Comparable))
            return -1;
        return binarySearch(0, size - 1, (Comparable) key);
    }

    /**
     * method to execute the binary search on pair array, calls the recursive
     * function according to the value of the compareTo if it does not give a match
     * 
     * @param left
     * @param right
     * @param toSearch
     * @return the value of the searched element if compareTo returns 0
     */
    private int binarySearch(int left, int right, Comparable toSearch) {
        if (left > right)
            return -1;
        int avg = (left + right) / 2;
        int compared = pair[avg].getKey().compareTo(toSearch);
        if (compared == 0)
            return avg;
        if (compared < 0)
            return binarySearch(avg + 1, right, toSearch);
        else
            return binarySearch(left, avg - 1, toSearch);
    }

    private Pair[] resize(Pair[] oldPair, int newSize) {
        Pair[] newPair = new Pair[newSize];
        for (int i = 0; i < oldPair.length; i++) {
            newPair[i] = oldPair[i];
        }
        return newPair;
    }

    private class Pair {
        Comparable key;
        Object value;

        public Pair(Comparable key, Object value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(Comparable newKey) {
            this.key = newKey;
        }

        public void setValue(Object newValue) {
            this.value = newValue;
        }

        public Comparable getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

}