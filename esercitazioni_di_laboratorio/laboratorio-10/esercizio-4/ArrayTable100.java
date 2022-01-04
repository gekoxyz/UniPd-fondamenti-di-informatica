public class ArrayTable100 implements Table {

    private Object[] table;
    private int size;

    public ArrayTable100() {
        table = new Object[100];
        size = 0;
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
    public void insert(int key, Object value) {
        if (key < 0 || key >= 100)
            throw new InvalidPositionTableException();
        table[key] = value;
    }

    @Override
    public void remove(int key) {
        table[key] = null;
    }

    @Override
    public Object find(int key) {
        return table[key];
    }

}
