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
        pair[size] = new Pair(key, value);
        size++;
    }

    @Override
    public Object remove(Object key) {
        for (int i = 0; i < size; i++) {
            if (pair[i].getKey().equals(key)) {
                Object removed = pair[i].getValue();
                pair[i] = null;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] keys() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] removeAll(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

}
