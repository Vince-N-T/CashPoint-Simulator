/**
 * 
 */
package cashpointcontroller;
import java.util.*;
import java.io.*;



/**
 * @author IEUser
 *
 */

 public  class CashpointUserRecord {
//    class CashpointUserRecord {
	
	private String cardNumber = "1111-2222-3333-4444";
	private	int PINnumber	  = 1234;
	
//	Queue<Date> operationQueue = new LinkedList<Date>() ;
	
	private Date dt = new Date(); 
	private int accountBalans = 0 ;
	
	
	
	
	
	//============================================================================================================

	public static CashpointUserRecordPublic getPublicClone (CashpointUserRecord originalProtectedInstance) {
		
		CashpointUserRecordPublic publicCopy = new CashpointUserRecordPublic();
		
//		CashpointUserRecord madeCopy =  (CashpointUserRecord) copyObject(originalProtectedInstance);
		CashpointUserRecord madeCopy =  originalProtectedInstance;
		
		publicCopy.cardNumber 	 = madeCopy.cardNumber;
		publicCopy.dt 			 = madeCopy.dt;
		publicCopy.accountBalans = madeCopy.accountBalans;	
		publicCopy.PINnumber 	 = madeCopy.PINnumber;	
		
		return publicCopy;
		
	}
	
	//============================================================================================================
	
	private static Object copyObject(Object objSource) {  
		
		Object objDest=null;
		
        try {
        	
            	ByteArrayOutputStream bos = new ByteArrayOutputStream();
            	ObjectOutputStream oos = new ObjectOutputStream(bos);
            
            	oos.writeObject(objSource);
            	oos.flush();
            	oos.close();
            	bos.close();
            
            
            	byte[] byteData = bos.toByteArray();
            	ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
            	
            	
            	
            	try {
            		 objDest = new ObjectInputStream(bais).readObject();
            	} catch (ClassNotFoundException e) {
            			e.printStackTrace();
            	}
        	} catch (IOException e) {
        			e.printStackTrace();
        	}
        	
        
        return  objDest;
        

    }
	//======================================================================================

}
