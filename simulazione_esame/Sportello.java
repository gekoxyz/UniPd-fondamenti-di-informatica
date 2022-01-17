// Matteo Galiazzo
public class Sportello extends FixedCircularArrayQueue {

    public int getSize() {
        int size;
        if (back >= front) {
            size = back - front;
        } else {
            size = (v.length - front + back);
        }
        return size;
    }

    public Object dequeue() {
        int time = (int) getFront();
        if (time == 1)
            return super.dequeue();
        else
            v[front] = time;
        return v[front];
    }

    public String toString() {
        return getSize() + " clienti: " + super.toString();
    }
}
