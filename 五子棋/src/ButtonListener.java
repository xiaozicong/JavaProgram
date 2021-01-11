import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener, WuZhiQiConfig {

    public WuZhiQiFrame frame;
    private FrameListener frameListener;

    public ButtonListener(WuZhiQiFrame frame) {
        this.frame = frame;
        frameListener = new FrameListener();
        frame.addMouseListener(frameListener);
    }

    /**
     * 通过判断鼠标点击的内容是否是“开始新游戏”为页面添加MouseListener
     * 再次点击“开始新游戏”后重绘页面重新添加MouseListener
     * 用ArrList<ChessPosion>储存
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("开始新游戏")) {
            frameListener.setGraphics(frame);

            for (int i = 0; i < frame.isValue.length; i++) {
                for (int j = 0; j < frame.isValue[i].length; j++) {
                    frame.isValue[i][j] = 0;
                }
            }
            frame.ChessPosionList.clear();
            frame.repaint();
        } else if (e.getActionCommand().equals("悔棋")) {
            if (frame.ChessPosionList.size() >= 1) {
                ChessPosion l = new ChessPosion();
                l = frame.ChessPosionList.remove(frame.ChessPosionList.size() - 1);
                frame.isValue[l.Listi][l.Listj] = 0;
                if (frame.turn == 1) {
                    frame.turn++;
                } else {
                    frame.turn--;
                }
                frame.repaint();
            } else {
                frame.PopUp("提示", "不能悔棋");
            }
        } else if (e.getActionCommand().equals("认输")) {
            if (frame.turn == 1) {
                frame.PopUp("游戏结果", "白方赢");
            } else {
                frame.PopUp("游戏结果", "黑方赢");
            }
        }
    }
}
