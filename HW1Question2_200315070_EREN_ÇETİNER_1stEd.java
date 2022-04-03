package HW1;
import java.util.ArrayList;
/**
 *
 * @author EREN ÇETİNER 200315070 1st ed.
 */
public class HW1Question2_200315070_EREN_ÇETİNER_1stEd {
     

    public static void main(String[] args) {
	
            int PlayerA = 0, PlayerB = 0;
                int RolledCountOfDice = 0;
	
                    boolean TurnTurn = false;

                        ArrayList<Integer> PathOfA = new ArrayList<Integer>();
                        ArrayList<Integer> PathOfB = new ArrayList<Integer>();

                            PathOfA.add(0);
                            PathOfB.add(0);
        
                                TurnTurn = firstTurn();
                                    RolledCountOfDice++;

                                        while (!isGameOver(PlayerA, PlayerB)) {
	    
                                            if (TurnTurn == true) {
                        
                                                PlayerA = move(PlayerA);
                    
                                                    RolledCountOfDice++;
                    
                                                        PathOfA.add(PlayerA);

                                                            do {
		   
                                                                if (isTwoDigits(PlayerA)) {
			
                                                                    if (isPrimeNumber(PlayerA)) {
                                                                        PlayerA = move(PlayerA, -1);
                                                                                    PathOfA.add(PlayerA);
                                                                    }           
                                                                        else if (isDividableTen(PlayerA)) {
                                                                            PlayerA = move(PlayerA, 2);
                                                                                PathOfA.add(PlayerA);
                                                                        }
                                                                }

                                                            } 
                                                                while (isTwoDigits(PlayerA) && PlayerA < 100
                                                                        && ((isPrimeNumber(PlayerA)) || isDividableTen(PlayerA))); 
                                            }
	    
                                                                    if (TurnTurn == false) {
                                                                        PlayerB = move(PlayerB);
                                                                            RolledCountOfDice++;
                                                                                PathOfB.add(PlayerB);
                                                                                
                                                                                do {
		    
                                                                                    if (isTwoDigits(PlayerB)) {
			
                                                                                        if (isPrimeNumber(PlayerB)) {
			    
                                                                                            PlayerB = move(PlayerB, -1);
                                                                                                    PathOfB.add(PlayerB);
                                                                                        } 
                                                                                            else if (isDividableTen(PlayerB)) {
                                                                                                PlayerB = move(PlayerB, 2);
                                                                                                    PathOfB.add(PlayerB);
                                                                                            }
                                                                                    }

                                                                                } 
                                                                                    while (isTwoDigits(PlayerB) && PlayerB < 100
                                                                                        && ((isPrimeNumber(PlayerB)) || isDividableTen(PlayerB)));
                                                                    }

                                                                                            TurnTurn = TurnTurn == true ? false : true;

                                        }
                                                                                                String str = TurnTurn == true ? "PlayerB" : "PlayerA";
                                                                                    
                                                                                                    int SizeOfSteps = TurnTurn == true ? PathOfB.size() - 1 : PathOfA.size();
	
                                                                                                        System.out.println("Winner is " + str);
                                                                                                            System.out.println(RolledCountOfDice + " times "); // How many times was the dice rolled
                                                                                                                System.out.println(PathOfA);// PlayerA's path
                                                                                                                    System.out.println(PathOfB); // PlayerB's path
                                                                                                                        System.out.println(SizeOfSteps + " steps "); // How many steps

    }

    public static boolean isDividableTen(int number) {
	
        return number % 10 == 0;
    }

                    public static boolean isTwoDigits(int number) {
                        
                        return number >= 10 && number < 100;  
                    }

                            public static boolean isPrimeNumber(int number) {
	
                                int TheFactors = 0; 
                                    int Jupiter = 1; 

                                        while (Jupiter <= number) {
                                            
                                            if (number % Jupiter == 0)
		
                                                TheFactors++;
	    
                                                    Jupiter++;
                                        }
                                                                return TheFactors == 2;
                            }

                                public static boolean isGameOver(int player1, int player2) {
	
                                        return player1 >= 100 || player2 >= 100;
                            }


                                    public static boolean firstTurn() {
                                                                        //  if it is true PlayerA , false playerB
                                        if (diceResult() % 2 == 1)
	    
                                            return true;
	
                                                else
	    
                                                        return false;

                                    }

    
                                    public static int diceResult() {
	
                                        int ValueOfDice = (int) (1 + (Math.random() * 6));
	
                                            return ValueOfDice;
                                    }

                                                public static int move(int player) {
	
                                                    player = player + diceResult();
	
                                                                    return player;

                                                }

    
                                                    public static int move(int player, int number) {
	
                                                        player = player + number;
                                                                    return player;
                                                    }

                                                                        //Swaptorn method used
                                                            public static int whoisTurn(int player1, int player2, boolean player1Turn, boolean player2Turn) {
	
                                                                if (player1Turn == true)
                                                                    return player1;
	
                                                                        else
                                                                            return player2;
                                                            }




}