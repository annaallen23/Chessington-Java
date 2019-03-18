package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> moves = new ArrayList<Move>();
        //moves regardless of colour piece
        if (colour.equals(PlayerColour.WHITE) || (colour.equals(PlayerColour.BLACK))) {
            //sets boundaries col/row that move can be initiated in without piece falling off the board and prevents moving into space occupied by own colour.
            if (from.getCol() <= 6 && from.getRow() >= 1) {
                if (board.get(from.plus(-1, +1)) == null || !board.get(from.plus(-1, +1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(-1, +1)));
                }
            }
            if (from.getCol() >= 1 && from.getRow() >= 1) {
                if (board.get(from.plus(-1, -1)) == null || !board.get(from.plus(-1, -1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(-1, -1)));
                }
            }
            if (from.getCol() <= 6 && from.getRow() <= 6) {
                if (board.get(from.plus(+1, +1)) == null || !board.get(from.plus(+1, +1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(+1, +1)));
                }
            }
            if (from.getCol() >= 1 && from.getRow() <= 6) {
                if (board.get(from.plus(+1, -1)) == null || !board.get(from.plus(+1, -1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(+1, -1)));
                }
            }
            if (from.getRow() >= 1) {
                if (board.get(from.plus(-1, 0)) == null || !board.get(from.plus(-1, 0)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(-1, 0)));
                }
            }
            if (from.getRow() <= 6) {
                if (board.get(from.plus(+1, 0)) == null || !board.get(from.plus(+1, 0)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(+1, 0)));
                }
            }
            if (from.getCol() <= 6) {
                if (board.get(from.plus(0, +1)) == null || !board.get(from.plus(0, +1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(0, +1)));
                }
            }
            if (from.getCol() >= 1) {
                if (board.get(from.plus(0, -1)) == null || !board.get(from.plus(0, -1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(0, -1)));
                }
            }
        }
        return moves;

    }
}

