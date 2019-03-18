package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<Move>();
        //loops through moves if row is greater than i calls in method allowedToMove and adds move to List Move
            for (int i = 1; i <= 7; i++) {
                if (from.getRow() >= i) {
                    Move move = new Move(from, from.plus(-i, 0));
                    if (Utilities.allowedToMove(board, from,colour, -i, 0)){
                        moves.add(move);
                    }
                }
                if (from.getRow() <= 7 - i){
                    Move move = new Move(from, from.plus(+i, 0));
                    if (Utilities.allowedToMove(board, from, colour, +i, 0)){
                        moves.add(move);
                    }

                }
                if (from.getCol() >= i){
                    Move move = new Move(from,from.plus(0,-i));
                    if (Utilities.allowedToMove(board, from, colour, 0,-i)){
                        moves.add(move);
                    }
                }
                if (from.getCol() <= 7 - i){
                    Move move =new Move(from,from.plus(0, +i));
                    if (Utilities.allowedToMove(board, from, colour,0,+i)){
                        moves.add(move);
                    }
                }
            }
        return moves;
    }
}




