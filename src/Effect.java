public class Effect {
    int frame;
    Type type;

    enum Type{
        Show,
        Hide,
        Jump,
        Change;
    }

    public Effect(int frame, Type type){
        this.frame = frame;
        this.type = type;
    }
}
