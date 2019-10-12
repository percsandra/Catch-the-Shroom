package org.academiadecodigo.splicegirls.CopRobber;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.awt.*;

public class Game implements KeyboardHandler {

    private Picture robberPic;
    private int cellSize = 20;
    private Rectangle field;

    public void init(){

        fieldInit();
        robberInit();
        keyboardInit();
    }

    public void robberInit(){

        robberPic = new Picture(20, 20, "beta_Robber.png");
        robberPic.draw();

        int randomX = Random.getRandInt(field.getX(), field.getWidth());
        int randomY = Random.getRandInt(field.getY(), field.getHeight());

        robberPic.translate(randomX,randomY);

    }

    public void fieldInit(){

         field = new Rectangle(cellSize, cellSize, cellSize * 20, cellSize * 25);
         field.setColor(Color.BLUE);
         field.draw();

        System.out.println(field.getX() + " " + field.getY() + " " + field.getWidth() + " " + field.getHeight());
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

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(upPressed);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(downPressed);
    }







    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {
            if (robberPic.getX() == field.getWidth()){
                return;
            }
            robberPic.translate(getCellSize(), 0);
        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_LEFT) {
            if (robberPic.getX() == field.getX()){
                return;
            }
            robberPic.translate(-getCellSize(), 0);
        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_UP) {
            if (robberPic.getY() == field.getY()){
                return;
            }
            robberPic.translate(0, -getCellSize());
        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_DOWN) {
            if (robberPic.getY() == field.getHeight()){
                return;
            }
            robberPic.translate(0, getCellSize());
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public int getCellSize() {
        return cellSize;
    }
}
