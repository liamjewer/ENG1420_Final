import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Rectangle extends Shape{
int width;
int length;

    public Rectangle(Color c, Color Bc, int Bt, int x1, int y1, int w, int l) {
        super(c, Bc, Bt, x1, y1);
        length = l;
        width = w;
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.setStroke(Bcolor);
        gc.setLineWidth(borderThicc);

        gc.fillRect(x,y,width,length);
        gc.strokeRect(x,y,width,length);
    }
}
