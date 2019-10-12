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
    private Picture copPic;
    private int cellSize = 20;
    private Rectangle field;
    private Keyboard keyboard;

    private boolean loopingRight = false;

    private int col = 25;
    private int row = 20;


    public void setLoopingRight(boolean loopingRight) {
        this.loopingRight = loopingRight;
    }

    public void init(){

        fieldInit();


        robberInit();
        copInit();

        keyboardInit();

    }

    public void start(){
        init();
        while (true){
            loopRight();
        }


    }

    public void randomPosition(Picture player){

        int randomX = Random.getRandInt(col - 1) * cellSize;
        int randomY = Random.getRandInt(row - 1) * cellSize;

        player.translate(randomX,randomY);

    }

    public void robberInit(){

        robberPic = new Picture(20, 20, "beta_Robber.png");
        robberPic.draw();

       randomPosition(robberPic);

    }

    public void copInit(){

        copPic = new Picture(20, 20, "beta_Robber 2.png");
        copPic.draw();

        while (true){
            randomPosition(copPic);
            if (copPic.getX() == robberPic.getX()
            && copPic.getY() == robberPic.getY()){
                continue;
            }
            break;
        }


    }

    public void fieldInit(){

         field = new Rectangle(cellSize, cellSize, cellSize * col, cellSize * row);
         field.setColor(Color.BLUE);
         field.draw();

        System.out.println(field.getX() + " " + field.getY() + " " + field.getWidth() + " " + field.getHeight());
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


        /** UNPRESS STARTS HERE */


        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(rightReleased);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(leftReleased);

        KeyboardEvent upReleased = new KeyboardEvent();
        upReleased.setKey(KeyboardEvent.KEY_UP);
        upReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(upReleased);

        KeyboardEvent downReleased = new KeyboardEvent();
        downReleased.setKey(KeyboardEvent.KEY_DOWN);
        downReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(downReleased);




        KeyboardEvent dReleased = new KeyboardEvent();
        dReleased.setKey(KeyboardEvent.KEY_D);
        dReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(dReleased);

        KeyboardEvent aReleased = new KeyboardEvent();
        aReleased.setKey(KeyboardEvent.KEY_A);
        aReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(aReleased);

        KeyboardEvent wReleased = new KeyboardEvent();
        wReleased.setKey(KeyboardEvent.KEY_W);
        wReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(wReleased);

        KeyboardEvent sReleased = new KeyboardEvent();
        sReleased.setKey(KeyboardEvent.KEY_S);
        sReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(sReleased);


    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        /** Robber Movement*/

        if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {
            if (robberPic.getX() == field.getWidth()){
                return;
            }
            setLoopingRight(true);
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

        /** Cop Movement*/

        if (keyboardEvent.getKey() == keyboardEvent.KEY_D) {
            if (copPic.getX() == field.getWidth()){
                return;
            }
            copPic.translate(getCellSize(), 0);
        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_A) {
            if (copPic.getX() == field.getX()){
                return;
            }
            copPic.translate(-getCellSize(), 0);
        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_W) {
            if (copPic.getY() == field.getY()){
                return;
            }
            copPic.translate(0, -getCellSize());
        }
        if(keyboardEvent.getKey() == keyboardEvent.KEY_S) {
            if (copPic.getY() == field.getHeight()){
                return;
            }
            copPic.translate(0, getCellSize());
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {
            if (robberPic.getX() == field.getWidth()){
                return;
            }
            setLoopingRight(false);
        }
    }

    public void loopRight(){
        while (loopingRight){
            robberPic.translate(getCellSize(), 0);
        }
    }

    public int getCellSize() {
        return cellSize;
    }
}
