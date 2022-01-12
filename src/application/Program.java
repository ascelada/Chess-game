package application;

import application.chess.ChessMatch;
import application.chess.ChessPosition;

import java.io.InputStream;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        UI.printBoard(chessMatch.getPieces());
        System.out.print("Source position: ");
        ChessPosition source = new ChessPosition(sc.next().charAt(0),sc.nextInt());
        System.out.println();
        System.out.print("Target position: ");
        ChessPosition target = new ChessPosition(sc.next().charAt(0),sc.nextInt());




        chessMatch.makeChessMove(source, target);

        UI.printBoard(chessMatch.getPieces());
        System.out.println();

        chessMatch.makeChessMove(target, source);
        UI.printBoard(chessMatch.getPieces());





        sc.close();







    }
}
