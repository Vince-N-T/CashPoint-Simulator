package bankomat;

public class CardreaderException extends Exception {
	
	boolean skipFlag;
	
	//.......................................
	
	CardreaderException (boolean skipFlag) {
		
		super();
		
		this.skipFlag = skipFlag;

	}
		
}
