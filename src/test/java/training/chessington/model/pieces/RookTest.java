package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {
    @Test
    public void rookCanMove() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 0);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-5, 0)));
    }
    @Test
    public void rookCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 0);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords,coords.plus(-5,0)));
        assertThat(moves).contains(new Move(coords,coords.plus(0,+5)));
    }
    @Test
    public void whiteRookCanCaptureEnemyPiece() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(4, 4);
        board.placePiece(rookCoords, rook);

        Coordinates enemyCoords = rookCoords.plus(-2, 0);
        board.placePiece(enemyCoords, enemyPiece);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, enemyCoords));
    }
    @Test
    public void whiteRookCannotCaptureOwnPiece() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Piece friendlyPiece = new Pawn(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(0, 2);
        board.placePiece(rookCoords, rook);

        Coordinates pawnCoords = rookCoords.plus(0, +3);
        board.placePiece(pawnCoords, friendlyPiece);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(rookCoords, pawnCoords));

    }
}
