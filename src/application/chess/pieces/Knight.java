package application.chess.pieces;

import application.boardgame.Board;
import application.chess.ChessPiece;
import application.chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[0][];
    }

    @Override
    public String toString(){
        return "H";
    }
}

