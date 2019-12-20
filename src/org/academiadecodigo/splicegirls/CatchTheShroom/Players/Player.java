package org.academiadecodigo.splicegirls.CatchTheShroom.Players;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.CatchTheShroom.Field;

public abstract class Player {

    protected Picture pic;
    private int cellSize = 32;
    private Field field;

    public Player(Field field){
        this.field = field;
    }

    public int getCellSize() {
        return cellSize;
    }

    public Field getField() {
        return field;
    }

    public Picture getPic() {
        return pic;
    }

    public void hide(){
        pic.delete();
    }

}
