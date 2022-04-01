import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Shape {
    Color color;
    Color Bcolor;
    int borderThicc;
    int x;
    int y;
    boolean visible;
    ArrayList<Effect> effects;
    Type type;

    public abstract void render(GraphicsContext gc);

    enum Type{
        Rectangle,
        Circle,
        Line;
    }


    void hide(){
     visible = false;
    }

    void show(){
    visible = true;
    }

    void jump(int x1, int y1){
        x = x1;
        y = y1;
    }

    void changeColor(Color c){
        color = c;

    }

    void addEffect(Effect e){
        effects.add(e);
    }

    public Shape(){
    visible = false;
    }

    public Shape(Color c,Color Bc,int Bt,int x1,int y1){
        color = c;
        Bcolor = Bc;
        borderThicc = Bt;
        x = x1;
        y = y1;
        visible = false;
        effects = new ArrayList<>();
    }

}
