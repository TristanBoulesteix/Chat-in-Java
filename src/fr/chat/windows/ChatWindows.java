package fr.chat.windows;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.chat.client.Client;

public class ChatWindows {

	private String IPserver;
	private JFrame frame;
	private JTextField textField;
	private JTextField txtConverstion;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ChatWindows window = new ChatWindows();
					window.getFrame().setVisible(true);
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
		IPserver = "localhost";
		initialize();
	}

	public ChatWindows(String iP) {
		IPserver = iP;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		getFrame().getContentPane().setLayout(gridBagLayout);

		txtConverstion = new JTextField();
		txtConverstion.setText("Conversation");
		GridBagConstraints gbc_txtConverstion = new GridBagConstraints();
		gbc_txtConverstion.gridwidth = 2;
		gbc_txtConverstion.insets = new Insets(0, 0, 5, 5);
		gbc_txtConverstion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConverstion.gridx = 0;
		gbc_txtConverstion.gridy = 0;
		frame.getContentPane().add(txtConverstion, gbc_txtConverstion);
		txtConverstion.setColumns(10);

		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 15;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		frame.getContentPane().add(textArea, gbc_textArea);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 16;
		getFrame().getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setAction(action);
		GridBagConstraints gbc_btnEnvoyer = new GridBagConstraints();
		gbc_btnEnvoyer.gridx = 1;
		gbc_btnEnvoyer.gridy = 16;
		frame.getContentPane().add(btnEnvoyer, gbc_btnEnvoyer);

		JMenuBar menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);

		JButton btnMessagerie = new JButton("Chat");
		menuBar.add(btnMessagerie);

		JButton btnConversation = new JButton("Conversation");
		menuBar.add(btnConversation);

		JButton btnAide = new JButton("Aide");
		menuBar.add(btnAide);

		JButton btnPropos = new JButton("\u00C0 propos");
		menuBar.add(btnPropos);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Envoyer");
			putValue(SHORT_DESCRIPTION, "Envoyer votre message");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!textField.getText().isEmpty()) {
				String message = textField.getText();
				Client client = new Client(message, IPserver);

				client.start();

			}
		}
	}

}