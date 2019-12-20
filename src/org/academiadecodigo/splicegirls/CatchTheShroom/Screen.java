package org.academiadecodigo.splicegirls.CatchTheShroom;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen implements KeyboardHandler {
    private Picture picture;
    private Keyboard keyboard;
    private boolean isClosed = false;

    public Screen(String link){ ;

        picture = new Picture(32, 32, link);
        keyboardInit();
    }

    private void keyboardInit() {

        keyboard = new Keyboard(this);


        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(spacePressed);

        KeyboardEvent qPressed = new KeyboardEvent();
        qPressed.setKey(KeyboardEvent.KEY_Q);
        qPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(qPressed);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            hide();
            isClosed = true;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
            System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void show(){
        picture.draw();
    }

    public void hide(){
        picture.delete();
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed){
        this.isClosed = isClosed;
    }
}
