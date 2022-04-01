public class Animation {
    Shape[] shapes;
    int frames;
    float speed;

    public Animation(int frames, float speed, Shape[] shapes){
        this.frames = frames;
        this.speed = speed;
        this.shapes = shapes;
    }
}
