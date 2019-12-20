package org.academiadecodigo.splicegirls.CatchTheShroom.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Door {

    private Picture doorPic;


    public Door(){

        doorPic = new Picture(32, 32,"/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/Door/Door.png");
        doorPic.draw();

        doorPic.translate(0,0);
    }

    public Picture getDoorPic() {
        return doorPic;
    }
}
