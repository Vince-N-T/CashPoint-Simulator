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
	private CashBox  		cbox =   	new CashBox();
	private MoneyFeeder 	feeder = 	new MoneyFeeder();	
	private DataSorage  	datastore = new DataSorage();
 	 			Controller 		ctrl;

	Bankomat () {
		ctrl = new Controller (this);
	}
	
	// ========================================================================
	
	public void wake() {
		ctrl.start();
	}
	
	public void sleep() {}
	
	// ------------------------------------------------------------------------
	public void displaySignalSlot(String message) {   // Адаптер нужен на случай использования стороннего контроллера
		   dspl.typeMessage(message);
		}
	// ------------------------------------------------------------------------

	public Object keyboardSignalSlot(String inputStringToken) {
		
		return (String) kbrd.takeUsersAnswer(inputStringToken);
			
	}
	
	public Object keyboardSignalSlot(Integer inputNumberToken) {
		
		try {
		          return kbrd.takeUsersAnswer(inputNumberToken);
		   
		} 
		catch (Exception e) {
			throw e;
		}
		
	}
	
	
	
	// ------------------------------------------------------------------------	
	
	
	
	
	public void informUser() {
			
	}
	
	
	public void queryUser() {}

	public void giveMoney() {}
	public void receiveMoney() {}
	
	public void takeCard() {}
	public void returnCard() {}	
	
	// ==============================================
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 System.out.println("Hello money!");

     
		 Bankomat bankmt = new Bankomat();
		 bankmt.wake();
		 
		 
		 
//		 bankmt.ctrl.testDostupa(bankmt.dspl);
	};

	
	
}
