package application.chess.pieces;

import application.boardgame.Board;
import application.boardgame.Position;
import application.chess.ChessPiece;
import application.chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        for (int i = -1; i <=1 ; i++) {
            for (int j = -1; j <=1 ; j++) {


                if(i==0 && j==0){
                    continue;
                }

                p.setValues(position.getRow()+i,position.getColumn()+j);
                if (getBoard().positionExists(p) && !getBoard().isThereAPiece(p)){

                    mat[p.getRow()][p.getColumn()]= true;

                }

                if (getBoard().positionExists(p) && isThereAOpponentPiece(p)){
                    mat[p.getRow()][p.getColumn()]= true;
                }

            }
        }


        return mat;

    }





    @Override
    public String toString(){
        return "K";
    }
}

