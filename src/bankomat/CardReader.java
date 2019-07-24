/**
 * 
 */

package bankomat;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

/**
 * @author Vince-NT
 *
 */



class CardReader {
	
		final CashPoint connectedBankomat;
		final static String cardNumberPattern = "^\\d{4}-\\d{4}-\\d{4}-\\d{4}";
		
		
	 	CardReader (final CashPoint bankomatInstance) { 
	 		
	 			connectedBankomat = bankomatInstance;
		}
	 	
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		static boolean validateCardNumberLength (String cardNumber) {
			
		       return cardNumber.length() == 19  ;
	     }
		
 //...........................................................................................................
		
		static boolean validateCardNumberFormat (String cardNumber) {
				
			/*
			Pattern pattern = Pattern.compile(cardNumberPattern);
			Matcher match   = pattern.matcher(cardNumber);
				       return match.find();  
			*/
			
			return cardNumber.matches(cardNumberPattern);
		
	     }
		
 //...........................................................................................................

		
		static boolean skipDecisionCheck (String userAnswer) {
			
			return userAnswer.matches( "(.*)((quit)|(QUIT))(.*)"  ) ;
		}
		
 //...........................................................................................................
		


	
		String obtainCardInfo () throws CardreaderException {
		
			String 	userInput= null;

			boolean  lengthValidationResult 	= false;
			boolean  formatValidationResult 	= false;
			boolean  skipCheckResult			= false;
			
			connectedBankomat.displaySignalSlot("\nВведите ваш номер карты\nв формате ''ХХХХ-ХХХХ-ХХХХ-ХХХХ''\nДля выхода из данной орерации - введите ''QUITE''\n");
			
			do
			{
				userInput = (String) connectedBankomat.keyboardSignalSlot(userInput); 
			
					lengthValidationResult 	= validateCardNumberLength (userInput);
					formatValidationResult 	= validateCardNumberFormat (userInput);
					skipCheckResult			= skipDecisionCheck (userInput);

					if ( skipCheckResult )
							break;
					
						if (!formatValidationResult)
							connectedBankomat.displaySignalSlot("\nВы ошиблись при введении номера карты! \n- Введенный номер карты не соответствует формату!\n");

						if (!lengthValidationResult)
							connectedBankomat.displaySignalSlot("- Введенный номер карты не соответствует критерию длины!\n");

						if ( ! formatValidationResult || ! lengthValidationResult )
							connectedBankomat.displaySignalSlot("Попробуйте ввести номер карты снова:\n");			
 						
			} 	while ( ! (skipCheckResult ||  lengthValidationResult && formatValidationResult ) ) ;			
				
			
			 
			if ( skipCheckResult )  
					throw   new CardreaderException (skipCheckResult);
			else
					return userInput;
		}
	
}
