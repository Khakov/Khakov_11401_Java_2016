package Task005.Game;

import java.io.Serializable;

/**
 * Created by Рустам on 19.11.2015.
 */
public class Checker implements Serializable {
    int color;
    int image;
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        if (color == 0) {
            this.image = 0;
        }
    }

    public boolean isQueen() {
        return this.image>2;
    }

    public void setQueen() {
        if (this.image < 3)
            this.image += 2;
    }

    public Checker(int color) {
        this.color = color;
        if(color== 1)
            this.image = 1;
        else if (color== 2)
            this.image = 2;
        else
            this.image = 0;
    }
}