package com.example.demo;

import javafx.scene.canvas.GraphicsContext;


public class Rectangle extends Shape {
    public void setWidth(int width) {
        this.width = width;
    }

    int width = 10;

    public void setLength(int length) {
        this.length = length;
    }

    int length = 10;

    public Rectangle(){
        super();
    }


    @Override
    public void render(GraphicsContext gc) {
        if(visible) {
            gc.setFill(color);
            gc.setStroke(Bcolor);
            gc.setLineWidth(borderThicc);

            gc.fillRect(x, y, width, length);
            gc.strokeRect(x, y, width, length);
        }
    }
}
