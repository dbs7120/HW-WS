package d0819.chat.swing;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	private ArrayList<ChatThread> chatThreadList = new ArrayList<ChatThread>(); // for boradcast
	private int port = 8080;

	public void service() {

		try (ServerSocket ss = new ServerSocket(port);) {

			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {

				Socket s = ss.accept();
				System.out.println("ChatClient 가 접속했습니다.");

				ChatThread t = new ChatThread(s);
				synchronized (chatThreadList) {
					chatThreadList.add(t);
				}
				t.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void broadcast(String message) {
		synchronized (chatThreadList) {
			for (ChatThread t : chatThreadList) {
				t.sendMessage(message);
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer().service();
	}

	class ChatThread extends Thread {

		private Socket socket = null;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private boolean isExit = false;

		public ChatThread(Socket socket) {
			this.socket = socket;
			try {
				this.ois = new ObjectInputStream(socket.getInputStream());
				this.oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public void run() {
			try {
				while (!isExit) {
					String msg = (String) ois.readObject();

					if ("/exit".contentEquals(msg)) { // 종료 명령
						synchronized (chatThreadList) {
							chatThreadList.remove(this);
						}
						isExit = true;
					} else {
						broadcast(msg);
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				synchronized (chatThreadList) {
					chatThreadList.remove(this);
				}
			}
		}

		public void sendMessage(String message) {
			try {
				oos.writeObject(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
