package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {
    @Test
    public void whiteKnightCanMoveUpTwoSquaresAndAcrossOneSquare() {
        //Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 1);
        board.placePiece(coords, knight);

        //Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));

    }

    @Test
    public void blackKnightCanMoveUpTwoSquaresAndAcrossOneSquare() {
        //Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 1);
        board.placePiece(coords, knight);

        //Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(+2, +1)));
    }

    @Test
    public void knightCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 1);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).containsOnly(
                new Move(coords, coords.plus(+2, +1)),
                new Move(coords, coords.plus(+1, +2)),
                new Move(coords, coords.plus(+2, -1)));
    }

    @Test
    public void whiteKnightCanCaptureEnemyPiece() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates knightCoords = new Coordinates(4, 4);
        board.placePiece(knightCoords, knight);

        Coordinates enemyCoords = knightCoords.plus(-2, +1);
        board.placePiece(enemyCoords, enemyPiece);

        // Act
        List<Move> moves = knight.getAllowedMoves(knightCoords, board);

        // Assert
        assertThat(moves).contains(new Move(knightCoords, enemyCoords));
    }

    @Test
    public void whiteKnightCannotCaptureOwnPiece() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Piece friendlyPiece = new Rook(PlayerColour.WHITE);
        Coordinates knightCoords = new Coordinates(4, 4);
        board.placePiece(knightCoords, knight);

        Coordinates rookCoords = knightCoords.plus(-2, +1);
        board.placePiece(rookCoords, friendlyPiece);

        // Act
        List<Move> moves = knight.getAllowedMoves(knightCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(knightCoords, rookCoords));

    }
}

