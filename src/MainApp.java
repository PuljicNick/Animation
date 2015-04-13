import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sprite.AnimationPane;

public class MainApp extends Application {
    private AnimationPane animationPane;
    private Halo halo;

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Sprite Application");
        stage.setWidth(1024);
        stage.setHeight(460);

        animationPane = new AnimationPane();
        Scene scene = new Scene(animationPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        animationPane.setOnKeyPressed(event -> keyPressed(event));
        animationPane.requestFocus();
        animationPane.setBackgroundImage("Halob.jpg");

        halo = new Halo();
        animationPane.add(halo);

        halo.setLayoutX(animationPane.getWidth() / 2);
        halo.setCenterY(animationPane.getHeight() - 120);

        halo.stand();
    }


    private void keyPressed(KeyEvent event) {
        System.out.println(event.getCode().getName());

        if (event.getCode().getName().equals("Left")) {
            halo.walkLeft();
        } else if (event.getCode().getName().equals("Right")){
            halo.walkRight();
        } else if(event.getCode().getName().equals("Down")){
            halo.crouch();
        }else {
            halo.stand();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}