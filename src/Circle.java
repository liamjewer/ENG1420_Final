import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Circle extends Shape{

int radius;

    public Circle(Color c, Color Bc, int Bt, int x1, int y1, int r) {
        super(c, Bc, Bt, x1, y1);
        radius = r;
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.setStroke(Bcolor);
        gc.setLineWidth(borderThicc);

        gc.fillOval(x,y,radius*2,radius*2);
        gc.strokeOval(x,y,radius*2,radius*2);
    }
}
