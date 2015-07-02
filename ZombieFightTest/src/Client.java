import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class Client extends ThreadObject {

	public static void main(String[] args) {
		try {
			Client client = new Client();
			Thread.sleep(3000);

			client.interrupt();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Client instance;

	public static Client getInstance() {
		return instance;
	}

	public static void setInstance(Client instance) {
		Client.instance = instance;
	}

	Socket socket;

	public Client() throws IOException, Exception {
		if (Client.getInstance() != null) {
			throw new Exception("There is already an instance of FileServerClient!");
		} else {
			setInstance(this);
		}
		this.socket = new Socket("se1.cs.uni-kassel.de", 5000);

		this.setThread(this);
		this.start();
	}

	LinkedList<Socket> connections = new LinkedList<Socket>();
	public ByteArrayOutputStream output;

	public void run() {
		output = new ByteArrayOutputStream();
		while (!Thread.interrupted()) {
			try {
				if (this.socket.getInputStream().available() > 0) {
					output.write(this.socket.getInputStream().read());
					Operator.handle(output.toByteArray());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
