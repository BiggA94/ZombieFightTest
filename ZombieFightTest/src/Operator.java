import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.LinkedBlockingDeque;

public class Operator {
	
	public static LinkedBlockingDeque<String> InputBuffer = new LinkedBlockingDeque<String>();
	
	public static File file;

	public static void handle(byte[] byteArray) {
		if(file == null){
			file = new File("test.zip");
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			FileOutputStream fileStream = new FileOutputStream(file,true);
			output.write(byteArray);
			
			fileStream.write(byteArray[byteArray.length-1]);
			
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
