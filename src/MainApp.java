import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sprite.AnimationPane;

public class MainApp extends Application {
    private AnimationPane animationPane;
    private Halo halo;
    private Megaman megaman;

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

        megaman= new Megaman();
        megaman.setLayoutX(animationPane.getWidth()/2-50);
        megaman.setLayoutY(animationPane.getHeight() - 60);
        megaman.stand();

        animationPane.setOnKeyPressed(event -> keyPressed(event));
        animationPane.requestFocus();
        animationPane.add(halo);
        animationPane.add(megaman);



    }


    private void keyPressed(KeyEvent event) {
        System.out.println(event.getCode().getName());
        if (event.getCode().getName().equals("Right")){halo.walkRight();}
        if(event.getCode().getName().equals("Left")){halo.walkLeft();}
        if(event.getCode().getName().equals("Down")){halo.crouch();}
        if(event.getCode().getName().equals("Up")){halo.stand();}

        if (event.getCode().getName().equals("A")){megaman.runleft();}
        if(event.getCode().getName().equals("D")){megaman.runright();}
        if (event.getCode().getName().equals("S")){megaman.stand();}
        if(event.getCode().getName().equals("W")){megaman.fistpump();}



    }

    public static void main(String[] args) {
        launch(args);
    }
}