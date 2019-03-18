package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static boolean allowedToMove(Board board, Coordinates from, PlayerColour colour, int rowChange, int colChange) {
        for (int j = 1; j <= Math.max(Math.abs(rowChange), Math.abs(colChange)); j++) {

            int row;
            if (rowChange > 0) row = +j;
            if (rowChange < 0) row = -j;
            else row = 0;

            int col;
            if (colChange > 0) col = +j;
            if (colChange < 0) col = -j;
            else col = 0;

            if (board.get(from.plus(row, col)) != null && board.get(from.plus(row, col)).getColour() == colour) {
                return false;
            } else if (board.get(from.plus(row, col)) != null && board.get(from.plus(row, col)).getColour() != colour) {
                if (j != Math.max(Math.abs(rowChange), Math.abs(colChange))) {
                    return false;
                }
            }
        }

        return true;
    }

}