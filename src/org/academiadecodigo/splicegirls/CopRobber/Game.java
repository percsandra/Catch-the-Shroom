package org.academiadecodigo.splicegirls.CopRobber;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.naming.InitialContext;

public class Game implements KeyboardHandler {

    private Picture robberPic;
    private int cellSize = 17;

    public void init(){

        robberPic = new Picture(17, 25, "beta_Robber.png");
        robberPic.draw();
        keyboardInit();
    }

    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(rightPressed);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(leftPressed);
    }






    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {
            robberPic.translate(getCellSize(), 0);
        }
        else if(keyboardEvent.getKey() == keyboardEvent.KEY_LEFT) {
            robberPic.translate(-getCellSize(), 0);
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public int getCellSize() {
        return cellSize;
    }
}
