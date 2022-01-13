package application.chess.pieces;

import application.boardgame.Board;
import application.boardgame.Position;
import application.chess.ChessPiece;
import application.chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //up++ right +

        p.setValues(position.getRow()+2,position.getColumn()+1);
        if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;

        }

        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //up+ right ++

        p.setValues(position.getRow()+1,position.getColumn()+2);
        if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;

        }

        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //up++ left-

        p.setValues(position.getRow()+2,position.getColumn()-1);
        if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;

        }

        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //up+ left--

        p.setValues(position.getRow()+1,position.getColumn()-2);
        if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;

        }

        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //down- left--

        p.setValues(position.getRow()-1,position.getColumn()-2);
        if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;

        }

        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //down-- left-

        p.setValues(position.getRow()-2,position.getColumn()-1);
        if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;

        }

        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //down-- right+

        p.setValues(position.getRow()-2,position.getColumn()+1);
        if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;

        }

        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //down- right++

        p.setValues(position.getRow()-1,position.getColumn()+2);
        if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

            mat[p.getRow()][p.getColumn()]= true;

        }

        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;


    }

    @Override
    public String toString(){
        return "H";
    }
}

