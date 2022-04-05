/*
Authors: Liam Jewer, Charile Magri, Rydan Chalmers, and Hunter Adelson
code to create and run an animation from a file
2022/03/29
 */
package com.example.demo;

public class Main {

    public static void main(String[] args){
        AnimationPlayer player = new AnimationPlayer();
        player.setAnimationPath("src\\main\\java\\com\\example\\demo\\input.txt");
        player.play();
    }
}
