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
					cardNumber = controledBankomat.CardReaderSlot();   // ����������� ����� �����
					
			} catch (CardreaderException e) {
				
					controledBankomat.displaySignalSlot("\n�� ������ �������� �������� �����������.\n����� ���� ������ ��� �����!");
					return null;
			} //.......................................................................................................
			

			if ( ! db.verifyCardExistence( cardNumber ) ) {				// ���������, ��� ����� � ��� ����������������
				
					controledBankomat.displaySignalSlot("\n��������, �� ���� �����" + cardNumber + "�� ���������������� � ����� �������!\n");
					return null;
			}
			
		
		//================================================================================================================================
			
		controledBankomat.displaySignalSlot( "\n��� ����� �����\n" + cardNumber + "\n");
		controledBankomat.displaySignalSlot( "������� 4-� ������� ����� PIN\n(������ ����������� - � ��� ���� ������ 3 �������!)\n");
		
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
						controledBankomat.displaySignalSlot("�� ����� ���������� ������ - ��� �� �����!\n���������� ��� ���:");
					    continue;
					   
					 } else { 
						 blockClient (cardNumber, controledBankomat, db);
						 return null;
					 }
					
				} 
				 
				// .......................................................
				 
				 if  ( ((int)pin <= 0) || ((int)pin > 9999) ) {
					 
					 if (i<3) {
							controledBankomat.displaySignalSlot("\n��������! PIN ������ ���� 4-� �������!\n���������� ��� ���:\n");
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
								controledBankomat.displaySignalSlot("\n��������! �� ����� �������� PIN!!!\n���������� ��� ���:\n");
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
	
		controledBankomat.displaySignalSlot("\n��������!\n� ����� � ������������ ��������� PIN-a ����� 3-� ��� ���� ����� ������������� �� �����!\n:");
		db.blockUser();
	
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}



