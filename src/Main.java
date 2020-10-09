import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	private static ServerSocket SERVER_SOCKET;

	public static void main(String[] args) {

		Ventana ventana = new Ventana();

		try {
			SERVER_SOCKET = new ServerSocket(1334);
			ventana.setVisible(true);
		} catch (IOException x) {
			System.exit(0);
		}
	}
}
