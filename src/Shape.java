import java.awt.*;

public abstract class Shape {
    Color color;
    Color Bcolor;
    int borderThicc;
    int x;
    int y;
    boolean visible;



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
            }

}
