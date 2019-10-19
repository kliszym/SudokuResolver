package ui.Panels;

import boards.ClassicBoard;

import java.awt.*;

public class MatrixPanel extends BasePanel {
    protected ClassicBoard cb;
    public MatrixPanel(Dimension d) {
        super(d, 9);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawMatrix(g2d);
        g2d.setColor(YELLOW_LIGHT);
        if(clicked != null)
            g2d.fillRect(clicked.x, clicked.y, clicked.width, clicked.height);
        g2d.setColor(GREEN_LIGHT);
        if(covered != null)
            g2d.fillRect(covered.x, covered.y, covered.width, covered.height);
    }

}
