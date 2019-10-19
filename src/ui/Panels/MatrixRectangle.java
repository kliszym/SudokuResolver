package ui.Panels;

import java.awt.*;

public class MatrixRectangle extends Rectangle {
    MatrixRectangle(int i1, int i2, int i3, int i4) {
        super(i1, i2, i3, i4);
    }

    public int getXEnds() { return x + width; }
    public int getYEnds() { return y + height; }
}
