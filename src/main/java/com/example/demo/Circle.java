package com.example.demo;

import javafx.scene.canvas.GraphicsContext;


public class Circle extends Shape {

    public void setRadius(int radius) {
        this.radius = radius;
    }

    int radius;

    public Circle() {
        super();
    }


    @Override
    public void render(GraphicsContext gc) {
        if(visible) {
            gc.setFill(color);
            gc.setStroke(Bcolor);
            gc.setLineWidth(borderThicc);

            gc.fillOval(x, y, radius * 2, radius * 2);
            gc.strokeOval(x, y, radius * 2, radius * 2);
        }
    }
}
