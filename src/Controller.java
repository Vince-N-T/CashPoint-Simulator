/**
 * Управлнение устройствами банкомата
 */


/**
 * @author Vince-NT
 *
 * Этот класс можно было бы организовать как внутренний класс класса Bankomat, 
 * но в подобном случае мы не смогли бы использовать его с сторонними реализациями стандартизированного банкомата 
 */
public final class Controller {  // защищаемся от подсовывания банкомату "левого" контроллера через наследование
	
	final CashPoint controledBankomat;
	 		
	Controller (final CashPoint bankomatInstance) { // на всякий пожарный :-)
				controledBankomat = bankomatInstance;
	}
	
	// ------------------------------------------------------------------------------------------
	
	 Integer permanentRequestForNumberImput () {
		 
		 Integer number=null;
		 

			 
				 try {
				       number = (Integer) controledBankomat.keyboardSignalSlot(number); 
				     
				} catch (Exception e) {
					   controledBankomat.displaySignalSlot("Вы ввели невалидную строку - это не цифра!\nПопробуйте еще раз:");
				}
	
	
		 return number;
	 }
	
	// ------------------------------------------------------------------------------------------
	
	void start () {
		
		controledBankomat.displaySignalSlot("Рады видеть Вас в службе виртуальныхс банкоматов!"+"\nВведите ваш номер карты\n");
		
		String userInput= null;
		userInput = (String) controledBankomat.keyboardSignalSlot(userInput); 
		                  // controledBankomat.keyboardSignalSlot(userInput); // как вариант - будет работать и без явного присвоения
		
//		controledBankomat.displaySignalSlot("Вы ввели:\n" + userInput);
		
		controledBankomat.displaySignalSlot("\nВведите пароль:\n");
		
		Integer userPIN=null;
		
		try {
		       userPIN = (Integer) controledBankomat.keyboardSignalSlot(userPIN); 
		     
		} catch (Exception e) {
			   controledBankomat.displaySignalSlot("Вы ввели невалидную строку - это не цифра!");
		}
		
		
		
		controledBankomat.displaySignalSlot("\nВы ввели PIN:\n" + userPIN);
		
	}
	
	

	


}
