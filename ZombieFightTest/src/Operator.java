import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;

public class Operator {
	
	public static LinkedBlockingDeque<String> InputBuffer = new LinkedBlockingDeque<String>();

	public static void handle(byte[] byteArray) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			output.write(byteArray);
			System.err.println(byteArray[byteArray.length-1]);			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] tmp = output.toByteArray();
		
		String res;
		
		if(tmp.length > 1){
			if(tmp[tmp.length-2]==13 && tmp[tmp.length-1]==10){
				System.out.println(output.toString());
				res = output.toString();
				InputBuffer.add(res);
				Client.getInstance().output = new ByteArrayOutputStream();
			}
		}
		
	}
}
