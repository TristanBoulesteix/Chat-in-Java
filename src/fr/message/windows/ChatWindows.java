package fr.message.windows;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import fr.message.AbstractMessageData;

public class ChatWindows {

	private JFrame frmChat;
	private JTextField textField;
	private JTextField textField_1;

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
		frmChat.getContentPane().setLayout(null);

		textField = new JTextField();
		Dimension dimensionTextField = new Dimension(497, 20);
		textField.setToolTipText("Écrivez votre message...");
		textField.setBounds(10, 402, 497, 20);
		textField.setPreferredSize(dimensionTextField);
		frmChat.getContentPane().add(textField);

		JButton btnNewButton = new JButton("Envoyer");
		Dimension dimensionSendButton = new Dimension(156, 23);
		btnNewButton.setBounds(518, 402, 156, 22);
		btnNewButton.setPreferredSize(dimensionSendButton);
		frmChat.getContentPane().add(btnNewButton);

		textField_1 = new JTextField();
		Dimension dimensionFieldChatHistory = new Dimension(664, 380);
		textField_1.setEditable(false);
		textField_1.setPreferredSize(dimensionFieldChatHistory);
		textField_1.setBounds(10, 11, 664, 380);
		frmChat.getContentPane().add(textField_1);

		JMenuBar menuBar = new JMenuBar();
		frmChat.setJMenuBar(menuBar);

		JMenu mnChat = new JMenu("Chat");
		menuBar.add(mnChat);

		frmChat.pack();
	}

	public void setVisible(boolean status) {
		frmChat.setVisible(status);
	}
}
