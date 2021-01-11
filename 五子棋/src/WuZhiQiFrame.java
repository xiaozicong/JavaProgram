import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;


/**
 * @author 肖子聪 杨淼
 */
public class WuZhiQiFrame extends JPanel implements WuZhiQiConfig{

    /**
     * 继承JPanel类的面板组件放入JFrame中
     * 通过isValue数组来储存棋盘上的对应位置；
     * ArrayList集合来储存棋子完成悔棋的操作；
     * turn=1时下黑子，turn=2时下白子；
     */
    public Graphics g;
    public int[][] isValue = new int[15][15];
    public  ArrayList<ChessPosion> ChessPosionList = new ArrayList<ChessPosion>();
    public int turn = 1;

    public void initFrame() {

        /**
         * 完成JFrame的基本设置
         * setLocationRelativeTo(null)窗口对应组件的位置在屏幕中央（默认）；
         */
        JFrame jf = new JFrame();
        jf.setTitle("五子棋");
        jf.setSize(1265, 785);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(new BorderLayout());

        /**
         * 用Dimension类来定义构件的高度
         */
        Dimension right = new Dimension(200, 0);
        Dimension center = new Dimension(550, 0);
        Dimension rightbutton = new Dimension(170, 40);

        //setPreferredSize()可以根据页面的大小自动变化,this指代对象
        this.setPreferredSize(center);
        jf.add(this, BorderLayout.CENTER);

        JPanel jp = new JPanel();
        jp.setPreferredSize(right);
        jp.setBackground(Color.LIGHT_GRAY);
        jf.add(jp, BorderLayout.EAST);

        jp.setLayout(new FlowLayout());

        //getScaledInstance()设置所获取图片的大小，width用横向放大图片的方式覆盖掉JButton的边框;
        String[] buttonname = {"开始新游戏", "悔棋", "认输"};
        JButton[] buttons = new JButton[3];
        ImageIcon[] imageIcons = {STARTBUTTON,BACKBUTTON,LOSEBUTTON};
        for (int i = 0; i < buttonname.length; i++) {
            imageIcons[i].setImage(imageIcons[i].getImage().getScaledInstance(rightbutton.width+20, rightbutton.height,Image.SCALE_DEFAULT ));
            buttons[i] = new JButton(buttonname[i],imageIcons[i]);
            buttons[i].setPreferredSize(rightbutton);
            jp.add(buttons[i]);
        }

        /**
         *String[] boxname = {"人人对战", "人机对战"};
         * Image.SCALE_DEFAULT使用图像默认的缩放方法；
         */
        ImageIcon[] icon = {BATTLE1};
        JComboBox jComboBox = new JComboBox(icon);
        jComboBox.setPreferredSize(rightbutton);
        icon[0].setImage(icon[0].getImage().getScaledInstance(rightbutton.width,rightbutton.height,Image.SCALE_DEFAULT));
        jp.add(jComboBox);

        //用循环的方式将按钮添加上监听;
        ButtonListener buttonListener = new ButtonListener(this);
        for (int i = 0; i < buttonname.length; i++) {
            buttons[i].addActionListener(buttonListener);
        }
        jf.setVisible(true);
    }

    /**
     * 重写JPanel的paint()方法实现画面的重绘；
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        /**
         * X,Y为画线的起始坐标
         * y+size用来控制每一行的间隔；
         * for循环来控制生成多少行；
         */
        g.drawImage(CheckerBoard2,0,0,this.getWidth(),this.getHeight(),this);
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < row; i++) {
            g.drawLine(X, Y + size * i, X + size * (colum - 1), Y + size * i);
        }

        for (int i = 0; i < colum; i++) {
            g.drawLine(X + size * i, Y, X + size * i, Y + size * (row - 1));
        }

        /**
         * countx/y用于获取棋子在棋盘上的坐标
         * countx/y的计算方法将数组中的棋子坐标对应到棋盘生成棋子
         * 棋盘每个格子的大小为50*50
         * 在悔棋时实现每一步棋子的重绘
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (isValue[i][j] == 1) {
                    int countx = size * i + size/2;
                    int county = size * j + size/2;
                    g.drawImage(blackchess,countx-size+X,county-size/2,size,size,null);
                } else if (isValue[i][j] == 2) {
                    int countx = size * i + size/2;
                    int county = size * j + size/2;
                    g.drawImage(whitechess,countx-size+X,county-size/2,size,size,null);
                }
            }
        }
    }

    /**
     *
     * @param top 窗口名称
     * @param result 内容
     */
    public void PopUp(String top,String result) {
        JOptionPane jo=new JOptionPane();
        JOptionPane.showMessageDialog(null, result, top, JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        WuZhiQiFrame frame = new WuZhiQiFrame();
        frame.initFrame();
    }
}
