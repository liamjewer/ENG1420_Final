import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnimationPlayer extends Application {
    Animation animation;
    int currentFrame;

    Group root;
    Scene scene;
    Canvas canvas;
    GraphicsContext gc;

    public AnimationPlayer(){
        currentFrame = 0;
    }

    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        scene = new Scene(root, 800, 450);
        canvas = new Canvas(800,450);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        stage.setTitle("Animation");
        stage.setScene(scene);
        stage.show();

        animate();
    }

    Runnable recursiveCall = new Runnable() {
        @Override
        public void run() {
            animate();
        }
    };

    public void animate(){
        if(currentFrame > animation.frames) return;//base case
        //clear last frame
        gc.clearRect(0, 0, 800, 450);
        //render frame
        for(int i = 0; i < animation.shapes.length; i++){
            for(int n = 0; n < animation.shapes[i].effects.size(); n++){
                switch(animation.shapes[i].effects.get(n).type){
                    case Show:
                        animation.shapes[i].show();
                        break;
                    case Hide:
                        animation.shapes[i].hide();
                        break;
                    case Jump:
                        Jump jump = (Jump)(animation.shapes[i].effects.get(n));
                        animation.shapes[i].jump(jump.x, jump.y);
                        break;
                    case Change:
                        Change change = (Change)(animation.shapes[i].effects.get(n));
                        animation.shapes[i].changeColor(change.color);
                        break;
                }
            }
        }
        animation.render(gc);
        delay(1/animation.speed, recursiveCall);//recursive call with frame delay speed is in frames/second so 1/speed is in seconds per frame
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
