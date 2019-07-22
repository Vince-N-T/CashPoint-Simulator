/**
 * Обобщенный интерфейс банкомата
 */

/**
 * @author Vince-NT
 *
 */
public interface CashPoint {

	void wake();
	void sleep();
	
	void displaySignalSlot(String message);
	Object keyboardSignalSlot(String inputStringToken);
	Object keyboardSignalSlot(Integer inputNumberToken);
	
//	void informUser();
//	void queryUser();

//	void giveMoney();
//	void receiveMoneySignalSlot();
	
	void takeCard();
	void returnCard();	
}
