package boards;

abstract class Board {
    Integer[][] board = null;

    abstract void generateNumbers();

    public Board() {
        this(9, 9);
    }

    public Board(int x, int y) {
        if( x <= 0 || y <= 0 ) {
            x = 9;
            y = 9;
        }
        board = new Integer[x][y];
        clear();
        generateNumbers();
    }

    public int getX() {
        return board[0].length;
    }

    public int getY() {
        return board.length;
    }

    public void clear() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void print() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) System.out.print(' ');
                else System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
