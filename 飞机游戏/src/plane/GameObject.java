package plane;

import Util.GameUtil;

import java.awt.*;

public class GameObject {
    Image img;
    double x, y;
    int speed = 10;

    int width, height;

    public Rectangle getRect() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject() {
    }
}
