package plane;

import Util.Constant;

import java.awt.*;

public class Bullet extends GameObject{

    double degree;

    public Bullet() {
        degree = Math.random() * Math.PI * 2;
        x = Constant.GAME_WIDTH / 2;
        y = Constant.GAME_HEIGHT / 2;
        width = 10;
        height = 10;
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.green);
        g.fillOval((int) x, (int) y, width, height);

        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        if (y > Constant.GAME_HEIGHT - height || y < Constant.Board) {
            degree = -degree;
        }

        if (x < 0 || x > Constant.GAME_HEIGHT - width) {
            degree = Math.PI - degree;
        }

        g.setColor(c);
    }
}
