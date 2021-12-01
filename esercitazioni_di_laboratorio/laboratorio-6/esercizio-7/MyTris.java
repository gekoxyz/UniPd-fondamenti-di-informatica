import java.lang.IllegalArgumentException;

public class MyTris {
    char board[][] = new char[3][3];

    public MyTris() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = '.';
            }
        }
    }

    public char getCharInPosition(int row, int column) {
        if (row <= 2 && row >= 0 && column <= 2 && column <= 2) {
            return board[row][column];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        int occupiedPositions = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] != '.') {
                    occupiedPositions++;
                }
            }
        }
        return occupiedPositions;
    }

    public boolean isWinning(char c) {
        int streak = 0; // if streak = 3 the player won
        // checking win in rows
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == c) {
                    streak++;
                } else {
                    break;
                }
            }
            if (streak == 3) {
                return true;
            } else {
                streak = 0;
            }
        }
        // checking win in columns
        for (int column = 0; column < board.length; column++) {
            for (int row = 0; row < board[column].length; row++) {
                if (board[row][column] == c) {
                    streak++;
                } else {
                    break;
                }
            }
            if (streak == 3) {
                return true;
            } else {
                streak = 0;
            }
        }
        // checking for win in 2 main diagonals (if the middle is not c there can't be
        // a diagonal win)
        if (board[1][1] == c) {
            int streak2 = 0;
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    if (row == column && board[row][column] == c) {
                        streak++;
                    } else if (row + column == 4 && board[row][column] == c) {
                        streak2++;
                    }
                }
            }
            if (streak == 3 || streak2 == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean setCharInPosition(int row, int column, char c) {
        if (row <= 2 && row >= 0 && column <= 2 && column <= 2) {
            if (board[row][column] == '.') {
                board[row][column] = c;
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        String boardString = "";
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                boardString += Character.toString(board[row][column]) + ' ';
            }
            boardString += '\n';
        }
        return boardString;
    }
}
