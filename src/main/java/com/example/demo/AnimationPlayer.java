package com.example.demo;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class AnimationPlayer extends Application {
    public void setAnimationPath(String path) {
        animationPath = path;
    }

    public static void main(String[] args){
        launch();
    }

    String animationPath;
    Animation animation;
    int currentFrame = 0;

    Group root;
    Scene scene;
    Canvas canvas;
    GraphicsContext gc;

    public void play() {
        launch();
    }

    public AnimationPlayer(){
}

    @Override
    public void start(Stage stage) throws Exception {
        animation = new Animation("src\\main\\java\\com\\example\\demo\\input.txt");
        //setup javaFX window
        root = new Group();
        scene = new Scene(root, 800, 450);
        canvas = new Canvas(800,450);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        stage.setTitle("Animation");
        stage.setScene(scene);
        stage.show();

        //start the recursive function to animate
        animate();
    }

    Runnable recursiveCall = this::animate;

    public void animate(){
        if(currentFrame > animation.frames) System.exit(0);//base case
        //clear last frame
        gc.clearRect(0, 0, 800, 450);
        //render frame
        for(int i = 0; i < animation.shapes.size(); i++){//go through all shapes
            for(int n = 0; n < animation.shapes.get(i).effects.size(); n++){
                if(animation.shapes.get(i).effects.get(n).frame == currentFrame) {
                    switch (animation.shapes.get(i).effects.get(n).type) {
                        case Show:
                            animation.shapes.get(i).show();
                            break;
                        case Hide:
                            animation.shapes.get(i).hide();
                            break;
                        case Jump:
                            Jump jump = (Jump) (animation.shapes.get(i).effects.get(n));
                            animation.shapes.get(i).jump(jump.x, jump.y);
                            break;
                        case Change:
                            Change change = (Change) (animation.shapes.get(i).effects.get(n));
                            animation.shapes.get(i).changeColor(change.color);
                            break;
                    }
                }
            }
        }
        animation.render(gc);
        currentFrame++;
        delay(1.0/(float)animation.speed, recursiveCall);//recursive call with frame delay speed is in frames/second so 1/speed is in seconds per frame
    }

    public static void delay(double seconds, Runnable next) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep((long)(seconds*1000));
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> next.run());
        new Thread(sleeper).start();
    }
}
