package bankomat;
import cashpointcontroller.Controller;

/**
 *  Точка входа в логику симуляции (сборка нашего банкомата)
 */
/**
 * @author Vince-NT
 *
 */

public class Bankomat   implements CashPoint {
	
	private Display  		dspl =   	new Display();
	private Keyboard 		kbrd =   	new Keyboard();
	private CardReader		cardRdr;
	private CashBox  		cbox =   	new CashBox();
	private MoneyFeeder 	feeder = 	new MoneyFeeder();	
	private DataSorage  	datastore = new DataSorage();
 	private Controller 		ctrl;

	Bankomat () {
		
			ctrl 	= new Controller (this);
			cardRdr = new CardReader (this);
	}
	
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public void wake() {
		ctrl.start();
	}
	
	public void sleep() {}
	
// ------------------------------------------------------------------------------------------------------------------------------
	
	public void displaySignalSlot(String message) {   // Адаптер нужен на случай использования стороннего контроллера
		
		   dspl.typeMessage(message);
		}
	
// ------------------------------------------------------------------------------------------------------------------------------


	public Object keyboardSignalSlot(String inputStringToken) {
		
		return (String) kbrd.takeUsersAnswer(inputStringToken);
			
	} 
	
// ------------------------------------------------------------------------------------------------------------------------------

	
	public Object keyboardSignalSlot(Integer inputNumberToken) {
		
		try {
		          return kbrd.takeUsersAnswer(inputNumberToken);
		          
		} catch (Exception e) {
			
			  throw e;
		}
		
	}
	
// ------------------------------------------------------------------------------------------------------------------------------

	
	public  String CardReaderSlot() throws CardreaderException {
		
		String cardReaderAnswer = null;
		
		try {	
			
				cardReaderAnswer = cardRdr.obtainCardInfo();
				
		} catch (CardreaderException e) {

			throw e;
		}
		
		return cardReaderAnswer;
		
	}
	// ------------------------------------------------------------------------	
	

	public void giveMoney() {}
	public void receiveMoney() {}
	

	
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

     
		 Bankomat bankmt = new Bankomat();
		 bankmt.wake();
		 
		 
	};

 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
}
