package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<Move>();
        if (colour.equals(PlayerColour.WHITE)) {
            if (from.getRow() == 6) {
                moves.add(new Move(from, from.plus(-2, 0)));
            }
            if (board.get(from.plus(-1, 0)) == null) {
                moves.add(new Move(from, from.plus(-1, 0)));
            }

        } else if (colour.equals(PlayerColour.BLACK)) {
            if (from.getRow() == 1) {
                moves.add(new Move(from, from.plus(+2, 0)));
            }
            if (board.get(from.plus(+1, 0)) == null) {
                moves.add(new Move(from, from.plus(+1, 0)));
            }
        }
            return new ArrayList<>(moves);
        }
    }





