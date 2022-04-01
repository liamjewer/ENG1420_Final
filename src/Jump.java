public class Jump extends Effect{
    int x, y;
    public Jump(int frame, Type type, int x, int y) {
        super(frame, type);
        this.x = x;
        this.y = y;
        type = Type.Jump;
    }
}
