package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<Move>();

        if (colour.equals(PlayerColour.WHITE)||(colour.equals(PlayerColour.BLACK))){
            if (from.getCol() <= 6 && from.getRow() >= 2) {
                if (board.get(from.plus(-2, +1)) == null || !board.get(from.plus(-2, +1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(-2, +1)));
                }
            }
            if (from.getCol() >= 1 && from.getRow() >= 2) {
                if (board.get(from.plus(-2, -1)) == null || !board.get(from.plus(-2, -1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(-2, -1)));
                }
            }
            if (from.getCol() <= 6 && from.getRow() <= 5) {
                if (board.get(from.plus(+2, +1)) == null || !board.get(from.plus(+2, +1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(+2, +1)));
                }
            }
            if (from.getCol() >= 1 && from.getRow() <= 5) {
                if (board.get(from.plus(+2, -1)) == null || !board.get(from.plus(+2, -1)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(+2, -1)));
                }
            }
            if (from.getCol() <= 5 && from.getRow() >= 1) {
                if (board.get(from.plus(-1, +2)) == null || !board.get(from.plus(-1, +2)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(-1, +2)));
                }
            }
            if (from.getCol() >= 2 && from.getRow() >= 1) {
                if (board.get(from.plus(-1, -2)) == null || !board.get(from.plus(-1, -2)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(-1, -2)));
                }
            }
            if (from.getCol() <= 5 && from.getRow() <= 6) {
                if (board.get(from.plus(+1, +2)) == null || !board.get(from.plus(+1, +2)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(+1, +2)));
                }
            }
            if (from.getCol() >= 2 && from.getRow() <= 6) {
                if (board.get(from.plus(+1, -2)) == null || !board.get(from.plus(+1, -2)).getColour().equals(colour)) {
                    moves.add(new Move(from, from.plus(+1, -2)));
                }
            }
        }
        return new ArrayList<>(moves);
    }
}
