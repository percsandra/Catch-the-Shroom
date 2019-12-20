package org.academiadecodigo.splicegirls.CatchTheShroom.Players;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.CatchTheShroom.Field;

public class PlayerCop extends Player implements KeyboardHandler, Runnable {

    private Keyboard keyboard;
    private boolean movingRight = false;
    private boolean movingLeft = false;
    private boolean movingUp = false;
    private boolean movingDown = false;

    public PlayerCop(Field field) {
        super(field);
        copInit();
    }

    @Override
    public void run() {
        {
            try {

                    if (movingRight && getPic().getX() < getField().getRectangle().getWidth()) {
                        while (movingRight) {
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle + Walk_1.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle + Walk_2.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle + Walk_3.png");
                            Thread.sleep(20);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle + Walk_4.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle + Walk_1.png");
                            Thread.sleep(10);
                            getPic().translate(getCellSize(), 0);
                            break;
                        }
                    }
                    if (movingLeft && getPic().getX() > getField().getRectangle().getX()) {
                        while (movingLeft) {
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle LEFT + Walk_1.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle LEFT + Walk_2.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle LEFT + Walk_3.png");
                            Thread.sleep(20);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle LEFT + Walk_4.png");
                            Thread.sleep(10);
                            getPic().load("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle LEFT + Walk_1.png");
                            Thread.sleep(10);
                            getPic().translate(-getCellSize(), 0);
                            break;
                        }
                    }
                    if (movingDown && getPic().getY() < getField().getRectangle().getHeight()) {
                        getPic().translate(0, getCellSize());
                        Thread.sleep(65);
                    }
                    if (movingUp && getPic().getY() > getField().getRectangle().getY()) {
                        getPic().translate(0, -getCellSize());
                        Thread.sleep(65);
                    }

                Thread.sleep(10);


            } catch (Exception e) {
                System.out.println("Exception is caught");
            }

        }
    }

    public void copInit() {

        pic = new Picture(32, 32, "/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Wizard/Wizard_Idle + Walk_1.png");
        pic.draw();

        keyboardInit();
    }

    private void keyboardInit() {

        keyboard = new Keyboard(this);


        KeyboardEvent dPressed = new KeyboardEvent();
        dPressed.setKey(KeyboardEvent.KEY_D);
        dPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(dPressed);

        KeyboardEvent aPressed = new KeyboardEvent();
        aPressed.setKey(KeyboardEvent.KEY_A);
        aPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(aPressed);

        KeyboardEvent wPressed = new KeyboardEvent();
        wPressed.setKey(KeyboardEvent.KEY_W);
        wPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(wPressed);

        KeyboardEvent sPressed = new KeyboardEvent();
        sPressed.setKey(KeyboardEvent.KEY_S);
        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(sPressed);



        KeyboardEvent dRelease = new KeyboardEvent();
        dRelease.setKey(KeyboardEvent.KEY_D);
        dRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(dRelease);

        KeyboardEvent aRelease = new KeyboardEvent();
        aRelease.setKey(KeyboardEvent.KEY_A);
        aRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(aRelease);

        KeyboardEvent wRelease = new KeyboardEvent();
        wRelease.setKey(KeyboardEvent.KEY_W);
        wRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(wRelease);

        KeyboardEvent sRelease = new KeyboardEvent();
        sRelease.setKey(KeyboardEvent.KEY_S);
        sRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(sRelease);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == keyboardEvent.KEY_D) {
            movingRight = true;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_A) {
            movingLeft = true;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_W) {
            movingUp = true;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_S) {
            movingDown = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == keyboardEvent.KEY_D) {
            movingRight = false;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_A) {
            movingLeft = false;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_W) {
            movingUp = false;
        }
        if (keyboardEvent.getKey() == keyboardEvent.KEY_S) {
            movingDown = false;
        }
    }
}
