/**
 * Данный класс нужен для предоставления данных внешней библиотеке Yaasson
 * которая не может работать с закрытыми членами класса!!!
 * Возможно, что нативная Java-библиотека JSON-B, которая присутствует в Java EE, лишена этого недостатка.
 * 
 */

package cashpointcontroller;
import java.util.Date;

/**
 * @author Vince-NT
 *
 */
public class CashpointUserRecordPublic {
	
	public String cardNumber ;
	public int PINnumber;
	
//    public Queue<Date> operationQueue;
	
	public Date dt = null;
	public Integer accountBalans = null ;
	
	
	
}
