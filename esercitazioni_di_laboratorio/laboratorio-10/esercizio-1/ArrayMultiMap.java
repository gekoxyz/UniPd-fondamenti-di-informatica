public class ArrayMultiMap implements MultiMap {

    private Pair[] pair;
    private int size = 0;
    private static final int CAPACITY = 10;

    public ArrayMultiMap() {
        pair = new Pair[10];
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

    @Override
    public void insert(Object key, Object value) {
        if (size < CAPACITY) {
            pair[size] = new Pair(key, value);
            size++;
        }
    }

    @Override
    public Object remove(Object key) {
        for (int i = 0; i < size; i++) {
            if (pair[i].getKey().equals(key)) {
                Object removed = pair[i].getValue();
                pair[i] = pair[size - 1];
                size--;
                return removed;
            }
        }
        return null;
    }

    @Override
    public Object find(Object key) {
        for (int i = 0; i < size; i++) {
            if (pair[i].getKey().equals(key)) {
                return pair[i].getValue();
            }
        }
        return null;
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

    public String size() {
        return Integer.toString(size);
    }

    private static Object[] resize(Object[] arr) {
        Object[] newArr = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
