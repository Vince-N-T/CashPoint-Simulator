package bankomat;
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
		sc.close();
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
		 		finally {
			 		sc.close();
		 		}

		 				return inputNumberToken;
                      
		}
   // ----------------------------------------------------------------------------------

}


