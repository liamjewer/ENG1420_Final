package com.example.demo;

import javafx.scene.canvas.GraphicsContext;


public class Line extends Shape {
    public void setX2(int x2) {
        this.x2 = x2;
    }

    int x2 = 10;

    public void setY2(int y2) {
        this.y2 = y2;
    }

    int y2 = 10;
    public Line() {
        super();
    }


    @Override
    public void render(GraphicsContext gc) {
        if(visible) {
            gc.setStroke(color);
            gc.setLineWidth(borderThicc);

            gc.strokeLine(x, y, x2, y2);
        }
    }
}
