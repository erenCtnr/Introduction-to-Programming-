package HW1;
import java.util.Scanner;


/**
 *
 * @author EREN ÇETİNER 200315070 1st ed.
 */
public class HW1Question1_200315070_EREN_ÇETİNER_1stEd {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        final int ShiftShift = 3; 
                String message;
                    String newMessage;

                        Scanner input = new Scanner(System.in);

                        char letters[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                                            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', };
                                do {
	    
                                    System.out.println(" Please input your Message (ENGLISH ALPHABET AND SPACE IS ALLOWED) : ");
	    
                                        message = input.nextLine().toUpperCase();
                                } 
                                    while (!inLetters(message, letters));

                                        System.out.println(
                                                " Would you want to encrypt or decrypt the message? if you want, (Enter ' e ' for encryption. Enter ' d ' for decryption "
                                                            + "/default is encryption) ");
                    
                                                newMessage = input.next().toLowerCase().equals("e") ? enDecryptMessage(message, ShiftShift, letters)
                                                            : enDecryptMessage(message, (ShiftShift + 20), letters);

                                                                System.out.println(newMessage);
                                                                                input.close();
    }

    public static String enDecryptMessage(String message, int shiftKey, char[] alphabet) {
	
            int[] NumbersNumbers = numMessage(message, alphabet);
                int[] NumbersThatShifted = new int[NumbersNumbers.length]; 
	
                    for (int i = 0; i < NumbersThatShifted.length; i++) {
	    
                            if (NumbersNumbers[i] != -1)
                                NumbersThatShifted[i] = (NumbersNumbers[i] + shiftKey) % 26; 
	   
                                else
                                    NumbersThatShifted[i] = -1;
                    }
	
                                    String str = new String(translate(NumbersThatShifted, alphabet));
	
                                                                        return str;
    }

    public static char[] translate(int[] shiftedNumbers, char[] letters) {
	
        char[] MyChars = new char[shiftedNumbers.length]; 

	
                for (int i = 0; i < MyChars.length; i++) {
	  
                        if (shiftedNumbers[i] != -1)
                                MyChars[i] = letters[shiftedNumbers[i]];
	    
                                else
                                        MyChars[i] = ' ';
                }

                                                                    return MyChars;

    }

    public static int[] numMessage(String message, char[] letters) {
	
            char[] chars = message.toCharArray();
	
                int NumberTheNumbers[] = new int[chars.length]; 
                    int InnnDice = 0; 
                                                
                        for (char c : chars) {
	    
                            if (c == ' ') {
		
                                NumberTheNumbers[InnnDice] = -1;
                                                InnnDice++;
                            }   
                                    else {
		
                                        for (int i = 0; i < letters.length; i++) {
                                
                                            if (c == letters[i]) {
                                            
                                                NumberTheNumbers[InnnDice] = i;
                                                                InnnDice++;
                                            }

                                        }
                                    }
                        }

                                                                return NumberTheNumbers;
    }

   
    
    public static boolean inLetters(String message, char[] letters) {
	
                char[] Charliessss = message.toCharArray();
	
                    boolean found = true; 
	
                        for (char c : Charliessss) {
                        
                            if (!found)
                                break;
                                
                                for (int i = 0; i < letters.length; i++) {
		
                                    if (c == letters[i] || c == ' ') {
                        
                                        found = true;
                                                break;
                                    } 
                                            else
                                                found = false;
                                }

                        }
                                                                    return found;
    }
    
}
