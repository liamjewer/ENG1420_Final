import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Line extends Shape{
int x2;
int y2;
    public Line(Color c, int Bt, int x1, int y1, int xx2, int yy2) {
        super(c, Color.rgb(0,0,0), Bt, x1, y1);
        x2 = xx2;
        y2 = yy2;
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(borderThicc);

        gc.strokeLine(x,y,x2,y2);
    }
}
