package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //UP-RIGHT

        p.setValues(position.getRow()+1,position.getColumn()+1);

        while (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;
            p.setValues(position.getRow()+1,position.getColumn()+1);


        }
        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }

        //UP-LEFT

        p.setValues(position.getRow()-1,position.getColumn()+1);

        while (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;
            p.setValues(position.getRow()-1,position.getColumn()+1);


        }
        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }

        //DOWN- LEFT

        p.setValues(position.getRow()-1,position.getColumn()-1);

        while (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;
            p.setValues(position.getRow()-1,position.getColumn()-1);


        }
        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        //DOWN- RIGHT

        p.setValues(position.getRow()-1,position.getColumn()+1);

        while (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;
            p.setValues(position.getRow()-1,position.getColumn()+1);


        }
        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }

        return mat;

    }

    @Override
    public String toString(){
        return "B";
    }
}
