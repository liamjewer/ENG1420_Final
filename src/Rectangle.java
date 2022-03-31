import java.awt.*;

public class Rectangle extends Shape{
int width;
int length;

    public Rectangle(Color c, Color Bc, int Bt, int x1, int y1, int w, int l) {
        super(c, Bc, Bt, x1, y1);
        length = l;
        width = w;
    }


}
