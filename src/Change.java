import javafx.scene.paint.Color;

public class Change extends Effect{
    Color color;
    public Change(int frame, Type type, Color color) {
        super(frame, type);
        this.color = color;
        type = Type.Change;
    }
}
