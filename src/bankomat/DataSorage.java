package bankomat;
import  cashpointcontroller.*;
import java.io.*;


/**
 *  Хранение состояния банкомата
 */

/**
 * @author IEUser
 *
 */
public class DataSorage {
	
	
	
 // --------------------------------------------------------------------------------------------------------------------------
	void saveData(String dataToSave) throws IOException {
	
		
		DataOutputStream out = new DataOutputStream( new BufferedOutputStream 
				  ( new FileOutputStream ("DataStore.txt") ) );

					out.writeUTF(dataToSave);
					out.close();

	}
	
 // --------------------------------------------------------------------------------------------------------------------------

	String readData () throws IOException {
		
		DataInputStream  in = new DataInputStream ( new BufferedInputStream 
																			( new FileInputStream ("DataStore.txt") ) );
		
		
		String s;
	
		s = in.readUTF();
		in.close();
		
		return s;

	}
	
 // --------------------------------------------------------------------------------------------------------------------------

	
}
