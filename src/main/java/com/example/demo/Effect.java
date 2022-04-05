package com.example.demo;
//Parent Effect class
//Show and Hide effects are objects of this class

public class Effect {
    public void setFrame(int frame) {
        this.frame = frame;
    }

    int frame;       //The frame where the effect takes place
    Type type;       //The type is the type of effect

    enum Type{       //Define enum with types of effect
        Show,
        Hide,
        Jump,
        Change;
    }

    public Effect(int frame, Type type){      //Constructor
        this.frame = frame;
        this.type = type;
    }

    public Effect(){          //Default constructor
    }
}
