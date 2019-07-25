/**
 * ����������� ������������ ���������
 */

package cashpointcontroller;
import java.io.IOException;
import java.util.regex.*;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import bankomat.*;

        //import bankomat.CardReader;
        //import bankomat.CashPoint;

/**
 * @author Vince-NT
 *
 * ���� ����� ����� ���� �� ������������ ��� ���������� ����� ������ Bankomat, 
 * �� � �������� ������ �� �� ������ �� ������������ ��� � ���������� ������������ �������������������� ��������� 
 */
public final class Controller {  // ���������� �� ������������ ��������� "������" ����������� ����� ������������
	
	final 	CashPointInterface 		controledBankomat;
			DataBase 		db = new DataBase();
	 		
			
	public Controller (final CashPointInterface bankomatInstance) { 
		
							controledBankomat = bankomatInstance;
	}
	
// ------------------------------------------------------------------------------------------
	
	// ����� ��� ���������� ����� ������

	void print (String str) {  		
		
			controledBankomat.displaySignalSlot(str);
	}
	
// ------------------------------------------------------------------------------------------
	
//	public static void clearScreen() throws IOException, InterruptedException {  
//			        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//		}

// ------------------------------------------------------------------------------------------


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void start () {
		
		
		String userRecordJSONRepresentationR = null;
		Jsonb jsonb = JsonbBuilder.create();
		String JSONstring = controledBankomat.dataStorageSlotRecover( userRecordJSONRepresentationR );
			print ("������ ������������� �� ���������\n" + JSONstring + "\n");

		
			
		print("\n���� ������ ��� � ������ ����������� ����������!");
				
		
		
		String cardNumber=null;
		cardNumber = ClientAuthorizationLogic.authorizeClient(controledBankomat, db);
		
		if (cardNumber != null ) print("�� ������� ������ ����������� �� ������ ����� " + cardNumber );

		
		
		CashpointUserRecord 		userRecord = new CashpointUserRecord ();
		CashpointUserRecordPublic 	publicCopy = CashpointUserRecord.getPublicClone(userRecord);

//		Jsonb jsonb = JsonbBuilder.create();
		String userRecordJSONRepresentationW = jsonb.toJson(publicCopy);
		
		controledBankomat.dataStorageSlotFlush( userRecordJSONRepresentationW );
		

	}
	
}	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
