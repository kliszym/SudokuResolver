package boards;

import boards.utility.Square;

public class ClassicBoard extends Board {

    public boolean checkBoardCorrectness() {
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if(board[i][j] == 0)continue;
                if(!checkXYCorrectness(i, j))return false;
            }
        }
        return true;
    }

    private boolean checkXYCorrectness(int x, int y) {
        int number = board[x][y];
        board[x][y] = 0;
        Square square = new Square(x, y);
        boolean found = (findNumberVertically(y, number) ||
                findNumberHorizontally(x, number) ||
                findNumberInSquare(square, number));
        board[x][y] = number;
        return !found;
    }

    private boolean findNumberHorizontally(int line, int number) {
        for(int i = 0; i < board[0].length; i++) {
            if(board[line][i] == number) return true;
        }
        return false;
    }

    private boolean findNumberVertically(int line, int number) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][line] == number) return true;
        }
        return false;
    }

    private boolean findNumberInSquare(Square square, int number) {
        for(int i = square.min_x; i <= square.max_x; ++i) {
            for(int j = square.min_y; j <= square.max_y; ++j) {
                if(board[i][j] == number) return true;
            }
        }
        return false;
    }

    @Override
    public void generateNumbers() {
        board[0][0] = 1;
        board[1][1] = 2;
        board[2][2] = 3;
        board[3][3] = 4;
        board[4][4] = 5;
        board[5][5] = 6;
        board[6][6] = 7;
        board[7][7] = 8;
        board[8][8] = 9;
        board[8][0] = 9;
    }
}
