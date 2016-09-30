import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Entry {
	public static void main(String[] args) throws IOException 
			{
		
		//setValue(78);		//risky method call
		
/*		try{
			setValue(78);		//risky method call
		}catch(ArithmeticException e){
			e.printStackTrace();   // logged these messages into a file
		}
*/		
		try{
		saveValue(99);
		}catch(FileNotFoundException f)
		{
			System.out.println("In main");
			f.printStackTrace();
		}
		
		System.out.println("reached end of main()....");
	}
	
	static public void setValue(int value) throws ArithmeticException{
		
		System.out.println("inside setValue()...");
		
		int denominator = 0;
		
		if(denominator > 0)
		{
			int ans = value/denominator;
		}else{
			System.out.println("cannot perform division");
		}
		
//		int ans = value/0;
		
		System.out.println("reached end of setValue()....");
		
	}
	
	public static void saveValue(int value) throws FileNotFoundException,IOException{
		FileOutputStream fOut = null;
		try{
		fOut = new FileOutputStream("\\test\\something.txt");
		}catch(FileNotFoundException d)
		{
			System.out.println("In save value");
		}finally{
			fOut.write((byte)value);
			System.out.println("Running clean-up code...");
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		try{
			FileOutputStream fOut = new FileOutputStream("\\test\\something.txt");
			fOut.write((byte)value);
		}catch(FileNotFoundException fne){
			fne.printStackTrace();		// acting on exception in saveValue
			throw fne;						// giving chance to my caller to act
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Clean-up code...");
		}
*/		
	}
}
