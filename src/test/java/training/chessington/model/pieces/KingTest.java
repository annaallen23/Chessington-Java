package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {
    @Test
    public void whiteKingCanMoveUpOneSquaresAndAcrossOneSquare() {
        //Arrange
        Board board = Board.empty();
        Piece king = new King (PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        //Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));

    }

    @Test
    public void blackKingCanMoveUpOneSquaresAndAcrossOneSquare() {
        //Arrange
        Board board = Board.empty();
        Piece king = new King (PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        //Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(+1, +1)));
    }

    @Test
    public void kingCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King (PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(
                new Move(coords, coords.plus(+1, +1)),
                new Move(coords, coords.plus(-1, +1)),
                new Move(coords, coords.plus(+1, -1)));
    }

    @Test
    public void whiteKingCanCaptureEnemyPiece() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King (PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates kingCoords = new Coordinates(4, 4);
        board.placePiece(kingCoords, king);

        Coordinates enemyCoords = kingCoords.plus(-1, +1);
        board.placePiece(enemyCoords, enemyPiece);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).contains(new Move(kingCoords, enemyCoords));
    }

    @Test
    public void whiteKingCannotCaptureOwnPiece() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King (PlayerColour.WHITE);
        Piece friendlyPiece = new Rook(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(4, 4);
        board.placePiece(kingCoords, king);

        Coordinates rookCoords = kingCoords.plus(-1, +1);
        board.placePiece(rookCoords, friendlyPiece);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(kingCoords, rookCoords));

    }
}
