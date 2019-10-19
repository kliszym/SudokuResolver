package ui;

import ui.Panels.MatrixPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Sudoku");
        Dimension d = new Dimension(800, 600);
        setSize(d);
        MatrixPanel panel = new MatrixPanel(d);
        addMouseListener(panel);
        addMouseMotionListener(panel);
        addKeyListener(panel);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
