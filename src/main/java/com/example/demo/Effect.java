package com.example.demo;

public class Effect {
    public void setFrame(int frame) {
        this.frame = frame;
    }

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

    public Effect(){
    }
}
