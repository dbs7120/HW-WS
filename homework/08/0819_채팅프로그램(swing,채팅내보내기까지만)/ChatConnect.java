package d0819.chat.swing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatConnect {
	private String ip;
	private int port;
	private String name;
	private Socket s;

	private String saveMsg = "SAVEDATA\n";
	private SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy년 MM월dd일 HH시mm분ss초"); // 저장시 채팅시간 형식

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ChatClientSwing ui;

	public ChatConnect(ChatClientSwing ui, String ip, int port, String name) {
		this.ui = ui;
		this.ip = ip;
		this.port = port;
		this.name = name;
		connect();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void connect() {

		try {
			s = new Socket(ip, port);

			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());

			new Thread() {
				public void run() {
					try {
						while (true) {
							Date time = new Date();
							String curtime = timeFormat.format(time);
							String message = (String) ois.readObject();
							saveMsg += "|" + curtime + "| " + message + "\n"; // 채팅기록 누적
							ui.updateChat(message);
						}
					} catch (IOException | ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String msg) {
		try {
			// [사용자 이름] 메세지 형태로
			oos.writeObject("[" + name + "] " + msg);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void save() { // 파일로 채팅기록 내보내기
		String fileName = "savedata_";
		fileName += name + ".txt";

		try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write(saveMsg);
			System.out.println("파일저장 성공!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendExit() {
		try {
			oos.writeObject("^");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
