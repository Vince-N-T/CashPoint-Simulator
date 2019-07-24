/**
 * 
 */
package cashpointcontroller;

import bankomat.CardreaderException;
import bankomat.CashPoint;

/**
 * @author Vince-NT
 *
 */
class ClientAuthorizationLogic {
	
	
	static 	String authorizeClient (final CashPoint controledBankomat, final DataBase db) {
		
		
			String cardNumber = null;
		
			try {
					cardNumber = controledBankomat.CardReaderSlot();   // запрашиваем номер карты
					
			} catch (CardreaderException e) {
				
					controledBankomat.displaySignalSlot("\nВы решили прервать операцию авторизации.\nБудем рады видеть вас снова!");
					return null;
			} //.......................................................................................................
			

			if ( ! db.verifyCardExistence( cardNumber ) ) {				// проверяем, или карта у нас зарегистрирована
				
					controledBankomat.displaySignalSlot("\nСожалеем, но Ваша карта" + cardNumber + "не зарегистрирована в нашей системе!\n");
					return null;
			}
			
		
		//================================================================================================================================
			
		controledBankomat.displaySignalSlot( "\nВаш номер карты\n" + cardNumber + "\n");
		controledBankomat.displaySignalSlot( "Введите 4-х значный номер PIN\n(Будьте внимательны - у вас есть только 3 попытки!)\n");
		
		Integer pin = null;
		int i = 0;
		
        while (i<3) 
        {	
        	i++;
        	
        		// .......................................................
        	
				 try {
				       pin = (Integer) controledBankomat.keyboardSignalSlot(pin); 
				     
				} catch (Exception e) {
					
					if (i<3) {
						controledBankomat.displaySignalSlot("Вы ввели невалидную строку - это не цифра!\nПопробуйте еще раз:");
					    continue;
					   
					 } else { 
						 blockClient (cardNumber, controledBankomat, db);
						 return null;
					 }
					
				} 
				 
				// .......................................................
				 
				 if  ( ((int)pin <= 0) || ((int)pin > 9999) ) {
					 
					 if (i<3) {
							controledBankomat.displaySignalSlot("\nВнимание! PIN должен быть 4-х значным!\nПопробуйте еще раз:\n");
					   continue;
					   
					 } else { 
						 	blockClient (cardNumber, controledBankomat, db);
						 	return null;
					 }
				 }

				 // .......................................................
				 
				 if ( pin != null ) {
					 
					 if ( db.verifyPIN (cardNumber, pin) )
						 	return cardNumber;
					 
					 else {
						 
						 	if (i<3) { //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
								controledBankomat.displaySignalSlot("\nВнимание! Вы ввели неверный PIN!!!\nПопробуйте еще раз:\n");
						 		continue;
						 		} else {
									 blockClient (cardNumber, controledBankomat, db);
						 				return null;
						 		} //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					 		} 
					 
					 }
				     // else throw new Exception();
				 
        } // End of while
	
        
		
		
		return null;
		
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	static void blockClient (String cardNumber, final CashPoint controledBankomat, final DataBase db) {
	
		controledBankomat.displaySignalSlot("\nВнимание!\nВ связи с неправильным введением PIN-a более 3-х раз ваша карта заблокирована на сутки!\n:");
		db.blockUser();
	
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}



