package application.chess.pieces;

import application.boardgame.Board;
import application.chess.ChessPiece;
import application.chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[0][];
    }

    @Override
    public String toString(){
        return "P";
    }
}

