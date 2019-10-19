package sudoku;

import java.awt.EventQueue;

import boards.ClassicBoard;
import ui.MainFrame;

public class Main {

    public static void main(String[] args) {
        ClassicBoard cb = new ClassicBoard();
        cb.print();
        System.out.println(cb.checkBoardCorrectness());
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
