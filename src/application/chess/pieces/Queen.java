package application.chess.pieces;

import application.boardgame.Board;
import application.boardgame.Position;
import application.chess.ChessPiece;
import application.chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
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

        //ABOVE
        p.setValues(position.getRow()-1,position.getColumn());

        while( getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
            p.setRow(p.getRow()-1);

        }
        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;

        }

        //BELLOW
        p.setValues(position.getRow()+1,position.getColumn());

        while( getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
            p.setRow(p.getRow()+1);

        }
        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;

        }

        //RIGHT

        p.setValues(position.getRow(),position.getColumn()+1);

        while( getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
            p.setColumn(p.getColumn()+1);

        }
        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;

        }

        //LEFT

        p.setValues(position.getRow(),position.getColumn()-1);

        while( getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
            p.setColumn(p.getColumn()-1);

        }
        if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;

        }

        return mat;

    }

    @Override
    public String toString(){
        return "Q";
    }
}

