import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrameListener implements WuZhiQiConfig, MouseListener {

    public WuZhiQiFrame frame;

    public int turn = 1;

    public void setGraphics(WuZhiQiFrame frame) {
        this.frame = frame;
    }

    /**
     *Graphics g = frame.getGraphics();为组件创建一个图形上下文(相当于获取一个画笔进行使用)
     *countx=(x/size)*size+X
     *g.drawImage()画图时需要的坐标是图片的左上角坐标；
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int countx = (x / size) * size + X;
        int county = (y / size) * size + Y;
        Graphics g = frame.getGraphics();
        int ArrayX = (countx - X) / size;
        int ArrayY = (county - Y) / size;

        if (frame.isValue[ArrayX][ArrayY] != 0) {

            frame.PopUp("错误提示", "此处已有棋子，请下在别处");
        } else {

            if (frame.turn == 1) {
                g.drawImage(blackchess, countx - size / 2, county - size / 2, size, size, null);
                frame.isValue[ArrayX][ArrayY] = 1;
                frame.ChessPosionList.add(new ChessPosion(ArrayX, ArrayY));

                /**
                 * 判断这一行是否有五个黑棋
                 */
                int imin = ArrayX - 4, imax = ArrayX + 4;
                if (imin < 0) {
                    imin = 0;
                }
                if (imax > 14) {
                    imax = 14;
                }

                int counter1 = 0;
                for (int i = imin; i <= imax; i++) {
                    if (frame.isValue[i][ArrayY] == 1) {
                        counter1++;
                    } else {
                        counter1 = 0;
                    }
                    if (counter1 == 5) {
                        frame.PopUp("游戏结果", "黑方胜利");
                    }

                    /**
                     * 判断这一列是否有五个黑棋
                     */
                    int jmin = ArrayY - 4, jmax = ArrayY + 4;
                    if (jmin < 0) {
                        jmin = 0;
                    }
                    if (jmax > 14) {
                        jmax = 14;
                    }
                    int count2 = 0;
                    for (int j = jmin; j <= jmax; j++) {
                        if (frame.isValue[ArrayX][j] == 1) {
                            count2++;
                        } else {
                            count2 = 0;
                        }
                        if (count2 == 5) {
                            frame.PopUp("游戏结果", "黑方胜利");
                            return;
                        }
                    }

                    /**
                     * 左上至右下判断
                     */
                    int count3 = 0;
                    for (int k = -4; k < 4; k++) {
                        if ((ArrayX + k >= 0) && (ArrayY + k >= 0) && (ArrayX + k <= 14) && (ArrayY + k <= 14)) {
                            if (frame.isValue[ArrayX + k][ArrayY + k] == 1) {
                                count3++;
                            } else {
                                count3 = 0;
                            }
                            if (count3 == 5) {
                                frame.PopUp("游戏结果", "黑方胜利");
                                return;
                            }
                        }
                    }

                    /**
                     * 右上至左下判断
                     */
                    int count4 = 0;
                    for (int s = -4;s <= 4; s++) {
                        if ((ArrayX + s >= 0) && (ArrayY - s >= 0) && (ArrayX + s <= 14) && (ArrayY - s <= 14)) {
                            if (frame.isValue[ArrayX + s][ArrayY - s] == 1) {
                                count4++;
                            } else {
                                count4 = 0;
                            }
                            if (count4 == 5) {
                                frame.PopUp("游戏结果", "黑方胜利");
                                return;
                            }
                        }
                    }

                }
                frame.turn++;
            } else {
                g.drawImage(whitechess, countx - size / 2, county - size / 2, size, size, null);
                frame.isValue[ArrayX][ArrayY] = 2;
                frame.ChessPosionList.add(new ChessPosion(ArrayX, ArrayY));

                /**
                 * 判断这一行是否有五个黑棋
                 */
                int imin = ArrayX - 4, imax = ArrayX + 4;
                if (imin < 0) {
                    imin = 0;
                }
                if (imax > 14) {
                    imax = 14;
                }

                int counter1 = 0;
                for (int i = imin; i <= imax; i++) {
                    if (frame.isValue[i][ArrayY] == 2) {
                        counter1++;
                    } else {
                        counter1 = 0;
                    }
                    if (counter1 == 5) {
                        frame.PopUp("游戏结果", "白方胜利");
                    }

                    /**
                     * 判断这一列是否有五个黑棋
                     */
                    int jmin = ArrayY - 4, jmax = ArrayY + 4;
                    if (jmin < 0) {
                        jmin = 0;
                    }
                    if (jmax > 14) {
                        jmax = 14;
                    }
                    int count2 = 0;
                    for (int j = jmin; j <= jmax; j++) {
                        if (frame.isValue[ArrayX][j] == 2) {
                            count2++;
                        } else {
                            count2 = 0;
                        }
                        if (count2 == 5) {
                            frame.PopUp("游戏结果", "白方胜利");
                            return;
                        }
                    }

                    /**
                     * 左上至右下判断
                     */
                    int count3 = 0;
                    for (int k = -4; k < 4; k++) {
                        if ((ArrayX + k >= 0) && (ArrayY + k >= 0) && (ArrayX + k <= 14) && (ArrayY + k <= 14)) {
                            if (frame.isValue[ArrayX + k][ArrayY + k] == 2) {
                                count3++;
                            } else {
                                count3 = 0;
                            }
                            if (count3 == 5) {
                                frame.PopUp("游戏结果", "白方胜利");
                                return;
                            }
                        }
                    }

                    /**
                     * 右上至左下判断
                     */
                    int count4 = 0;
                    for (int s = -4; s <= 4; s++) {
                        if ((ArrayX + s >= 0) && (ArrayY - s >= 0) && (ArrayX + s <= 14) && (ArrayY - s <= 14)) {
                            if (frame.isValue[ArrayX + s][ArrayY - s] == 2) {
                                count4++;
                            } else {
                                count4 = 0;
                            }
                            if (count4 == 5) {
                                frame.PopUp("游戏结果", "白方胜利");
                                return;
                            }
                        }
                    }
                }
                frame.turn--;
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
