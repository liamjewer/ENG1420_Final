package com.example.demo;

public class Jump extends Effect{
    int x;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    int y;
    public Jump() {
        super();
        type = Type.Jump;
    }
}
