package org.academiadecodigo.splicegirls.CatchTheShroom;

import org.academiadecodigo.splicegirls.CatchTheShroom.GameObjects.Door;
import org.academiadecodigo.splicegirls.CatchTheShroom.GameObjects.GameObject;
import org.academiadecodigo.splicegirls.CatchTheShroom.MusicPlayer.MusicPlayer;
import org.academiadecodigo.splicegirls.CatchTheShroom.Other.Random;
import org.academiadecodigo.splicegirls.CatchTheShroom.Players.PlayerCop;
import org.academiadecodigo.splicegirls.CatchTheShroom.Players.PlayerRobber;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game{

    private Field field;
    private GameObject wall;
    private PlayerCop cop;
    private PlayerRobber robber;
    private Door door1;
    private Door door2;
    private Screen startingScreen = new Screen("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Screens/StartScreen_v2.jpg");
    private Screen storyScreen = new Screen("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Screens/StoryScreen.jpg");
    private Screen robVictoryScreen = new Screen("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Screens/Mushroom_Victory_v1.jpg");
    private Screen copVictoryScreen = new Screen("/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Screens/Wizard_Victory_v1.jpg");
    private boolean robberVictory;
    public final int doorDistance = 6; // Must be half or less than Field size


    public Game() {

        startingScreen.show();
    }


    public void gameInit(){
        field = new Field();

        cop = new PlayerCop(field);
        robber = new PlayerRobber(field);

        wall = new GameObject(field);
        door1 = new Door();
        door2 = new Door();


        randomPosDoor(door1.getDoorPic());
        randomPosDoor(door2.getDoorPic(), door1.getDoorPic());
        randomPosition(cop.getPic(), door1.getDoorPic());
        randomPosAvoidCop(robber.getPic(), cop.getPic());
    }

    public void musicInit(){

        String filePath = "resources/media.io_y2mate.com - the_halloween_ska_royalty_free_music_F85amIDSS3M (1).wav";
        MusicPlayer gameMusic = new MusicPlayer();
        gameMusic.playMusic(filePath);


    }

    private void gameHide(){
        field.getRectangle().delete();
        field.getPic().delete();
        wall.getPic().delete();
        door1.getDoorPic().delete();
        door2.getDoorPic().delete();
        cop.getPic().delete();
        robber.getPic().delete();
    }

    private void resetScreens(){
        startingScreen.setIsClosed(false);
        storyScreen.setIsClosed(false);
        robVictoryScreen.setIsClosed(false);
        copVictoryScreen.setIsClosed(false);
    }



    public void start() {

        startingScreen.show();
        resetScreens();
        while (true){
            try{
            Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
            if (startingScreen.getIsClosed()){
                break;
            }

        }
        storyScreen.show();
        resetScreens();
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (storyScreen.getIsClosed()) {
                break;
            }
        }
        gameInit();
        while (true){

                int robX = robber.getPic().getX();
                int robY = robber.getPic().getY();
                int copX = cop.getPic().getX();
                int copY = cop.getPic().getY();

                if (copX > robX -2*field.getCellSize() && copX < robX +2*field.getCellSize()
                        && copY > robY -2*field.getCellSize() && copY < robY +2*field.getCellSize()){
                    System.out.printf("COP VICTORY!\n");
                    robberVictory = false;
                    gameHide();
                    break;
                }
                if (doorDetector(robX, robY, door1) || doorDetector(robX, robY, door2)){
                    break;
                }


                cop.run();
                try {
                    Thread.sleep(30); } catch (InterruptedException e) { e.printStackTrace(); }
                robber.run();
            }
        if (robberVictory){
            robVictoryScreen.show();
            resetScreens();
        }else {
            copVictoryScreen.show();
            resetScreens();
        }
        while (true){
            try{
                Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            if (robVictoryScreen.getIsClosed() || copVictoryScreen.getIsClosed()){
                break;
            }
        }
        start();
    }

    private boolean doorDetector(int robX, int robY, Door door) {
        if (robX == door.getDoorPic().getX() && robY == door.getDoorPic().getY()) {
            System.out.println("ROBBER VICTORY!");
            robberVictory = true;
            gameHide();
            return true;
        }
        return false;
    }


    public void randomPosition(Picture playerPic){


        int randomX = Random.getRandInt(field.getCol() - 1) * field.getCellSize();
        int randomY = Random.getRandInt(field.getRow() - 1) * field.getCellSize();

        playerPic.translate(randomX,randomY);
    }

    public void resetPosition(Picture playerPic){


        int playerPosX = field.getCellSize() - playerPic.getX();
        int playerPosY = field.getCellSize() - playerPic.getY();

        playerPic.translate(playerPosX,playerPosY);
    }

    public void randomPosition(Picture playerPic, Picture pictureToAvoid){

        while (true){

            resetPosition(playerPic);
            randomPosition(playerPic);

            if (playerPic.getX() == pictureToAvoid.getX()
            && playerPic.getY() == pictureToAvoid.getY()
            || toCloseChecker(playerPic, door1.getDoorPic(), doorDistance)
                    || toCloseChecker(playerPic, door2.getDoorPic(), doorDistance)){
                System.out.println("cop loop");
                continue;
            }
            break;
        }
    }

    public void randomPosAvoidCop(Picture robberPic, Picture copPic){

        while (true){

            resetPosition(robberPic);
            randomPosition(robberPic);


            if (toCloseChecker(robberPic, copPic, 2)
                    || toCloseChecker(robberPic, door1.getDoorPic(), doorDistance)
                    || toCloseChecker(robberPic, door2.getDoorPic(), doorDistance)){
                System.out.println("robber loop");
                continue;
            }
            break;
        }
    }


    public boolean toCloseChecker(Picture p, Picture a, int cellsAway){

        cellsAway = cellsAway * field.getCellSize();

        if (p.getX() <= (a.getX() + cellsAway) && p.getX() >= (a.getX() - cellsAway)
        && p.getY() <= (a.getY() + cellsAway) && p.getY() >= (a.getY() - cellsAway)){
            return true;
        }
        return false;
    }




    public void randomPosDoor(Picture doorPic){


        int randomX = Random.getRandInt(field.getCol() - 2) * field.getCellSize();
        int randomY = Random.getRandInt(field.getRow() - 2) * field.getCellSize();
        int fieldXLimit = field.getRectangle().getWidth() - field.getCellSize();
        int fieldYLimit = field.getRectangle().getHeight() - field.getCellSize();

        switch (Random.getRandInt(1)){

            case 0:
                doorPic.translate(randomX,0);
                break;

            case 1:
                doorPic.translate(randomX, fieldYLimit);
                break;

            case 2:
                doorPic.translate(0, randomY);
                break;

            case 3:
                doorPic.translate(fieldXLimit, randomY);
                break;
            default:
                System.out.println("Something went terribly right! I mean Wrong!!");
        }
    }

    public void randomPosDoor(Picture doorPic, Picture doorPicAvoid){

        while (true){

            resetPosition(doorPic);
            randomPosDoor(doorPic);

            if (doorPic.getX() == doorPicAvoid.getX()
                    && doorPic.getY() == doorPicAvoid.getY()){
                continue;
            }
            break;
        }

    }

}


