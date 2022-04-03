package EREN_ÇETİNER_200315070_HW2;
import java.util.Scanner;

/**
 *
 * @author EREN ÇETİNER 200315070 1stEd HW2Q2
 */

/*
*
*   Question 2 – Password
*
*       Write a Java method to check whether a string is a valid password.
*
*           Password rules:
*
*               A password must have at least eight characters.
*               A password consists of only letters and digits.
*               A password must contain at least two digits and at least two letters.

*/

public class EREN_ÇETİNER_200315070_1stEd_HW2Q2 {

    public static void main(String[] args) {
  
        String password;
  
            Scanner input = new Scanner(System.in);
  
                boolean ŞifreGeçişKontrol;
    
                    do {
    
                        System.out.println("Set a password : ");
                            password = input.nextLine();

      
                            char[] MyArryy = password.toUpperCase().toCharArray();
      
                                ŞifreGeçişKontrol = RakamHarfOlmuşMu(MyArryy) && CharlarKaçTane(MyArryy) >= 8 
                                        && HarflerKaçTane(MyArryy) >= 2 && RakamlarKaçTane(MyArryy) >= 2;
      
                                    if (ŞifreGeçişKontrol == false)
    
                                        System.out.println("Invalid Password !"
                                            + "The Password must contain 8 characters from alphabet and numbers !  " + "Try again !");
                    } 
                                        
                                        while (!ŞifreGeçişKontrol);
  
                                            System.out.println("This is valid password.");
                                                            input.close();

    }

    public static int CharlarKaçTane(char[] arr) {
  
                                                                return arr.length;
    
    }

    public static int HarflerKaçTane(char[] arr) {
  
        int count = 0;
    
            for (char p : arr) {
        
                if (p >= 65 && p <= 90)
                        count++;
            }
                                                                    return count;
    }

    public static int RakamlarKaçTane(char[] arr) {
  
        int count = 0;
  
            for (char p : arr) {
      
                if (p >= 48 && p <= 57)
                        count++;
            }
                                                                    return count;
    }

    public static boolean RakamHarfOlmuşMu(char[] arr) {
  
        boolean cont = false;
  
            for (char p : arr) {
      
                if ((p >= 48 && p <= 57) || (p >= 65 && p <= 90))
                        cont = true;
        
                    else
                                                                    return false;
            }
                                                                    return cont;
    }
}