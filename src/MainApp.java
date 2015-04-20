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
        stage.setHeight(400);

        animationPane = new AnimationPane();
        Scene scene = new Scene(animationPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        animationPane.setBackgroundImage("Halob.jpg");
        halo=new Halo();
        halo.setLayoutX(animationPane.getWidth()/2);
        halo.setLayoutY(animationPane.getHeight() - 100);
        halo.stand();

        animationPane.setOnKeyPressed(event -> keyPressed(event));
        animationPane.requestFocus();
        animationPane.add(halo);



    }


    private void keyPressed(KeyEvent event) {
        System.out.println(event.getCode().getName());
        if (event.getCode().getName().equals("Right")){halo.walkRight();}
        if(event.getCode().getName().equals("Left")){halo.walkLeft();}
        if(event.getCode().getName().equals("Down")){halo.crouch();}
        if(event.getCode().getName().equals("Up")){halo.stand();}



    }

    public static void main(String[] args) {
        launch(args);
    }
}