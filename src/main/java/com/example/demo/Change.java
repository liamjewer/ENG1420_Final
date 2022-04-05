package com.example.demo;
//Child class of Effect for change color effect

import javafx.scene.paint.Color;

public class Change extends Effect{
    public void setColor(Color color) {
        this.color = color;
    }

    Color color;    //color to change to
    public Change() {  //constructor
        super();
        type = Type.Change;
    }
}
