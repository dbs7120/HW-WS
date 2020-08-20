package d0819.chat.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientSwing extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextArea textArea;
	private JTextField inputTextField;
	private JButton sendButton;
	private JButton saveButton;

	private ChatConnect chatConnect;
	private String name;

	public ChatClientSwing(String ip, int port) {
		chatConnect = new ChatConnect(this, ip, port, name);
		createUI();
	}

	public ChatConnect getChatConnect() {
		return chatConnect;
	}

	private void createUI() {
		textArea = new JTextArea(20, 50);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		Box box = Box.createHorizontalBox();
		add(box, BorderLayout.SOUTH);
		inputTextField = new JTextField();
		sendButton = new JButton("Send");
		saveButton = new JButton("Save");
		box.add(inputTextField);
		box.add(sendButton);
		box.add(saveButton);

		ActionListener sendListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 사용자 입력 값
				String str = inputTextField.getText();
				if (str != null && str.trim().length() > 0) {
					chatConnect.send(str);
				}
				inputTextField.selectAll();
				inputTextField.requestFocus();
				inputTextField.setText("");
			}
		};
		ActionListener saveListener = new ActionListener() { // 저장 리스너
			public void actionPerformed(ActionEvent e) {
				chatConnect.save();
				updateChat("저장완료");
			}
		};

		inputTextField.addActionListener(sendListener);
		sendButton.addActionListener(sendListener);
		saveButton.addActionListener(saveListener);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				chatConnect.sendExit();

			}
		});
	}

	public void updateChat(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
}
