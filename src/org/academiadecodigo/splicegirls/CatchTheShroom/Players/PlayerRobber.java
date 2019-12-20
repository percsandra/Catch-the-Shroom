package org.academiadecodigo.splicegirls.CatchTheShroom.Players;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.CatchTheShroom.Field;

public class PlayerRobber extends Player implements KeyboardHandler, Runnable {

    private Keyboard keyboard;
    private boolean movingRight = false;
    private boolean movingLeft = false;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private int delayCounter = 0;


    public PlayerRobber(Field field) {
        super(field);
        robberInit();
    }

    @Override
    public void run() {
        {
            try {


                    if (movingRight && getPic().getX() < getField().getRectangle().getWidth()){
                        while (movingRight) {
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom_Walk_4.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom_Walk_1.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom_Walk_2.png");
                            Thread.sleep(20);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom_Walk_3.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom_Walk_4.png");
                            Thread.sleep(10);
                            getPic().translate(getCellSize(), 0);
                            break;
                        }
                    }
                    if (movingLeft && getPic().getX() > getField().getRectangle().getX()){
                        while (movingLeft) {
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom LEFT_Walk_4.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom LEFT_Walk_1.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom LEFT_Walk_2.png");
                            Thread.sleep(20);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom LEFT_Walk_3.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom LEFT_Walk_4.png");
                            Thread.sleep(10);
                            getPic().translate(-getCellSize(), 0);
                            break;
                        }
                    }
                    if (movingDown && getPic().getY() < getField().getRectangle().getHeight()){
                            getPic().translate(0, getCellSize());
                        Thread.sleep(65);

                    }
                    if (movingUp && getPic().getY() > getField().getRectangle().getY()){
                            getPic().translate(0, -getCellSize());
                        Thread.sleep(65);
                    }

                Thread.sleep(10);


            } catch (Exception e) {
                System.out.println("Exception is caught");
            }

        }
    }

    public void robberInit() {

        pic = new Picture(32, 32, "/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Mushroom - Small/SmallMushroom_Walk_1.png");
        pic.draw();


        keyboardInit();

    }


    private void keyboardInit() {

        keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(rightPressed);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(leftPressed);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(upPressed);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(downPressed);

        /** Unclick */

        KeyboardEvent rightRelease = new KeyboardEvent();
        rightRelease.setKey(KeyboardEvent.KEY_RIGHT);
        rightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(rightRelease);

        KeyboardEvent leftRelease = new KeyboardEvent();
        leftRelease.setKey(KeyboardEvent.KEY_LEFT);
        leftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(leftRelease);

        KeyboardEvent upRelease = new KeyboardEvent();
        upRelease.setKey(KeyboardEvent.KEY_UP);
        upRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(upRelease);

        KeyboardEvent downRelease = new KeyboardEvent();
        downRelease.setKey(KeyboardEvent.KEY_DOWN);
        downRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(downRelease);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {
            movingRight = true;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_LEFT) {
            movingLeft = true;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_UP) {
            movingUp = true;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_DOWN) {
            movingDown = true;
        }
    }




    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {
            movingRight = false;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_LEFT) {
            movingLeft = false;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_UP) {
            movingUp = false;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_DOWN) {
            movingDown = false;
        }

    }


}
