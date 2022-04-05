package com.example.demo;
//Child class of Effect for jump effect

public class Jump extends Effect{
    int x;      //x to jump to

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    int y;      //y to jump to
    public Jump() {      //constructor
        super();
        type = Type.Jump;
    }
}
