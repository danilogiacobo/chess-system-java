package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        //Position pos = new Position(3, 5);
        //System.out.println(pos);
        //Board board = new Board(8, 8);
        ChessMatch chessMatch = new ChessMatch();
        
        while(true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch(ChessException ce) {
                System.out.println(ce.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException ime) {
                System.out.println(ime.getMessage());
                sc.nextLine();
            }
        }               
    }
}
