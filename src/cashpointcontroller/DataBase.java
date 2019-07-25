package cashpointcontroller;

/**
 * 
 */


/**
 * @author Vince-NT
 *
 */
class DataBase {
	
	final int  		pinNumber 	= 1234;
	final String 	cardNumber 	= "1111-2222-3333-4444";
	
// ----------------------------------------------------------
	boolean verifyCardExistence (String cardNum) {
		
		return cardNum.equals(cardNumber);
	}
	
// ----------------------------------------------------------

	boolean verifyPIN (String cardNum, int pinNum) {
		
		return pinNum == pinNumber;
	}
	
	void blockUser () {}

}

//----------------------------------------------------------




//----------------------------------------------------------
