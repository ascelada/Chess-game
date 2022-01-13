package application;

import application.chess.ChessMatch;
import application.chess.ChessPiece;
import application.chess.ChessPosition;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
            UI.clearScreen();
            UI.printMatch(chessMatch, captured);
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            boolean[][] possibleMoves = chessMatch.possibleMoves(source);
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces(), possibleMoves);
            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.makeChessMove(source, target);

            if (capturedPiece != null) {
                captured.add(capturedPiece);


            }
            UI.clearScreen();
            UI.printMatch(chessMatch, captured);


        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
