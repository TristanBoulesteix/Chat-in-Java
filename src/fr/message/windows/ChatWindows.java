package fr.message.windows;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import fr.message.AbstractMessageData;

public class ChatWindows {

	private JFrame frmChat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ChatWindows window = new ChatWindows();
					window.frmChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChat = new JFrame();
		frmChat.setTitle("Chat");
		frmChat.setBounds(100, 100, 7, 300);
		frmChat.setPreferredSize(AbstractMessageData.windowPreferedSize);
		frmChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChat.pack();
		frmChat.getContentPane().setLayout(new BoxLayout(frmChat.getContentPane(), BoxLayout.X_AXIS));
	}

}
