package application.chess.pieces;

import application.boardgame.Board;
import application.boardgame.Position;
import application.chess.ChessPiece;
import application.chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        if (getColor() == Color.WHITE){

            p.setValues(position.getRow()-1,position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

                mat[p.getRow()][p.getColumn()]=true;


            }
            p.setValues(position.getRow()-1,position.getColumn()-1);
            if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()]=true;

            }
            p.setValues(position.getRow()-1,position.getColumn()+1);
            if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()]=true;

            }
            p.setValues(position.getRow()-2,position.getColumn());

            if (getMoveCount() ==0 && getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){
                mat[p.getRow()][p.getColumn()]=true;

            }

        }
        if (getColor() == Color.BLACK){

            p.setValues(position.getRow()+1,position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

                mat[p.getRow()][p.getColumn()]=true;


            }
            p.setValues(position.getRow()+1,position.getColumn()-1);
            if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()]=true;

            }
            p.setValues(position.getRow()+1,position.getColumn()+1);
            if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()]=true;

            }
            p.setValues(position.getRow()+2,position.getColumn());

            if (getMoveCount() ==0 && getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){
                mat[p.getRow()][p.getColumn()]=true;

            }

        }

        return mat;

    }

    @Override
    public String toString(){
        return "P";
    }
}

