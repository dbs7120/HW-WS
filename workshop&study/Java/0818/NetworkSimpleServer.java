package d0818;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkSimpleServer {

	public static void main(String[] args) {
		int port = 5100;

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("NetworkSimpleServer Started");
			while (true) {
				Socket socket = serverSocket.accept(); // 브레이크 명령문 (holding (접속대기))
				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true);
				writer.println("Hello SSAFY!");
			}

		} catch (IOException e) {
			System.out.println("NetworkSimpleServer exception: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("NetworkSimpleServer Ended");
	}
}
