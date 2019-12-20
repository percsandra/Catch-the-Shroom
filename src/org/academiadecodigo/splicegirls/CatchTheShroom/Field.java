package org.academiadecodigo.splicegirls.CatchTheShroom;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Rectangle rectangle;
    private Rectangle boarder;
    private Picture pic;
    private int col = 22;
    private int row = 14;
    private int cellSize = 32;

    public Field(){

        boarder = new Rectangle(cellSize, cellSize, cellSize * (col + 1), cellSize * (row + 1));
        boarder.setColor(Color.WHITE);
        boarder.draw();

        rectangle = new Rectangle(cellSize, cellSize, cellSize * col, cellSize * row);
        rectangle.setColor(Color.BLUE);
        rectangle.draw();

        pic = new Picture(cellSize, cellSize, "/Users/codecadet/Downloads/CatchTheShroom/resources/Assets/DungeonMap_v1.jpg");
        pic.draw();

        System.out.println(rectangle.getX() + " " + rectangle.getY() + " " + rectangle.getWidth() + " " + rectangle.getHeight());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Picture getPic() {
        return pic;
    }
}
