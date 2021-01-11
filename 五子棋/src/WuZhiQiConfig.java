import javax.swing.*;
import java.awt.*;
import java.net.URL;

public interface WuZhiQiConfig {

    int X = 25;
    int Y = 25;
    int size = 50;
    int row = 15;
    int colum = 15;

    Image CheckerBoard = new ImageIcon("CheckerBoard.png").getImage();
    Image CheckerBoard2 = new ImageIcon("CheckerBorder2.png").getImage();

    Image blackchess = new ImageIcon("black.png").getImage();
    Image whitechess = new ImageIcon("white.png").getImage();

    ImageIcon BACKBUTTON = new ImageIcon("Backbutton.png");
    ImageIcon LOSEBUTTON = new ImageIcon("LoseButton.png");
    ImageIcon STARTBUTTON = new ImageIcon("StartButton.png");
    ImageIcon BATTLE1 = new ImageIcon("Battle1.png");
    ImageIcon BATTLE2 = new ImageIcon("Battle.png");

}
