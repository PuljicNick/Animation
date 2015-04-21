
import sprite.Sprite;

/**
 * Created by Race on 4/20/2015.
 */
public class Megaman extends Sprite {
    public Megaman() {
        super("megamanx.png");
        createAnimation("standing",300);
        for (int x = 210; x <300; x+=34) {
        addFrame("standing",x,21,35,36);
        }

        createAnimation("running",40);
            addFrame("running", 315, 21, 35, 36);
            addFrame("running", 350, 21, 20, 36);
            addFrame("running", 370, 21, 25, 36);
            addFrame("running", 395, 21, 30, 36);
            addFrame("running", 425, 21, 35, 36);
            addFrame("running", 460, 21, 25, 36);
            addFrame("running", 485, 21, 25, 36);
            addFrame("running", 510, 21, 25, 36);
            addFrame("running", 535, 21, 35, 36);
            addFrame("running", 570, 21, 35, 36);
            addFrame("running",605,21,35,36);

        createAnimation("fistpumping",210);
        for (int i = 472; i <600 ; i+=31) {
            addFrame("fistpumping",i,120,27,40);
        }







}
public void stand(){
    play("standing");
    setSpeed(0);
}
    public void runright(){
    play("running");
    setSpeed(3);
        setAngle(90);
        flipHorizontally(false);
}
    public void runleft(){
        flipHorizontally(true);
        setAngle(270);
        play("running");
        setSpeed(3);
    }
    public void fistpump(){
        if (isStanding()) {
            setAngle(0);
            setSpeed(3);
            applyGravity(2);
            play("fistpumping", "standing");
        } else if (isRunningLeft()) {
            setAngle(330);
            setSpeed(3);
            applyGravity(2);
            play("fistpumping", "standing");

        } else if (isRunningRight()) {
            setAngle(30);
            setSpeed(3);
            applyGravity(2);
            play("fistpumping", "standing");
        }



    }

    public boolean isStanding() {
        return getAnimationName().equals("standing");
    }

    public boolean isRunningLeft() {
        return getAnimationName().equals("running") && getAngle() == 270;
    }

    public boolean isRunningRight() {
        return getAnimationName().equals("running") && getAngle() == 90;
    }


}
