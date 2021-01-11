package plane;

import Util.GameUtil;
import Util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author 86151
 */
public class PlaneGameFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");

    Plane p = new Plane("images/plane.png", 50, 50);

    ArrayList bulletList = new ArrayList();

    Date startTime;
    Date endTime;

    Explode explode;

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        p.draw(g);

        for (int i = 0; i < bulletList.size(); i++) {
            Bullet b = (Bullet) bulletList.get(i);
            b.draw(g);

            //检测和飞机的碰撞
            boolean peng = b.getRect().intersects(p.getRect());
            if (peng) {
                p.setLive(false);
                endTime = new Date();

                if(explode==null){
                    explode = new Explode(p.x,p.y);
                }
                explode.draw(g);
                break;
            }
        }

        if(!p.isLive()){
            printInfo(g,"GameOver",50,140,200,Color.white);
            int period = (int) (endTime.getTime()-startTime.getTime())/1000;
            printInfo(g,"时间"+period+"秒",20,120,260,Color.white);
        }

        //PrintfInfo(g,"分数",10,50,50,Color.yellow);
    }

    public void printInfo(Graphics g, String str, int size, int x, int y, Color color){
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体",Font.BOLD,size);
        g.setFont(f);
        g.drawString(str, x, y);
        g.setColor(c);
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }

    @Override
    public void launchFrame() {
        super.launchFrame();
        addKeyListener(new KeyMonitor());
        for (int i = 0; i < 30; i++) {
            Bullet b = new Bullet();
            bulletList.add(b);
        }
        startTime = new Date();
    }

    /**
     * 定义为内部类，可以方便使用外部类的属性
     */
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            p.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            p.minusDirection(e);
        }
    }
}
