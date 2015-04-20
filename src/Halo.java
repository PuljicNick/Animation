import sprite.Sprite;

/**
 * Created by puljicn on 4/13/15.
 */
public class Halo extends Sprite {
    public Halo() {
        super("SpriteH.png");

        createAnimation("standing", 120);

        for (int x = 0; x < 75; x+=50) {
            addFrame("standing", x, 0, 50, 70);
        }

        createAnimation("walking", 100);

        for (int x = 163; x < 600; x+=50) {
            addFrame("walking", x, 0, 48, 70);
        }
        addFrame("walking",113,0,48,70);
        
        createAnimation("crouch",100);

        for (int x = 100; x < 175; x+=50) {
            addFrame("crouch", x, 75, 46, 75);
        }
        addFrame("crouch",190,75,43,75);
        addFrame("crouch",235,75,50,75);
        addFrame("crouch",100,75,46,75);


    }

    public void stand() {
        play("standing");
        setSpeed(0);
    }

    public void walkRight() {
        play("walking");
        setSpeed(3);
        setAngle(90);
        flipHorizontally(false);
    }

    public void walkLeft() {
        play("walking");
        setSpeed(3);
        setAngle(270);
        flipHorizontally(true);
    }
    public void crouch(){
        play("crouch","standing");
        setSpeed(0);
    }
}
