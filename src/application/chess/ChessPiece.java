package application.chess;

import application.boardgame.Board;
import application.boardgame.Piece;
import application.boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){

        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean anyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j < mat.length ; j++) {
                if(mat[i][j]) return true;
                }
            }
        return false;
    }

    protected boolean isThereAOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);

        return p!=null && p.getColor() != color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    protected void increaseMoveCount(){
        moveCount++;

    }
    protected void decreaseMoveCount(){
        moveCount--;

    }


}


