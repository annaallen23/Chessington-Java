package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece {
    public Queen(PlayerColour colour) {
        super(PieceType.QUEEN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<Move>();
        //loops through moves i, adds move to list if within boundary and uses method allowedToMove to capture piece of other colour
        for (int i = 1; i <= 7; i++) {
            if (from.getRow() >= i) {
                Move move = new Move(from, from.plus(-i, 0));
                if (Utilities.allowedToMove(board, from, colour, -i, 0)){
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
                if (Utilities.allowedToMove(board, from, colour, 0, -i)){
                    moves.add(move);
                }
            }
            if (from.getCol() <= 7 - i){
                Move move =new Move(from,from.plus(0, +i));
                if (Utilities.allowedToMove(board, from, colour, 0, +i)){
                    moves.add(move);
                }
            }
        }

        for (int i = 1; i <= 7; i++) {
            if (from.getRow() >= i && from.getCol() <= 7-i) {
                Move move = new Move(from, from.plus(-i, +i));
                if (Utilities.allowedToMove(board,from, colour, -i, +i)){
                    moves.add(move);
                }
            }
            if (from.getRow() <= 7 - i && from.getCol() >= i){
                Move move = new Move(from, from.plus(+i, -i));
                if (Utilities.allowedToMove(board,from,colour, +i,-i)){
                    moves.add(move);
                }

            }
            if (from.getCol() >= i && from.getRow() >= i ){
                Move move = new Move(from,from.plus(-i,-i));
                if (Utilities.allowedToMove(board, from, colour, -i, -i)){
                    moves.add(move);
                }
            }
            if (from.getCol() <= 7 - i && from.getRow() <= 7 - i ){
                Move move =new Move(from,from.plus(+i, +i));
                if (Utilities.allowedToMove(board, from, colour, +i,+i)){
                    moves.add(move);
                }
            }
        }
        return moves;
    }
}
