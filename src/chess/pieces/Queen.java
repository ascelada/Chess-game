package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //UP-RIGHT

        p.setValues(position.getRow() + 1, position.getColumn() + 1);

        while (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);


        }


        //UP-LEFT

        p.setValues(position.getRow() - 1, position.getColumn() + 1);

        while (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);


        }


        //DOWN- LEFT

        p.setValues(position.getRow() - 1, position.getColumn() - 1);

        while (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);


        }

        //DOWN- RIGHT

        p.setValues(position.getRow() - 1, position.getColumn() + 1);

        while (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);


        }


        //ABOVE
        p.setValues(position.getRow() - 1, position.getColumn());

        while (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);

        }


        //BELLOW
        p.setValues(position.getRow() + 1, position.getColumn());

        while (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);

        }


        //RIGHT

        p.setValues(position.getRow(), position.getColumn() + 1);

        while (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);

        }


        //LEFT

        p.setValues(position.getRow(), position.getColumn() - 1);

        while (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);

        }


        return mat;

    }

    @Override
    public String toString() {
        return "Q";
    }
}

