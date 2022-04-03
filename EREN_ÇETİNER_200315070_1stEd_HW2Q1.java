package EREN_ÇETİNER_200315070_HW2;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author  EREN ÇETİNER 200315070 1stEd HW2Q1 
 */

/**
*   Question 1 - Number-placement Game
*   
*       Write a program that places the numbers from 0 to 24 on a 5x5 table according to the rules given below. 
*       Implement your java program using methods. 
*       Display all possible correct placements of your numbers in your program.

*/

public class EREN_ÇETİNER_200315070_1stEd_HW2Q1 {
 
    public static void main(String[] args) {
                                                    // I made 2D panel
        int[][] board = new int[5][5];
            int İlkNoktaX = (int) (Math.random() * 5);
                int İlkNoktaY = (int) (Math.random() * 5);
	
                    board[İlkNoktaX][İlkNoktaY] = 1;
                    
                        int k = 10;              // Number of Result may be more
	
                            while (k > 0) {
                                TabloyaYazdır(Keşif(board));
                                    k--;
                            }

    }

    public static int[][] yöntem() {
	
        int[][] yerYönler = new int[][] { { 3, 0 }, { 0, 3 }, { -3, 0 }, { 0, -3 }, 
                                                { 2, 2 }, { -2, 2 }, { 2, -2 },{ -2, -2 } };
	
                        ArrayList<int[]> all = new ArrayList<>();
	
                            for (int i = 0; i < yerYönler.length; i++) {
                                 all.add(yerYönler[i]);
                            }
	
                                Collections.shuffle(all);       //This is very useful
	
                                                    return all.toArray(yerYönler);
    }

    public static int[][] YeniTabloBenzeri(int[][] board) {
                                                            // I made 2D panel
        int[][] YeniTablo = new int[5][5];
	
            for (int i = 0; i < YeniTablo.length; i++) {
	    
                for (int j = 0; j < YeniTablo[i].length; j++) {
                    YeniTablo[i][j] = board[i][j];
                }
            }
                                                                return YeniTablo;
    }

    public static int[][] move(int[][] board, int x, int y, int[] direction, int score) {
	
        int[][] YepyeniTablo = YeniTabloBenzeri(board);
            int YeniX = x + direction[0];
                int YeniY = y + direction[1];
	
                    YepyeniTablo[YeniX][YeniY] = score + 1;
	
                                                            return YepyeniTablo;
    }

    public static ArrayList<int[][]> nextMoves(int[][] board, int x, int y) {
                                                                                // I bring out directions
        ArrayList<int[][]> next = new ArrayList<int[][]>();
	
            int[][] YönlerinYeriDurumu = yöntem();
	
                for (int i = 0; i < 8; i++) {
	    
                    if (KontrolYönü(board, EnSonkiXveYninYeriKonumu(board)[0], 
                            EnSonkiXveYninYeriKonumu(board)[1], YönlerinYeriDurumu[i]))                            
                            
                                next.add(move(board, EnSonkiXveYninYeriKonumu(board)[0],
                                        EnSonkiXveYninYeriKonumu(board)[1], YönlerinYeriDurumu[i],
			
                                                SayıSkor(board)));
                }
                                                                    return next;
    }

    public static int[][] Keşif(int[][] board) {
	
        ArrayList<int[][]> next = new ArrayList<>();
	
            next = nextMoves(board, EnSonkiXveYninYeriKonumu(board)[0], EnSonkiXveYninYeriKonumu(board)[1]);
	
                for (int[][] b : next) {
                    
                    if (SayıSkor(b) == 25)
		
                                                                        return b;
                }

                            for (int[][] Sonuçç : next) {
	    
                                int[][] x = Keşif(Sonuçç);
	    
                                    if (SayıSkor(x) == 25)
                                                                        return x;
                            }
                                                                    return board;
    }

    public static boolean KontrolYönü(int[][] board, int x, int y, int[] direction) {
	
        int YepYeniX = x + direction[0];
            int YepYeniY = y + direction[1];
	
                if (YepYeniX < 0 || YepYeniY < 0 || YepYeniX > 4 || YepYeniY > 4)
	    
                                                                    return false;
	
                    if ((YepYeniX >= 0 && YepYeniY >= 0 && YepYeniX <= 4 && YepYeniY <= 4)) {
	    
                        if (board[YepYeniX][YepYeniY] != 0)
		
                                                                    return false;
                    }
                                                
                                                                    return true;
    }

    public static int SayıSkor(int[][] board) {
	
        int max = 0;
	
            for (int i = 0; i < board.length; i++) {
	    
                for (int j = 0; j < board[i].length; j++) {
		
                    if (max <= board[i][j])
                        max = board[i][j];
                }
            }
                                                                    return max;
    }

    public static int[] EnSonkiXveYninYeriKonumu(int[][] board) {
	
        int[] MyArryy = new int[2];
	
            for (int i = 0; i < board.length; i++) {
	    
                for (int j = 0; j < board[0].length; j++) {
		
                    if (SayıSkor(board) == board[i][j]) {
                        MyArryy[0] = i;
                            MyArryy[1] = j;
                    }
                }
            }
                                                                    return MyArryy;
    }

    public static void TabloyaYazdır(int[][] board) {
	
        for (int i = 0; i < board.length; i++) {
	    
            for (int j = 0; j < board.length; j++) {
		String str = "";
		
                    if ((board[i][j] - 1) < 10)
                        str = "0" + (board[i][j] - 1);
		
                        else
                            str = "" + (board[i][j] - 1);
                                                            // I print finally
                                System.out.print(str + " ");
	    }                                                   
                                    System.out.println();
	}                                                   
                                        System.out.println();
    }
}


