import javafx.scene.canvas.GraphicsContext;

public class Animation {
    Shape[] shapes;
    int frames;
    float speed;

    public Animation(String filepath){
        //load from file
    }

    public void render(GraphicsContext gc) {
        for(int i = 0; i < shapes.length; i++){
            shapes[i].render(gc);
        }
    }
}
