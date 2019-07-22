/**
 *  Клавиатура банкомата
 */

import java.util.Scanner;


/**
 * @author Vince-NT
 *
 */
class Keyboard {
	
	// ----------------------------------------------------------------------------------

	Object  takeUsersAnswer(String inputStringToken) { 
		
		Scanner sc = new Scanner(System.in);
		inputStringToken = sc.nextLine();
		
					return inputStringToken;
		             
		}
	
	// ----------------------------------------------------------------------------------

 	
	Object  takeUsersAnswer(Integer inputNumberToken) { 
		
		 		Scanner  sc = new Scanner(System.in);	 		
		 		
		 		try {
		 		inputNumberToken = sc.nextInt();
		 		} catch (Exception e) {
		 			throw e;
		 		}
		 				return inputNumberToken;
                      
		}
   // ----------------------------------------------------------------------------------

}


