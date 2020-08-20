package d0819.chat.swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChatClient {
	public static void main(String[] args) 	{
		String ip = "localhost";
		int port = 8080;


		ChatClientSwing ui = new ChatClientSwing( ip, port );
		ui.setTitle("SSAFY CHAT " + ip + ":" + port);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.pack();
		ui.setLocationRelativeTo(null);
		ui.setResizable(false);
		ui.setVisible(true);

        String name = JOptionPane.showInputDialog("이름을 입력하세요.");
        ui.getChatConnect().setName(name);
	}
}
