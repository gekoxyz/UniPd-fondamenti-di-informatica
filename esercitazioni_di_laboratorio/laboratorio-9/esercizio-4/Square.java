import java.awt.Rectangle;

public class Square extends Rectangle {

    public Square(int x, int y, int side) {
        super(x, y, side, side);
    }

    public double getArea() {
        return super.getWidth() * super.getHeight();
    }

    @Override
    public void setSize(int width, int height) {
        if (width != height)
            throw new IllegalArgumentException();
        else
            super.setSize(width, height);
    }

    public void setSize(int dim) {
        super.setSize(dim, dim);
    }
}