package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;

    private List<Piece> piecesOnTheBoard;
    private List<Piece> capPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8,8);
        turn = 1;
        currentPlayer = Color.WHITE;
        piecesOnTheBoard = new ArrayList<>();

        initialSetup();
    }
    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }
    public boolean getCheck(){
        return check;
    }
    public boolean getCheckMate(){
        return checkMate;
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows() ; i++) {
            for (int j = 0; j < board.getColumns() ; j++) {
                mat[i][j] = (ChessPiece) board.piece(i,j);

            }

        }
        return mat;

    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column,row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    public ChessPiece makeChessMove (ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();


        Piece capPiece = makeMove(source,target);
        if (testCheck(currentPlayer)){
            undoMove(source,target,capPiece);
            throw new ChessException("You cant put yourself in check!!");


        }

        check = (testCheck(opponent(currentPlayer)))? true:false;

        if(testCheckMate(opponent(currentPlayer))){
            checkMate = true;
        }
        else{
        nextTurn();
        }

        return (ChessPiece) capPiece;

    }

    private Piece makeMove(Position source, Position target){
        ChessPiece p = (ChessPiece) board.removePiece(source);
        p.increaseMoveCount();
        Piece capPiece = board.removePiece(target);
        board.placePiece(p,target);
        if (capPiece!=null){
            piecesOnTheBoard.remove(capPiece);
            capPieces.add(capPiece);
        }
        return capPiece;

    }

    private void undoMove(Position source,Position target, Piece capPiece){
        Piece p = board.removePiece(target);
        board.placePiece(p,source);

        if (capPiece != null){
            board.placePiece(capPiece,target);
        }

    }
    private Color opponent(Color color){

        return (color == Color.WHITE)? Color.BLACK:Color.WHITE;
    }
    private ChessPiece king(Color color){
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
        for(Piece p: list){
            if(p instanceof King){
                return (ChessPiece) p;
            }
        }
        throw new IllegalStateException("There is no "+ color+" king on the board");
    }
    private boolean testCheck(Color color){
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());

        for( Piece p:opponentPieces){
            boolean[][] mat = p.possibleMoves();
            if(mat[kingPosition.getRow()][kingPosition.getColumn()]){
                return true;
            }

        }
        return false;
    }
    private boolean testCheckMate(Color color){
        if(!testCheck(color)){
            return false;
        }
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());

        for (Piece p : list){
            boolean[][] mat = p.possibleMoves();
            for (int i = 0; i < board.getRows() ; i++) {
                for (int j = 0; j < board.getColumns() ; j++) {
                    if(mat[i][j]){
                        Position source = ((ChessPiece)p).getChessPosition().toPosition();
                        Position target = new Position(i,j);

                        Piece capturedPiece = makeMove(source,target);

                        boolean testCheck = testCheck(color);

                        undoMove(source,target,capturedPiece);
                        if(!testCheck){
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position  =sourcePosition.toPosition();
        return board.piece(position).possibleMoves();

    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK: Color.WHITE;
    }



    private void initialSetup(){
        //PAWN
        for (int i =0; i<8; i++ ) {
            board.placePiece(new Pawn(board, Color.WHITE), new Position(1, i));
            board.placePiece(new Pawn(board, Color.BLACK), new Position(6, i));
        }
        //ROOK
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,0 ));
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,7 ));
        board.placePiece(new Rook(board, Color.BLACK), new Position(7, 0));
        board.placePiece(new Rook(board, Color.BLACK), new Position(7, 7));


        //KNIGHT
        board.placePiece(new Knight(board, Color.WHITE), new Position(0,1 ));
        board.placePiece(new Knight(board, Color.WHITE), new Position(0,6 ));
        board.placePiece(new Knight(board, Color.BLACK), new Position(7, 1));
        board.placePiece(new Knight(board, Color.BLACK), new Position(7, 6));

        //BISHOP

        board.placePiece(new Bishop(board, Color.WHITE), new Position(0,2 ));
        board.placePiece(new Bishop(board, Color.WHITE), new Position(0,5 ));
        board.placePiece(new Bishop(board, Color.BLACK), new Position(7, 2));
        board.placePiece(new Bishop(board, Color.BLACK), new Position(7, 5));

        //QUEEN
        board.placePiece(new Queen(board, Color.WHITE), new Position(0,3 ));
        board.placePiece(new Queen(board, Color.BLACK), new Position(7, 3));

        //KING
        board.placePiece(new King(board, Color.WHITE), new Position(0,4 ));
        board.placePiece(new King(board, Color.BLACK), new Position(7, 4));





    }
}
