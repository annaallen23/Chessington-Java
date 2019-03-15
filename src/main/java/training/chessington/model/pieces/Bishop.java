package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<Move>();

        for (int i = 1; i <= 7; i++) {
            if (from.getRow() >= i && from.getCol() <= 7-i) {
                Move move = new Move(from, from.plus(-i, +i));
                boolean allowedToMove = true;

                for (int j = 1; j <= i; j++) {
                    if (board.get(from.plus(-j, +j)) == null) {
                        continue;
                    } else if (board.get(from.plus(-j, +j)).getColour() == colour) {
                        allowedToMove = false;
                        break;
                    } else if (board.get(from.plus(-j, +j)).getColour() != colour) {
                        if (j == i) {
                            continue;
                        } else {
                            allowedToMove = false;
                            break;
                        }
                    }
                }
                if (allowedToMove){
                    moves.add(move);
                }
            }
            if (from.getRow() <= 7 - i && from.getCol() >= i){
                Move move = new Move(from, from.plus(+i, -i));
                boolean allowedToMove = true;

                for(int j =1; j <= i; j++){
                    if (board.get(from.plus(+j,-j)) == null) {
                        continue;
                    } else if (board.get(from.plus(+j,-j)).getColour() == colour) {
                        allowedToMove = false;
                        break;
                    } else if (board.get(from.plus(+j,-j)).getColour() != colour) {
                        if (j == i) {
                            continue;
                        } else {
                            allowedToMove = false;
                            break;
                        }
                    }
                }
                if (allowedToMove){
                    moves.add(move);
                }

            }
            if (from.getCol() >= i && from.getRow() >= i ){
                Move move = new Move(from,from.plus(-i,-i));
                boolean allowedTomove = true;

                for(int j=1; j <= i; j++) {
                    if (board.get(from.plus(-j,-j)) == null) {
                        continue;
                    } else if (board.get(from.plus(-j, -j)).getColour() == colour) {
                        allowedTomove = false;
                        break;
                    } else if (board.get(from.plus(-j, -j)).getColour() != colour) {
                        if (j == i) {
                            continue;
                        } else{
                            allowedTomove = false;
                            break;
                        }
                    }
                }
                if (allowedTomove){
                    moves.add(move);
                }
            }
            if (from.getCol() <= 7 - i && from.getRow() <= 7 - i ){
                Move move =new Move(from,from.plus(+i, +i));
                boolean allowedToMove = true;

                for(int j=1; j <= i; j++) {
                    if (board.get(from.plus(+j, +j)) == null) {
                        continue;
                    } else if (board.get(from.plus(+j, +j)).getColour() == colour) {
                        allowedToMove = false;
                        break;
                    }else if (board.get(from.plus(+j, +j)).getColour() != colour) {
                        if (j == i) {
                            continue;
                        } else{
                            allowedToMove = false;
                            break;
                        }
                    }
                }
                if (allowedToMove){
                    moves.add(move);
                }
            }
        }

        return moves;
    }
}
