package bankomat;

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
	
	String CardReaderSlot() throws CardreaderException;


//	void giveMoney();
//	void receiveMoneySignalSlot();
	
	
}
