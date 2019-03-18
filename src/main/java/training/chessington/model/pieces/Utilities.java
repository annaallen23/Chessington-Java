package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static boolean allowedToMove(Board board, Coordinates from, PlayerColour colour, int rowChange, int colChange) {
        //Math.max()chooses the bigger number from rowChange or colChange
        //Math.abs() turns -ve & +ve
        for (int j = 1; j <= Math.max(Math.abs(rowChange), Math.abs(colChange)); j++) {
            //need else if on second line otherwise always returns j as 0.
            int row;
            if (rowChange > 0) row = +j;
            else if (rowChange < 0) row = -j;
            else row = 0;

            int col;
            if (colChange > 0) col = +j;
            else if (colChange < 0) col = -j;
            else col = 0;
            // space is not empty and same colour don't add move
            if (board.get(from.plus(row, col)) != null && board.get(from.plus(row, col)).getColour() == colour) {
                return false;
            // space is not empty and not same colour add move as long as J is not equal to the max number of row or col
            } else if (board.get(from.plus(row, col)) != null && board.get(from.plus(row, col)).getColour() != colour) {
                if (j != Math.max(Math.abs(rowChange), Math.abs(colChange))) {
                    return false;
                }
            }
        }

        return true;

    }
}