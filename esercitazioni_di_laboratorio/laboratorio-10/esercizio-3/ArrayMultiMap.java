public class ArrayMultiMap implements MultiMap {

    private Pair[] pair;
    private int size = 0;
    private static final int CAPACITY = 20;

    public ArrayMultiMap() {
        pair = new Pair[CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < size; i++) {
            pair[i] = null;
        }
    }

    // change to insert in correct order
    @Override
    public void insert(Object key, Object value) {
        int pos = binarySearch(key);
        if (pos != -1) {
            pair[pos] = new Pair((Comparable) key, value);
            return;
        }
        if (size == pair.length)
            pair = resize(pair, pair.length * 2);
        int index = size - 1;
        while (index >= 0 && ((Comparable) key).compareTo(pair[index].getKey()) < 0) {
            pair[index + 1] = pair[index];
            index--;
        }
        pair[index + 1] = new Pair((Comparable) key, value);
        size++;
    }

    @Override
    public Object remove(Object key) {
        int pos = binarySearch(key);
        if (pos == -1)
            return null;
        Object removedObject = pair[pos].getValue();
        for (int i = pos; i < pair.length - 1; i++) {
            pair[i] = pair[i + 1];
        }
        size--;
        return removedObject;
    }

    @Override
    public Object find(Object key) {
        int pos = binarySearch(key);
        if (pos == -1)
            return null;
        return pair[pos].getValue();
    }

    @Override
    public Object[] findAll(Object key) {
        Object[] values = new Object[0];
        int valuesIndex = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(pair[i].getKey())) {
                values = resize(values);
                values[valuesIndex] = pair[i].getValue();
                valuesIndex++;
            }
        }
        return values;
    }

    @Override
    public Object[] keys() {
        Object[] keys = new Object[size + 1];
        for (int i = 0; i < size; i++)
            keys[i] = pair[i].getValue();
        return keys;
    }

    @Override
    public Object[] removeAll(Object key) {
        Object[] keys = new Object[0];
        int keysIndex = 0;
        for (int i = 0; i < size; i++) {
            if (pair[i].getKey().equals(key)) {
                keys = resize(keys);
                keys[keysIndex] = pair[i].getValue();
                keysIndex++;
            }
            pair[i] = null;
        }
        size = 0;
        return keys;
    }

    public String getSize() {
        return Integer.toString(size);
    }

    private static Object[] resize(Object[] arr) {
        Object[] newArr = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private Pair[] resize(Pair[] oldPair, int newLength) {
        Pair[] newPair = new Pair[newLength];
        for (int i = 0; i < oldPair.length; i++) {
            newPair[i] = oldPair[i];
        }
        return newPair;
    }

    private int binarySearch(Object key) {
        if (!(key instanceof Comparable))
            return -1;
        return binarySearch(0, size - 1, (Comparable) key);
    }

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
