package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class QueenTest {
    @Test
    public void queenCanMove() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen (PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(+2, +2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(+2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, +3)));
        assertThat(moves).contains(new Move(coords, coords.plus(+2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, +3)));
    }
    @Test
    public void queenCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords,coords.plus(-3,-3)));
        assertThat(moves).contains(new Move(coords,coords.plus(+3,+3)));
        assertThat(moves).contains(new Move(coords,coords.plus(-3,0)));
        assertThat(moves).contains(new Move(coords,coords.plus(0,+3)));
    }
    @Test
    public void whiteQueenCanCaptureEnemyPiece() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(4, 4);
        board.placePiece(rookCoords, queen);

        Coordinates enemyCoords = rookCoords.plus(-3, -3);
        board.placePiece(enemyCoords, enemyPiece);

        // Act
        List<Move> moves = queen.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, enemyCoords));
    }
    @Test
    public void whiteQueenCannotCaptureOwnPiece() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Piece friendlyPiece = new Pawn(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        Coordinates pawnCoords = queenCoords.plus(+3, +3);
        board.placePiece(pawnCoords, friendlyPiece);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(queenCoords, pawnCoords));

    }
}
