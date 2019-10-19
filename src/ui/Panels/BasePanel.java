package ui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasePanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
    public Dimension resolution;
    protected MatrixRectangle matrix_size;
    protected MatrixRectangle covered = null;
    protected MatrixRectangle clicked = null;
    protected int slices_count = 1;
    protected int slice;
    protected Color YELLOW_LIGHT = new Color(255,255,0,100);
    protected Color GREEN_LIGHT = new Color(0,255,0,100);

    public BasePanel(Dimension resolution, int slices) {
        this.slices_count = slices;
        fixSize(resolution);
    }

    public void fixSize(Dimension resolution) {
        this.resolution = resolution;
        matrix_size = new MatrixRectangle(
                (int)(resolution.width * 0.01), (int)(resolution.width * 0.01),
                (int)(resolution.height * 0.8), (int)(resolution.height * 0.8));
        slice = (int)((double)matrix_size.width/(double)slices_count);
        matrix_size.width = slice * slices_count;
        matrix_size.height = slice * slices_count;
        setPreferredSize(new Dimension(matrix_size.width, matrix_size.height));
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        if((x <= matrix_size.x - 1 || x >= matrix_size.getXEnds() + 1) ||
           (y <= matrix_size.y - 1 || y >= matrix_size.getYEnds() + 1))
            return;
        clicked = findBox(x, y);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        if((x <= matrix_size.x - 1 || x >= matrix_size.getXEnds() + 1) ||
           (y <= matrix_size.y - 1 || y >= matrix_size.getYEnds() + 1)) {
            covered = null;
            repaint();
            return;
        }
        covered = findBox(x, y);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {}

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                covered = null;
                if(clicked != null)
                    if(clicked.x < matrix_size.getXEnds() - slice)
                        clicked.x += clicked.width + 1;
                repaint();
                break;
            case KeyEvent.VK_LEFT:
                covered = null;
                if(clicked != null)
                    if(clicked.x > matrix_size.x + 1)
                        clicked.x -= clicked.width + 1;
                repaint();
                break;
            case KeyEvent.VK_UP:
                covered = null;
                if(clicked != null)
                    if(clicked.y > matrix_size.y + 1)
                        clicked.y -= clicked.height + 1;
                repaint();
                break;
            case KeyEvent.VK_DOWN:
                covered = null;
                if(clicked != null)
                    if(clicked.y < matrix_size.getYEnds() - slice)
                        clicked.y += clicked.height + 1;
                repaint();
                break;
            default:
        }
        if('0' <= keyEvent.getKeyChar() && keyEvent.getKeyChar() <= '9') {
            System.out.println(keyEvent.getKeyChar());
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

    @Override
    public void mousePressed(MouseEvent mouseEvent) {}

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {}

    protected void drawMatrix(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(matrix_size.x, matrix_size.y, matrix_size.width, matrix_size.height);
        g2d.setColor(Color.BLACK);
        for(int i = 0; i <= slices_count; i += 1) {
            g2d.drawLine(matrix_size.x + i * slice, matrix_size.y, matrix_size.x + i * slice, matrix_size.getYEnds());
            g2d.drawLine(matrix_size.x, matrix_size.y + i * slice, matrix_size.getXEnds(), matrix_size.y + i * slice);
        }
    }

    private MatrixRectangle findBox(int x, int y) {
        x = x - matrix_size.x;
        x = (int)((double)x/(double)matrix_size.width * slices_count);
        x = x * (int)((double)matrix_size.width/slices_count);
        x = x + matrix_size.x;
        y = y - matrix_size.y;
        y = (int)((double)y/matrix_size.height * slices_count);
        y = y * (int)((double)matrix_size.height/slices_count);
        y = y + matrix_size.y;
        return new MatrixRectangle(x + 1, y + 1, matrix_size.width/slices_count - 1, matrix_size.height/slices_count - 1);
    }
}
