package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {
    @Test
    public void bishopCanMove() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop (PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(+2, +2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(+2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, +3)));
    }
    @Test
    public void bishopCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords,coords.plus(-3,-3)));
        assertThat(moves).contains(new Move(coords,coords.plus(+3,+3)));
    }
    @Test
    public void whiteBishopCanCaptureEnemyPiece() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(4, 4);
        board.placePiece(rookCoords, bishop);

        Coordinates enemyCoords = rookCoords.plus(-3, -3);
        board.placePiece(enemyCoords, enemyPiece);

        // Act
        List<Move> moves = bishop.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, enemyCoords));
    }
    @Test
    public void whiteBishopCannotCaptureOwnPiece() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Piece friendlyPiece = new Pawn(PlayerColour.WHITE);
        Coordinates bishopCoords = new Coordinates(4, 4);
        board.placePiece(bishopCoords, bishop);

        Coordinates pawnCoords = bishopCoords.plus(+3, +3);
        board.placePiece(pawnCoords, friendlyPiece);

        // Act
        List<Move> moves = bishop.getAllowedMoves(bishopCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(bishopCoords, pawnCoords));

    }
}
