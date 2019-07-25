/**
 * Управлнение устройствами банкомата
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
 * Этот класс можно было бы организовать как внутренний класс класса Bankomat, 
 * но в подобном случае мы не смогли бы использовать его с сторонними реализациями стандартизированного банкомата 
 */
public final class Controller {  // защищаемся от подсовывания банкомату "левого" контроллера через наследование
	
	final 	CashPointInterface 		controledBankomat;
			DataBase 		db = new DataBase();
	 		
			
	public Controller (final CashPointInterface bankomatInstance) { 
		
							controledBankomat = bankomatInstance;
	}
	
// ------------------------------------------------------------------------------------------
	
	// чисто для сокращения длины метода

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
			print ("Данные восстановлены из хранилища\n" + JSONstring + "\n");

		
			
		print("\nРады видеть Вас в службе виртуальных банкоматов!");
				
		
		
		String cardNumber=null;
		cardNumber = ClientAuthorizationLogic.authorizeClient(controledBankomat, db);
		
		if (cardNumber != null ) print("Вы успешно прошли авторизацию по номеру карты " + cardNumber );

		
		
		CashpointUserRecord 		userRecord = new CashpointUserRecord ();
		CashpointUserRecordPublic 	publicCopy = CashpointUserRecord.getPublicClone(userRecord);

//		Jsonb jsonb = JsonbBuilder.create();
		String userRecordJSONRepresentationW = jsonb.toJson(publicCopy);
		
		controledBankomat.dataStorageSlotFlush( userRecordJSONRepresentationW );
		

	}
	
}	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
