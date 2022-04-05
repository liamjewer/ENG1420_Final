package com.example.demo;

import javafx.scene.paint.Color;

public class Change extends Effect{
    public void setColor(Color color) {
        this.color = color;
    }

    Color color;
    public Change() {
        super();
        type = Type.Change;
    }
}
