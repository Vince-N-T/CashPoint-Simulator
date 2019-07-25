package bankomat;

/**
 * Обобщенный интерфейс банкомата
 */

/**
 * @author Vince-NT
 *
 */
public interface CashPointInterface {

	void wake();
	void sleep();
	
	void displaySignalSlot(String message);
	
	Object keyboardSignalSlot(String inputStringToken);
	Object keyboardSignalSlot(Integer inputNumberToken);
	
	String  cardReaderSlot() throws CardreaderException;

	void    dataStorageSlotFlush (String data);
	String  dataStorageSlotRecover (String data);
	
//	void giveMoney();
//	void receiveMoneySignalSlot();
	
	
}
