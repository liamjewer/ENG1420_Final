package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Shape {
    public void setColor(Color color) {
        this.color = color;
    }

    Color color = Color.rgb(0,0,0);

    public void setBcolor(Color bcolor) {
        Bcolor = bcolor;
    }

    Color Bcolor = Color.rgb(0,0,0);

    public void setBorderThicc(int borderThicc) {
        this.borderThicc = borderThicc;
    }

    int borderThicc = 1;

    public void setX(int x) {
        this.x = x;
    }

    int x = 0;

    public void setY(int y) {
        this.y = y;
    }

    int y = 0;
    boolean visible;
    ArrayList<Effect> effects;

    public abstract void render(GraphicsContext gc);


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
        effects = new ArrayList<>();
    }

}
