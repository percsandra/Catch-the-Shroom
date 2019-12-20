package org.academiadecodigo.splicegirls.CatchTheShroom.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.CatchTheShroom.Field;

public class GameObject {
    private Picture pic;


    public GameObject(Field field){

        pic = new Picture(10, 10, "/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/DungeonWall_50opc.png");
        pic.draw();
        pic.translate(22, (field.getPic().getHeight() - 18));
    }

    public Picture getPic() {
        return pic;
    }
}
