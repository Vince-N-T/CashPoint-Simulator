/**
 * ����������� ������������ ���������
 */


/**
 * @author Vince-NT
 *
 * ���� ����� ����� ���� �� ������������ ��� ���������� ����� ������ Bankomat, 
 * �� � �������� ������ �� �� ������ �� ������������ ��� � ���������� ������������ �������������������� ��������� 
 */
public final class Controller {  // ���������� �� ������������ ��������� "������" ����������� ����� ������������
	
	final CashPoint controledBankomat;
	 		
	Controller (final CashPoint bankomatInstance) { // �� ������ �������� :-)
				controledBankomat = bankomatInstance;
	}
	
	// ------------------------------------------------------------------------------------------
	
	 Integer permanentRequestForNumberImput () {
		 
		 Integer number=null;
		 

			 
				 try {
				       number = (Integer) controledBankomat.keyboardSignalSlot(number); 
				     
				} catch (Exception e) {
					   controledBankomat.displaySignalSlot("�� ����� ���������� ������ - ��� �� �����!\n���������� ��� ���:");
				}
	
	
		 return number;
	 }
	
	// ------------------------------------------------------------------------------------------
	
	void start () {
		
		controledBankomat.displaySignalSlot("���� ������ ��� � ������ ������������ ����������!"+"\n������� ��� ����� �����\n");
		
		String userInput= null;
		userInput = (String) controledBankomat.keyboardSignalSlot(userInput); 
		                  // controledBankomat.keyboardSignalSlot(userInput); // ��� ������� - ����� �������� � ��� ������ ����������
		
//		controledBankomat.displaySignalSlot("�� �����:\n" + userInput);
		
		controledBankomat.displaySignalSlot("\n������� ������:\n");
		
		Integer userPIN=null;
		
		try {
		       userPIN = (Integer) controledBankomat.keyboardSignalSlot(userPIN); 
		     
		} catch (Exception e) {
			   controledBankomat.displaySignalSlot("�� ����� ���������� ������ - ��� �� �����!");
		}
		
		
		
		controledBankomat.displaySignalSlot("\n�� ����� PIN:\n" + userPIN);
		
	}
	
	

	


}
